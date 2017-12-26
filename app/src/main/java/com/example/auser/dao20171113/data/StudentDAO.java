package com.example.auser.dao20171113.data;

import java.util.ArrayList;

/**
 * Created by auser on 2017/11/13.
 */

public interface StudentDAO {
    void add(Student s);
//    ArrayList<Student> getData();
    Student[] getData();
    void update(Student s);

    void aa();
    void delete(Student s);
    void clear();
    Student getOneStudent(int id);
    Student[] searchByName(String name);
    int getCount();

}
