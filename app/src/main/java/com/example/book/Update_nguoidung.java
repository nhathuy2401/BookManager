package com.example.book;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.book.DAO.NguoidungDAO;


public class Update_nguoidung extends AppCompatActivity {
    EditText edfullname, edphone;
    NguoidungDAO nguoiDungDAO;
    String username, fullname, phone;
    Button btnUpdate, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("chi tiết người dùng");
        setContentView(R.layout.activity_update_nguoidung);
        edfullname = (EditText) findViewById(R.id.edName);
        edphone = (EditText) findViewById(R.id.edPhone);
        nguoiDungDAO = new NguoidungDAO(this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        fullname = b.getString("FULLNAME");
        phone = b.getString("PHONE");
        username = b.getString("USERNAME");
        edfullname.setText(fullname);
        edphone.setText(phone);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnCancel = (Button) findViewById(R.id.btnHuuy);
        btnUpdate .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nguoiDungDAO.updateInfoNguoiDung(username, edphone.getText().toString(), edfullname.getText().toString()) > 0) {
                    Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                }
            }

        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}



   /* }     public void UPDATE(View view){
        if (nguoiDungDAO.updateInfoNguoiDung(username,edphone.getText().toString(),edfullname.getText().toString())>0){
            Toast.makeText(getApplicationContext(),"Lưu thành công",Toast.LENGTH_SHORT).show();
        }
    }
    public void Huy(View view){
        finish();
    }
}
*/
