package com.example.vaibhav.cb_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList;
    RecyclerView recyclerView;
    EditText etName;
    EditText etCourse;
    Button btnAdd;
    StudentRecyclerAdapter studentRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout_student);
        studentArrayList=generateStudents();
        recyclerView=(RecyclerView)findViewById(R.id.rvStudent);
        etName=(EditText)findViewById(R.id.etName);
        etCourse=(EditText)findViewById(R.id.etCourse);
        btnAdd=(Button)findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudent();
            }
        });









        studentRecyclerAdapter=new StudentRecyclerAdapter(studentArrayList,this);
        // Define Layout of recycler view before setAdapter
        // Using recycler view we can make grid as well , so need to define the layout to make grid or list , or else it will crashed
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
/*
        for reverse list ->
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
*/
        recyclerView.setAdapter(studentRecyclerAdapter);
    }
    public static ArrayList<Student> generateStudents(){
        ArrayList arrayList=new ArrayList<>();
/*
        arrayList.add(new Student("A","Pandora"));
        arrayList.add(new Student("B","Elixir"));
        arrayList.add(new Student("C","Crux"));
        arrayList.add(new Student("D","Pandora"));
        arrayList.add(new Student("E","Elixir"));
        arrayList.add(new Student("A","Crux"));
        arrayList.add(new Student("A","Pandora"));
        arrayList.add(new Student("A","Elixir"));
        arrayList.add(new Student("B","Elixir"));
        arrayList.add(new Student("C","Crux"));
        arrayList.add(new Student("D","Pandora"));
*/

        return arrayList;
    }

    public void addStudent(){
        String name=etName.getText().toString().trim();
        String course=etCourse.getText().toString().trim();

        studentArrayList.add(new Student(name,course));
        studentRecyclerAdapter.notifyDataSetChanged();
        etName.setText("");
        etCourse.setText("");
        // gets focus to etName from etCourse
        etCourse.clearFocus();
    }
}
