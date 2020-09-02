package com.example.book;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView ngdung,theloai,imageHoadon,imageSach,imageBanchay,imageThongke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("QUẢN LÍ");
        ngdung=(ImageView)findViewById(R.id.nguoidung);
        theloai=(ImageView)findViewById(R.id.theloai);
        imageHoadon=(ImageView)findViewById(R.id.imageHoadon);
        imageSach=(ImageView)findViewById(R.id.imageSach);
        imageBanchay=(ImageView)findViewById(R.id.imageBanchay);
        imageThongke=(ImageView)findViewById(R.id.imageThongke);



        ngdung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Listnguoidung.class);
                startActivity(i);
            }
        });
        theloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Listtheloai.class);
                startActivity(i);
            }
        });
        imageHoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ListHoadon.class);
                startActivity(i);
            }
        });
        imageSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ListSach.class);
                startActivity(i);
            }
        });
        imageBanchay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Listbanchay.class);
                startActivity(i);
            }
        });
        imageThongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Listthongke.class);
                startActivity(i);
            }
        });
    }
}