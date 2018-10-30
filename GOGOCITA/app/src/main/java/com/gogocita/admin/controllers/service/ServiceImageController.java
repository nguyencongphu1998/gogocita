package com.gogocita.admin.controllers.service;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.ServiceImageType;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.entity.PartnerServiceImage;
import com.gogocita.admin.helper.ImageAdapter;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.List;

public class ServiceImageController {
    private QueryFirebase<PartnerServiceImage> queryFirebase;
    private static ServiceImageController serviceImageController = null;
    private Activity activity;
    private ProgressBar progressBar;
    private ServiceController serviceController;

    private ServiceImageController(Activity activity, ProgressBar progressBar)
    {
        this.activity = activity;
        this.progressBar = progressBar;
        queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServiceImages);
    }

    public static ServiceImageController getInstance(Activity activity, ProgressBar progressBar){
        if (serviceImageController == null){
            serviceImageController = new ServiceImageController(activity,progressBar);
        }else {
            serviceImageController.progressBar = progressBar;
            serviceImageController.activity = activity;
        }
        return serviceImageController;
    }

    public void updateOrInsert(PartnerServiceImage partnerServiceImage){
        queryFirebase.UpdateChildren(partnerServiceImage.toMapUpdate(),new String[]{partnerServiceImage.getFk_PartnerServiceID(),partnerServiceImage.getPartnerServiceImageType()},partnerServiceImage.getPartnerServiceImageID());
    }

    public void uploadImage(Uri imageUri, final PartnerServiceImage image, String fileExtension, StorageTask uploadTask)
    {
        StorageReference fileReference = FirebaseStorage.getInstance().getReference(EntityName.PartnerServiceImages)
                .child(image.getFk_PartnerServiceID())
                .child(image.getPartnerServiceImageType())
                .child(System.currentTimeMillis()
                + "." + fileExtension);

        uploadTask = fileReference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //Hàm delay
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(0);
                            }
                        }, 500);

                        Toast.makeText(activity, "Upload successful", Toast.LENGTH_LONG).show();

                        if(image.getPartnerServiceImageType().equals(ServiceImageType.coverPhoto)){
                            serviceController = ServiceController.getInstance(activity,progressBar);

                            PartnerService partnerServiceToUpdate = new PartnerService();
                            partnerServiceToUpdate.setPartnerserviceCoverPhotoLink(taskSnapshot.getDownloadUrl().toString());
                            serviceController.updateCoverPhoto(partnerServiceToUpdate,FirebaseAuth.getInstance().getUid());
                        }
                        else
                        {
                            image.setPartnerServiceImageLink(taskSnapshot.getDownloadUrl().toString());
                            serviceImageController.updateOrInsert(image);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                        progressBar.setProgress((int) progress);
                    }
                });
    }

    public void getAllImages(final List<PartnerServiceImage> images, final ImageAdapter adapter,String serviceId ,String imageType)
    {

        progressBar.setVisibility(View.VISIBLE);
        FirebaseDatabase.getInstance()
                .getReference(EntityName.PartnerServiceImages)
                .child(serviceId)
                .child(imageType)
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                images.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    PartnerServiceImage upload = postSnapshot.getValue(PartnerServiceImage.class);
                    images.add(upload);
                }

                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(activity, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void deleteImage(final PartnerServiceImage partnerServiceImage)
    {
        StorageReference imageRef = FirebaseStorage.getInstance()
                .getReferenceFromUrl(partnerServiceImage.getPartnerServiceImageLink());
        imageRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                FirebaseDatabase.getInstance()
                        .getReference(EntityName.PartnerServiceImages)
                        .child(partnerServiceImage.getPartnerServiceImageID()).removeValue();
                Toast.makeText(activity, "Image is deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
