package com.example.book;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.book.DAO.HoadonchitietDAO;

public class Listthongke extends AppCompatActivity {
    TextView tvNgay, tvThang, tvNam;
    HoadonchitietDAO hoaDonChiTietDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("DOANH THU");
        setContentView(R.layout.activity_listthongke);
        tvNgay = (TextView) findViewById(R.id.tvThongKeNgay);
        tvThang = (TextView) findViewById(R.id.tvThongKeThang);
        tvNam = (TextView) findViewById(R.id.tvThongKeNam);
        hoaDonChiTietDAO = new HoadonchitietDAO(this);
        tvNgay.setText("Hôm nay      : " + hoaDonChiTietDAO.getDoanhThuTheoNgay());
        tvThang.setText("Tháng này   : " + hoaDonChiTietDAO.getDoanhThuTheoThang());
        tvNam.setText("Năm này       : " + hoaDonChiTietDAO.getDoanhThuTheoNam());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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