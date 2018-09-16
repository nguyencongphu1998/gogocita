package com.gogocita.admin.helper;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.gogocita.admin.entity.ConfigValue;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.view.View.combineMeasuredStates;
import static com.facebook.login.widget.ProfilePictureView.TAG;

public class QueryFirebase<T>{
    private DatabaseReference mDatabase;
    private String entityName;
    private static QueryFirebase queryFirebase = null;

    private QueryFirebase(String entityName)
    {
        this.entityName = entityName;
    }



    public static QueryFirebase getInstance(String entityName)
    {
        if (queryFirebase == null) {
            queryFirebase = new QueryFirebase(entityName);
        }
        return queryFirebase;
    }


    private void getReference()
    {
        mDatabase = FirebaseDatabase.getInstance().getReference(entityName);
    }

    public Query getReferenceToSearch(String[] parentIds,String orderByChild,String equalTo)
    {
        getReference();
        if(parentIds != null)
        {
            for (String parentId : parentIds)
            {
                mDatabase = mDatabase.child(parentId);
            }
        }
        return mDatabase.orderByChild(orderByChild).equalTo(equalTo);
    }

    public String getNewKey(){
        getReference();
        return mDatabase.push().getKey();
    }

    //Quan hệ 1 - n , 1 - 1
    public void InsertChildren(T newObject ,String[] parentIds, String objectId){
        getReference();
        for (String parentId : parentIds) {
            mDatabase = mDatabase.child(parentId);
        }
        mDatabase.child(objectId).setValue(newObject);
    }

    public void Insert(T newObject,String objectId){
        getReference();
        mDatabase.child(objectId).setValue(newObject);
    }

    public void UpdateChildren(Map<String, Object> updatedObject ,String[] parentIds, String objectId){
        getReference();
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

//    public void getAll(final ArrayList<T> objects, final ArrayAdapter adapter){
//        getReference();
//        mDatabase.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                objects.add((T)dataSnapshot.getValue());
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.e("FirebaseListAdapter", "Listen was cancelled, no more updates will occur");
//            }
//        });
//    }
}
