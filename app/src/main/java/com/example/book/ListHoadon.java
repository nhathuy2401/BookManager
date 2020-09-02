package com.example.book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.book.Adapter.HoadonAdapter;
import com.example.book.DAO.HoadonDAO;
import com.example.book.Dulieu.Hoadon;

import java.util.ArrayList;
import java.util.List;

public class ListHoadon extends AppCompatActivity {
    public List<Hoadon> dsHoaDon = new ArrayList<>();
    ListView lvHoaDon;
    HoadonAdapter adapter = null;
    HoadonDAO hoaDonDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hoadon);
        setTitle("HOÁ ĐƠN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvHoaDon = (ListView) findViewById(R.id.lvHoaDon);
        hoaDonDAO = new HoadonDAO(ListHoadon.this);
        try {
            dsHoaDon = hoaDonDAO.getAllHoaDon();
        } catch (Exception e) {
            Log.d("Error: ", e.toString());
        }
        adapter = new HoadonAdapter(this, dsHoaDon);
        lvHoaDon.setAdapter(adapter);
        lvHoaDon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hoadon hoaDon = (Hoadon) parent.getItemAtPosition(position);
                Intent intent = new Intent(ListHoadon.this, Hoadonchitiet.class);
                Bundle b = new Bundle();
                b.putString("MAHOADON", hoaDon.getMaHoaDon());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        // TextFilter
        lvHoaDon.setTextFilterEnabled(true);
        EditText edSeach = (EditText) findViewById(R.id.edSearch);
        edSeach.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {
                System.out.println("Text [" + s + "] - Start [" + start + "] - Before [" + before + "] - Count [" + count + "]");
                if (count < before) {
                    adapter.resetData();
                }
                adapter.getFilter().filter(s.toString());
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutheloai, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.addd:
                Intent intent = new
                        Intent(ListHoadon.this,Themhoadon.class);
                startActivity(intent);
                return(true);
                    case android.R.id.home:
                        onBackPressed();
                        return true;

                    default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}