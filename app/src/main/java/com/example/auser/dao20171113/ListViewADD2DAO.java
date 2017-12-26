package com.example.auser.dao20171113;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.auser.dao20171113.data.Student;
import com.example.auser.dao20171113.data.StudentDAOMemoryImpl;

public class ListViewADD2DAO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_add2dao);
    }

    public void clickAdd(View v)
    {
//        SQLiteDatabase db = SQLiteDatabase.openDatabase(DBInfo.DB_FILE, null, SQLiteDatabase.OPEN_READWRITE);
        EditText ed1 = (EditText)findViewById(R.id.editText);
        EditText ed2 = (EditText)findViewById(R.id.editText2);
        EditText ed3 = (EditText)findViewById(R.id.editText3);

        String username = ed1.getText().toString();
        String tel = ed2.getText().toString();
        String addr = ed3.getText().toString();

        ListViewDAO.t.add(new Student(username,tel,addr));

        finish();
    }
}
