package com.gogocita.admin.helper;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FirebaseListAdapter<T> extends BaseAdapter {

    private Query ref;
    private Class<T> modelClass;
    private int layout;
    private LayoutInflater inflater;
    private List<T> models;
    private Map<String, T> modelNames;
    private ChildEventListener listener;


    public FirebaseListAdapter(Query ref, Class<T> modelClass, int layout, Context context) {
        this.ref = ref;
        this.modelClass = modelClass;
        this.layout = layout;
        inflater = (LayoutInflater.from(context));
        models = new ArrayList<T>();
        modelNames = new HashMap<String, T>();
        // Look for all child events. We will then map them to our own internal ArrayList, which backs ListView
        listener = this.ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {

                T model = dataSnapshot.getValue(FirebaseListAdapter.this.modelClass);
                modelNames.put(dataSnapshot.getKey(), model);

                // Insert into the correct location, based on previousChildName
                if (previousChildName == null) {
                    models.add(0, model);
                } else {
                    T previousModel = modelNames.get(previousChildName);
                    int previousIndex = models.indexOf(previousModel);
                    int nextIndex = previousIndex + 1;
                    if (nextIndex == models.size()) {
                        models.add(model);
                    } else {
                        models.add(nextIndex, model);
                    }
                }

                notifyChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                // One of the models changed. Replace it in our list and name mapping
                String modelName = dataSnapshot.getKey();
                T oldModel = modelNames.get(modelName);
                T newModel = dataSnapshot.getValue(FirebaseListAdapter.this.modelClass);

                int index = models.indexOf(oldModel);
                if(index >= 0)
                {
                    models.set(index , newModel);
                }else {
                    models.add(newModel);
                }

                modelNames.put(modelName, newModel);

                notifyChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                // A model was removed from the list. Remove it from our list and the name mapping
                String modelName = dataSnapshot.getKey();
                T oldModel = modelNames.get(modelName);
                models.remove(oldModel);
                modelNames.remove(modelName);
                notifyChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {

                // A model changed position in the list. Update our list accordingly
                String modelName = dataSnapshot.getKey();
                T oldModel = modelNames.get(modelName);
                T newModel = dataSnapshot.getValue(FirebaseListAdapter.this.modelClass);
                int index = models.indexOf(oldModel);
                models.remove(index);
                if (previousChildName == null) {
                    models.add(0, newModel);
                } else {
                    T previousModel = modelNames.get(previousChildName);
                    int previousIndex = models.indexOf(previousModel);
                    int nextIndex = previousIndex + 1;
                    if (nextIndex == models.size()) {
                        models.add(newModel);
                    } else {
                        models.add(nextIndex, newModel);
                    }
                }
                notifyChanged();
            }

            @Override
            public void onCancelled(DatabaseError e) {
                Log.e("FirebaseListAdapter", "Listen was cancelled, no more updates will occur");
            }
        });
    }

    public void cleanup() {
        // We're being destroyed, let go of our listener and forget about all of the models
        ref.removeEventListener(listener);
        models.clear();
        modelNames.clear();
    }

    public void notifyChanged(){
        this.models = modifyArrayAdapter(this.models);

        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int i) {
        return models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            // inflate the layout
            view = inflater.inflate(layout, null);

            // set up the ViewHolder
            viewHolder = new ViewHolder();
            getViewHolder(viewHolder,view);

            // store the holder with the view
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        T model = models.get(i);
        // Call out to subclass to marshall this model into the provided view
        setViewHolder(viewHolder, model);
        addListener(viewHolder, model);
        return view;
    }

    protected abstract void getViewHolder(ViewHolder vh,View v);
    protected abstract void setViewHolder(ViewHolder vh, T model);
    protected abstract void addListener(ViewHolder vh, T model);
    protected abstract List<T> modifyArrayAdapter(List<T> models); //Used for modifying the model list before populating
}
