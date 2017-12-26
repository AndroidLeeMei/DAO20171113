package com.example.auser.dao20171113.data;

import java.util.ArrayList;

/**
 * Created by auser on 2017/11/13.
 */

public class StudentDAOTest1 {
    ArrayList<Student> data =new ArrayList();
    int MaxId=1;
    public void add(Student s){
        s.id=MaxId;
        data.add(s);
        MaxId++;
    }
    public ArrayList<Student> getData(){
        return data;
    }

    public void update(Student s){

        for (Student temp:data){
            if (temp.id==s.id){
                temp.name=s.name;
                temp.tel=s.tel;
                temp.addr=s.addr;
            }
        }
    }


    public void set(Student s){
        for (int i=0;i<=data.size();i++){
                if (s.id == data.get(i).id)
                data.set(i,s);
            }
        }


}
