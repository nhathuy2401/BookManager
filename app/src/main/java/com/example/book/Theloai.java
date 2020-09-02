package com.example.book;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.book.DAO.TheloaiDAO;

public class Theloai extends AppCompatActivity {
    Button btnThemTheLoai;
    TheloaiDAO theloaiDAO;
    EditText edMa,edTen,edVi,edMo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloai);
        setTitle("THÊM THỂ LOẠI");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnThemTheLoai = (Button) findViewById(R.id.btnThem);
        edMa = (EditText) findViewById(R.id.edMa);
        edTen = (EditText) findViewById(R.id.edTen);
        edVi = (EditText) findViewById(R.id.edVi);
        edMo = (EditText) findViewById(R.id.edMo);


    }
        public void showtheloai(View view) {
            finish();
        }
        public void quaylai(View view) {
            onBackPressed();
        }

        public void themtheloai(View view) {
            theloaiDAO = new TheloaiDAO(Theloai.this);
            com.example.book.Dulieu.Theloai user = new com.example.book.Dulieu.Theloai
                    (edMa.getText().toString(), edTen.getText().toString(),edMo.getText().toString(),edVi.getText().toString());
            try {
                if (validateForm()>0){
                    if (theloaiDAO.inserTheLoai(user) > 0) {
                        Toast.makeText(getApplicationContext(), "Thêm thành công",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Thêm thất bại",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (Exception ex) {
                Log.e("Lỗi:", ex.toString());
            }
        }
        public int validateForm(){
            int check = 1;
            if (edMa.getText().length() == 0 || edTen.getText().length() == 0
                    || edVi.getText().length() == 0 || edMo.getText().length()==0) {
                Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin ",
                        Toast.LENGTH_SHORT).show();
                check = -1;
            }
            return check;
        }


    @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId())
            {
                case android.R.id.home:
                    onBackPressed();
                    return true;

                default:break;
            }

            return super.onOptionsItemSelected(item);
        }
    }
