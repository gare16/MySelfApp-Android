package com.apps.uts10119911myselfapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.uts10119911myselfapp.R;

public class FriendListRecyclerView extends RecyclerView.Adapter {


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_recycleview_daily_activity,
                parent, false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return DataRecycleView.imageFriends.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameFriend;
        private ImageView imageFriend;

        public ListViewHolder (View itemView) {
            super(itemView);
            nameFriend = (TextView) itemView.findViewById(R.id.nameFriendList);
            imageFriend = (ImageView) itemView.findViewById(R.id.imageFriendList);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            nameFriend.setText(DataRecycleView.nameFriends[position]);
            imageFriend.setImageResource(DataRecycleView.imageFriends[position]);
        }
        public void onClick(View view){

        }

    }
}
