package com.apps.uts10119911myselfapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.uts10119911myselfapp.R;

public class MusicAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_music, parent, false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return DataRecycleView.playlistSong.length;

    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView titleSongs;
        private TextView artistMusic;
        private ImageView imageCover;

        public ListViewHolder(View itemView) {
            super(itemView);
            titleSongs = (TextView) itemView.findViewById(R.id.titleMusic);
            artistMusic = (TextView) itemView.findViewById(R.id.artistMusic);
            imageCover = (ImageView) itemView.findViewById(R.id.imgCover);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            titleSongs.setText(DataRecycleView.playlistSong[position]);
            artistMusic.setText(DataRecycleView.releasedSong[position]);
            imageCover.setImageResource(R.drawable.ic_music);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
