package com.noveogroup.university_android_task2.PersonRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noveogroup.university_android_task2.R;
import com.noveogroup.university_android_task2.data.model.Gender;
import com.noveogroup.university_android_task2.data.model.Person;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<Person> mDataSet;

    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView mName;
        TextView mAge;
        TextView mGender;

        ViewHolder(View v) {
            super(v);
            mName = (TextView) v.findViewById(R.id.person_view_name);
            mAge = (TextView) v.findViewById(R.id.person_view_age);
            mGender = (TextView) v.findViewById(R.id.person_view_gender);
        }
    }

    public RecyclerViewAdapter(ArrayList<Person> data) {
        this.mDataSet = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = mDataSet.get(position);
        holder.mName.setText(person.getName());
        holder.mAge.setText(String.valueOf(person.getAge()));
        holder.mGender.setText(
                person.getGender() == Gender.MALE ? "man" : "woman"
        );
    }

    public List<Person> getItems() {
        return mDataSet;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setItems(final List<Person> newItems) {
        mDataSet.clear();
        mDataSet.addAll(newItems);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
