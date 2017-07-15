package com.example.nguyenlinh.studentsprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView= (ListView) findViewById(R.id.lvStudents);
    }

    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(MyContentProvider.NAME,
                ((EditText)findViewById(R.id.edtName)).getText().toString());

        values.put(MyContentProvider.GRADE,
                ((EditText)findViewById(R.id.edtGrade)).getText().toString());

        Uri uri = getContentResolver().insert(
                MyContentProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }
    public void onClickRetrieveStudents(View view) {
        final List<Student> studentList = new ArrayList<>();
        // Retrieve student records
        String URL = "content://com.example.nguyenlinh.studentsprovider.provider";

        Uri studentUri = Uri.parse(URL);
        /*
         * managedQuery() is deprecated.
         * You could replace it with context.getContentResolver().query
         */
        Cursor c = getContentResolver().query(studentUri, null, null, null, "name");

        if (c.moveToFirst()) {
            do{
//                Toast.makeText(this,
//                        c.getString(c.getColumnIndex(MyContentProvider._ID)) +
//                                ", " +  c.getString(c.getColumnIndex( MyContentProvider.NAME)) +
//                                ", " + c.getString(c.getColumnIndex( MyContentProvider.GRADE)),
//                        Toast.LENGTH_SHORT).show();
                Student student=new Student();
                student.setID(c.getString(c.getColumnIndex(MyContentProvider._ID)));
                student.setName(c.getString(c.getColumnIndex(MyContentProvider.NAME)));
                student.setGrade(c.getString(c.getColumnIndex(MyContentProvider.GRADE)));
                studentList.add(student);
            } while (c.moveToNext());
        }

        ListAdapter adapter=new ListAdapter(this,R.layout.layout_student,studentList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),studentList.get(i).getID()+" vi tri"+i,Toast.LENGTH_LONG).show();
            }
        });
    }
}
