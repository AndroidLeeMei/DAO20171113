package com.example.auser.dao20171113;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.auser.dao20171113.data.Student;
import com.example.auser.dao20171113.data.StudentDAO;
import com.example.auser.dao20171113.data.StudentDAOFileImpl;
import com.example.auser.dao20171113.data.StudentDAOMemoryImpl;

import java.util.ArrayList;

public class ListViewDAO extends AppCompatActivity implements  RecyclerView.OnItemTouchListener{
//    public static StudentDAOMemoryImpl t=new StudentDAOMemoryImpl();
    public static StudentDAOFileImpl t;
    RecyclerView myRecyclerView;
    RecyclerView.Adapter<MyAdapter.ViewHolder> mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    GestureDetector mGD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_dao);
        t=new StudentDAOFileImpl(this);
        myRecyclerView=(RecyclerView)findViewById(R.id.myRecycleView);
        myRecyclerView.setHasFixedSize(false);
        mLayoutManager=new LinearLayoutManager(ListViewDAO.this);
        myRecyclerView.setLayoutManager(mLayoutManager);
        t.add(new Student("Bob","Bphone","Baddr"));
        t.add(new Student("Mary","Mphone","Maddr"));
        mGD = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        }
        );
        myRecyclerView.addOnItemTouchListener(this);
//      mGD = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener());
//        mGD = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener()
//        {
//            @Override
//            public boolean onSignleTapUp(MotionEvent e){
//                return true;
//            }
//        }
//        );






    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter=new MyAdapter(ListViewDAO.this,t.getData());
        myRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.mymenu, menu); //選單出現在toolbar
        menu.add("ADD");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it = new Intent(ListViewDAO.this, ListViewADD2DAO.class);
        startActivity(it);
//        if (item.getItemId() == R.id.menu_add)
//        {
//            Intent it = new Intent(ListViewDAO.this, ListViewADD2DAO.class);
//            startActivity(it);
//        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View v=rv.findChildViewUnder(e.getX(),e.getY());
        if (mGD.onTouchEvent(e)) {
            int position = rv.getChildLayoutPosition(v);
//            Toast.makeText(ListViewDAO.this, "posi:" + position, Toast.LENGTH_SHORT).show();
            if (position >= 0) {
                Intent it = new Intent(ListViewDAO.this, ListViewDetailDAO.class);
                it.putExtra("id", t.getData()[position].id);
                it.putExtra("name", t.getData()[position].name);
                it.putExtra("tel", t.getData()[position].tel);
                it.putExtra("addr", t.getData()[position].addr);
                startActivity(it);
            }
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
