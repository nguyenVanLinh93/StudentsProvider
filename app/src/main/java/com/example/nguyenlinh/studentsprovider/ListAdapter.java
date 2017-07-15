package com.example.nguyenlinh.studentsprovider;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nguyenlinh on 15/07/2017.
 */

public class ListAdapter extends ArrayAdapter<Student> {
    public ListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Student> item) {
        super(context, resource, item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.layout_student, null);
        }

        Student student = getItem(position);
        if (student != null) {
            // Anh xa + Gan gia tri
            TextView txtName = (TextView) view.findViewById(R.id.txtvName);
            txtName.setText(student.getName());

            TextView txtGrade = (TextView) view.findViewById(R.id.txtvGrade);
            txtGrade.setText(student.getGrade());
        }
        return view;
    }
}
