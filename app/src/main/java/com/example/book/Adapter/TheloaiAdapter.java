package com.example.book.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.book.DAO.TheloaiDAO;
import com.example.book.Dulieu.Theloai;
import com.example.book.R;

import java.util.List;

public class TheloaiAdapter extends BaseAdapter {
    List<Theloai> arrTheLoai;
    public Activity context;
    public LayoutInflater inflater;
    TheloaiDAO theLoaiDAO;
    public TheloaiAdapter(Activity context, List<Theloai> arrayTheLoai) {
        super();
        this.context = context;
        this.arrTheLoai = arrayTheLoai;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        theLoaiDAO = new TheloaiDAO(context);
    }
    @Override
    public int getCount() {
        return arrTheLoai.size();
    }
    @Override
    public Object getItem(int position) {
        return arrTheLoai.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class ViewHolder {
        ImageView img;
        TextView txtMaTheLoai;
        TextView txtTenTheLoai;
        ImageView imgDelete;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.theloaiitem, null);
            holder.img = (ImageView) convertView.findViewById(R.id.ivIcon);
            holder.txtMaTheLoai = (TextView) convertView.findViewById(R.id.tvMaTheLoai);
            holder.txtTenTheLoai = (TextView) convertView.findViewById(R.id.tvTenTheLoai);
            holder.imgDelete = (ImageView)convertView.findViewById(R.id.ivDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    theLoaiDAO.deleteTheLoaiByID(arrTheLoai.get(position).getMaTheloai());
                    arrTheLoai.remove(position);
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();
        Theloai _entry = (Theloai) arrTheLoai.get(position);
        if (position % 3 ==0) {
            holder.img.setImageResource(R.drawable.ss);
        }else if (position % 3 == 1){
            holder.img.setImageResource(R.drawable.kk);
        }else {
            holder.img.setImageResource(R.drawable.bookstack);
        }
        holder.txtMaTheLoai.setText(_entry.getMaTheloai());
        holder.txtTenTheLoai.setText(_entry.getTenTheloai());
        return convertView;
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    public void changeDataset(List<Theloai> items){
        this.arrTheLoai = items;
        notifyDataSetChanged();
    }
}


