package com.example.taotoon.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taotoon.R;
import com.example.taotoon.model.Manga;

import java.util.ArrayList;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.ViewHolder>{
    Activity context;
    ArrayList<Manga> arr_Manga;

    public MangaAdapter(Activity context, ArrayList<Manga> arr_Manga){
        this.context=context;
        this.arr_Manga=arr_Manga;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View viewManga=layoutInflater.inflate(R.layout.items,parent,false);
        ViewHolder viewHolderMG=new ViewHolder(viewManga);
        return viewHolderMG;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Manga mg=arr_Manga.get(position);
        holder.ivHinh.setImageResource(mg.getHinhMG());
        holder.txtMaMG.setText(mg.getMaMG()+"");
        holder.txtTenMG.setText(mg.getTenMG());
    }

    @Override
    public int getItemCount() {
        return arr_Manga.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivHinh;
        TextView txtMaMG, txtTenMG;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHinh=itemView.findViewById(R.id.ivHinh);
            txtMaMG=itemView.findViewById(R.id.txtMaMG);
            txtTenMG=itemView.findViewById(R.id.txtTenMG);
        }
    }
}
