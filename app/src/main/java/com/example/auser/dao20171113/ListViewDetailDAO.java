package com.example.auser.dao20171113;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.auser.dao20171113.data.Student;

public class ListViewDetailDAO extends AppCompatActivity {
    int id_field;
    String name_field,tel_field,addr_field;
    TextView txId,txName,txTel,txAddr;
    Student s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_detail_dao);
        Intent it=getIntent();

        id_field=it.getIntExtra("id",-1);
        name_field=it.getStringExtra("name");
        addr_field=it.getStringExtra("addr");
        tel_field=it.getStringExtra("tel");
//        s=ListViewDAO.t.getOneStudent(id_field-1);
//        Toast.makeText(this,"按下的是第"+s.id+","+s.addr,Toast.LENGTH_SHORT).show();

        Toast.makeText(this,"按下的是第"+id_field + ","
                +name_field+","+tel_field+","+addr_field,Toast.LENGTH_SHORT).show();

        txId=(TextView)findViewById(R.id.txtId);
        txName=(TextView)findViewById(R.id.txtName);
        txTel=(TextView)findViewById(R.id.txtTel);
        txAddr=(TextView)findViewById(R.id.txtAddr);
//txId,txName,txTel,txAddr
//        txId.setText(id_field+"");
//        txName.setText(name_field);
//        txAddr.setText(addr_field);
//        txTel.setText(tel_field);
    }
    @Override
    protected void onResume() {
        super.onResume();
        s = ListViewDAO.t.getOneStudent(id_field-1);
        txId.setText(String.valueOf(s.id));
        txName.setText(s.name);
        txTel.setText(s.tel);
        txAddr.setText(s.addr);
    }
    public void onDeleteClick(View target){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(R.string.delele_confirm);
        builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(this,"sure",Toast.LENGTH_SHORT).show();
//                ListViewDAO.t.delete(s);
                ListViewDAO.t.delete(s);
                finish();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    builder.show();
    }
    public void onCancelClick(View target){
        finish();
    }

    public void clickEdit(View target){
        Intent it = new Intent(ListViewDetailDAO.this, ListViewEditDAO.class);
        it.putExtra("id", id_field-1);
        startActivity(it);

    }
}
