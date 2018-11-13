package com.gogocita.admin.helper;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.Query;

import java.util.Map;


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

        if (queryFirebase.entityName != entityName){
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
                if(parentId != null)
                mDatabase = mDatabase.child(parentId);
            }
        }

        Query query = mDatabase;

        if(orderByChild != null){
            query = query.orderByChild(orderByChild).equalTo(equalTo);
        }

        return query;
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

//    public void getFirstOrDeFault(){
//        getReference();
//        mDatabase.addValueEventListener( new ValueEventListener() {
//            T modelClass = null;
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // Get Post object and use the values to update the UI
//                modelClass = (T) dataSnapshot.getValue();
//                // ...
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                // ...
//            }
//        });
//    }

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
