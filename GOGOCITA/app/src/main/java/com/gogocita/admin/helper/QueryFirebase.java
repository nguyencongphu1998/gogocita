package com.gogocita.admin.helper;

import android.util.Log;

import com.gogocita.admin.entity.ConfigValue;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import static com.facebook.login.widget.ProfilePictureView.TAG;

public class QueryFirebase{
    private static DatabaseReference mDatabase;
    private String entity;

    public QueryFirebase(String entity) {
        this.entity = entity;
    }

    private void getReference()
    {
        mDatabase = FirebaseDatabase.getInstance().getReference(entity);
    }

    public String getNewKey(){
        getReference();
        return mDatabase.push().getKey();
    }

    //Quan hệ 1 - n , 1 - 1
    public void InsertChildren(Object newObject ,String[] parentIds, String objectId){
        for (String i : parentIds) {
            mDatabase = mDatabase.child(i);
        }
        mDatabase.child(objectId).setValue(newObject);
    }

    public void Insert(Object newObject,String objectId){
        getReference();
        mDatabase.child(objectId).setValue(newObject);
    }

    public void UpdateChildren(Map<String, Object> updatedObject ,String[] parentIds, String objectId){
        for (String i : parentIds) {
            mDatabase = mDatabase.child(i);
        }
        mDatabase.child(objectId).setValue(updatedObject);
    }

    //Ap dụng cho những nhánh có nhánh con
    public void Update(Map<String, Object> updatedObject,String objectId){
        getReference();
        mDatabase.child(objectId).updateChildren(updatedObject);
    }

    /*public ConfigValue getAll(String id){
        getReference();
        mDatabase.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ConfigValue value = dataSnapshot.getValue(ConfigValue.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }*/


}
