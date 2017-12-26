package com.example.auser.dao20171113.data;

import java.util.ArrayList;

/**
 * Created by auser on 2017/11/13.
 */

public class StudentDAOMemoryImpl implements StudentDAO{
    ArrayList<Student> data =new ArrayList();
    int MaxId=1;

    @Override
    public void aa(){

    }

    @Override
    public void delete(Student s) {
        for (int i=data.size()-1;i>=0;i--){
            if (data.get(i).id==s.id){
                data.remove(i);
                break;
            }
        }
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public Student getOneStudent(int id) {
        return data.get(id);
    }

    @Override
    public Student[] searchByName(String name) {
        ArrayList<Student> als=new ArrayList<>();
        for (Student s:data){
            if (s.name.equals(name)){
                als.add(s);
            }
        }
        return als.toArray(new Student[als.size()]);
    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public void add(Student s) {
        s.id=MaxId;
        data.add(s);
        MaxId++;
    }

    @Override
    public Student[] getData() {

        return data.toArray(new Student[data.size()]);
    }
//       dao.update(new Student("CCC","333","cccc"));
    @Override
    public void update(Student s) {
        for (Student temp:data){
            if (temp.id==s.id){
                temp.name=s.name;
                temp.tel=s.tel;
                temp.addr=s.addr;
            }
        }
    }
}
