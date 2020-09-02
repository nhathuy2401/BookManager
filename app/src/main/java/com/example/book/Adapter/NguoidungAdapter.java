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

import com.example.book.DAO.NguoidungDAO;
import com.example.book.Dulieu.Nguoidung;
import com.example.book.R;


import java.util.List;

public class NguoidungAdapter extends BaseAdapter{
    List<Nguoidung> arrNguoiDung;
    public Activity context;
    public LayoutInflater inflater;
    NguoidungDAO nguoiDungDAO;
    public NguoidungAdapter(Activity context, List<Nguoidung> arrayNguoiDung) {
        super();
        this.context = context;
        this.arrNguoiDung = arrayNguoiDung;
        this.inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nguoiDungDAO = new NguoidungDAO(context);
    }
    @Override
    public int getCount() {
        return arrNguoiDung.size();
    }
    @Override
    public Object getItem(int position) {
        return arrNguoiDung.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class ViewHolder {
        ImageView img;
        TextView txtName;
        TextView txtPhone;
        ImageView imgDelete;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.nguoidungitem, null);
            holder.img = (ImageView) convertView.findViewById(R.id.ivIcon);
            holder.txtName = (TextView) convertView.findViewById(R.id.tvName);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            holder.imgDelete = (ImageView)convertView.findViewById(R.id.ivDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nguoiDungDAO.deleteNguoiDungByID(arrNguoiDung.get(position).getUserName());
                    arrNguoiDung.remove(position);
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();
        Nguoidung _entry = (Nguoidung) arrNguoiDung.get(position);
        if (position % 3 ==0) {
            holder.img.setImageResource(R.drawable.emone);
        }else if (position % 3 == 1){
            holder.img.setImageResource(R.drawable.emtwo);
        }else {
            holder.img.setImageResource(R.drawable.emthree);
        }
        holder.txtName.setText(_entry.getHoTen());
        holder.txtPhone.setText(_entry.getPhone());
        return convertView;
    }
    public void changeDataset(List<Nguoidung> items){
        this.arrNguoiDung = items;
        notifyDataSetChanged();
    }
}

