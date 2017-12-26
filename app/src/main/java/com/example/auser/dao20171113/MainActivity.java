package com.example.auser.dao20171113;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.auser.dao20171113.data.Student;
import com.example.auser.dao20171113.data.StudentDAOMemoryImpl;
import com.example.auser.dao20171113.data.StudentDAOTest1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //第二版
        StudentDAOMemoryImpl t=new StudentDAOMemoryImpl();
        t.add(new Student("Bob","123","aabb"));
        t.add(new Student("Mary","234","ccdd"));

        Student[] mylist=t.getData();
        for (Student s:mylist){
            Log.d("DTAS",s.toString());
        }

        //update
        Student editStudent=mylist[0];
        editStudent.tel="987";
        t.update(editStudent);

        for (Student s:mylist){
            Log.d("DTAS",s.toString());
        }

//      第一版
//        StudentDAOTest1 t=new StudentDAOTest1();
//        t.add(new Student("Bob","123","aabb"));
//        t.add(new Student("Mary","234","ccdd"));
//
//        ArrayList<Student> mylist=t.getData();
//        for (Student s:mylist){
//            Log.d("DTAS",s.toString());
//        }
//
//        //update
//        Student editStudent=mylist.get(0);
//        editStudent.tel="987";
//        t.update(editStudent);
//
//        for (Student s:mylist){
//            Log.d("DTAS",s.toString());
//        }




    }
}
