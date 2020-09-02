package com.example.book;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.book.Adapter.SachAdapter;
import com.example.book.DAO.SachDAO;
import com.example.book.Dulieu.Sach;

import java.util.ArrayList;
import java.util.List;

public class Listbanchay extends AppCompatActivity {
    public static List<Sach> dsSach = new ArrayList<>();
    ListView lvBook;
    SachAdapter adapter = null;
    SachDAO sachDAO;
    EditText edThang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("BÁN CHẠY");
        setContentView(R.layout.activity_listbanchay);
        lvBook = (ListView) findViewById(R.id.lvBookTop);
        edThang = (EditText) findViewById(R.id.edThang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void VIEW_SACH_TOP_10(View view){
        try {
            if (Integer.parseInt(edThang.getText().toString()) > 13 ||
                    Integer.parseInt(edThang.getText().toString()) < 0) {
                Toast.makeText(getApplicationContext(), "Không đúng định dạng tháng (1- 12)", Toast.LENGTH_SHORT).show();
            } else {
                sachDAO = new SachDAO(Listbanchay.this);
                dsSach = sachDAO.getSachTop10(edThang.getText().toString());
                adapter = new SachAdapter(this, dsSach);
                lvBook.setAdapter(adapter);
            }
        }
        catch (Exception ex){
            Toast.makeText(getApplicationContext(),"Lỗi nhập không đúng kí tự",Toast.LENGTH_SHORT).show();
        }
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