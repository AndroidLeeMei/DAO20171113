package com.example.auser.dao20171113.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by auser on 2017/11/15.
 */

public class StudentDAOFileImpl implements  StudentDAO {

    ArrayList<Student> data ;
    Context context;
    String DATA_FILE;
    public StudentDAOFileImpl(Context context)
    {
        this.context = context;
        DATA_FILE = context.getFilesDir().getAbsolutePath() + File.separator + "mydata.json";
        data=new ArrayList<>();
        loadData();
    }
    private  void saveData(){
        try {
            FileWriter fw=new FileWriter(DATA_FILE);
            Gson gson=new Gson();
            String str=gson.toJson(data);
            fw.write(str);
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private  void loadData(){
        try {
            FileReader fr=new FileReader(DATA_FILE);
            BufferedReader br=new BufferedReader(fr);
            String str=br.readLine();
            br.close();
            fr.close();
            Gson gson=new Gson();
            Type listType=new TypeToken<ArrayList<String>>(){}.getType();//這一行從網路上複製來的
            data=gson.fromJson(str,listType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void add(Student s) {
        data.add(s);
        saveData();
    }

    @Override
    public Student[] getData() {
        return new Student[0];
//        return data.toArray(new Student[data.size()]);
    }

    @Override
    public void update(Student s) {

    }

    @Override
    public void aa() {

    }

    @Override
    public void delete(Student s) {

    }

    @Override
    public void clear() {
        data.clear();
        saveData();
    }

    @Override
    public Student getOneStudent(int id) {
        return null;
    }

    @Override
    public Student[] searchByName(String name) {
        return new Student[0];
    }

    @Override
    public int getCount() {
        return 0;
    }
}
