package com.example.auser.dao20171113;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.auser.dao20171113.data.Student;

public class ListViewEditDAO extends AppCompatActivity {
    int id;
    Student stu;
    EditText ed1, ed2, ed3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_edit_dao);
        ed1 = (EditText) findViewById(R.id.editText4);
        ed2 = (EditText) findViewById(R.id.editText5);
        ed3 = (EditText) findViewById(R.id.editText6);
        id = getIntent().getIntExtra("id", -1);
        stu = ListViewDAO.t.getOneStudent(id);
        ed1.setText(stu.name);
        ed2.setText(stu.tel);
        ed3.setText(stu.addr);
    }

    public void clickUpdate(View v)
    {
        stu.name = ed1.getText().toString();
        stu.tel = ed2.getText().toString();
        stu.addr = ed3.getText().toString();
        ListViewDAO.t.update(stu);
        finish();
    }
    public void clickBack(View v)
    {
        finish();
    }
}
