package com.gogocita.admin.helper;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.gogocita.admin.entity.ConfigValue;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.facebook.login.widget.ProfilePictureView.TAG;

public class QueryFirebase<T>{
    private static DatabaseReference mDatabase;
    private static String entity;
    private static QueryFirebase queryFirebase = null;

    private QueryFirebase() {
        this.entity = entity;
    }

    public static QueryFirebase getInstance(){
        if (queryFirebase == null){
            queryFirebase = new QueryFirebase();
        }
        return queryFirebase;
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
    public void InsertChildren(T newObject ,String[] parentIds, String objectId){
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

    public List<T> getAll(){
        getReference();
        final List<T> objects = new ArrayList<T>();
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                T object = (T)dataSnapshot.getValue();
                objects.add(object);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return objects;
    }


}
