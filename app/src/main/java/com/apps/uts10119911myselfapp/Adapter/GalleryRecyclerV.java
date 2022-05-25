package com.apps.uts10119911myselfapp.Adapter;

// Created by Mochamad Tegar
// 5/25/2022 4:38 PM

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.uts10119911myselfapp.R;

public class GalleryRecyclerV extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_gallery,
                parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return DataRecycleView.galerryCartoon.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView cartoonV;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            cartoonV = (ImageView) itemView.findViewById(R.id.imageCartoon);
            itemView.setOnClickListener(this);
        }

        public void bindView (int position) {
            cartoonV.setImageResource(DataRecycleView.galerryCartoon[position]);
        }


        @Override
        public void onClick(View view) {

        }
    }



}
