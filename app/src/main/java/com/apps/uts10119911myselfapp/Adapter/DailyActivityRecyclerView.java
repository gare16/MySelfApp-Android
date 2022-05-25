package com.apps.uts10119911myselfapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.uts10119911myselfapp.R;

public class DailyActivityRecyclerView extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_grid2,
        parent, false);

        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return DataRecycleView.iconActivity.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameActivity;
        private ImageView iconActivity;

        public ListViewHolder(View itemView) {
            super(itemView);
            nameActivity = (TextView) itemView.findViewById(R.id.nameFriendList);
            iconActivity = (ImageView) itemView.findViewById(R.id.imageSquareFriendL);
            itemView.setOnClickListener(this);
        }
        public void bindView(int position) {
            nameActivity.setText(DataRecycleView.nameActivity[position]);
            iconActivity.setImageResource(DataRecycleView.iconActivity[position]);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
