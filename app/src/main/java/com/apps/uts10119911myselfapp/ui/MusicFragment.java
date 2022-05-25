package com.apps.uts10119911myselfapp.ui;

// Created by Mochamad Tegar
// 5/25/2022 4:38 PM

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.uts10119911myselfapp.Adapter.MusicAdapter;
import com.apps.uts10119911myselfapp.R;


public class MusicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listMusic);
        MusicAdapter musicAdapter = new MusicAdapter();
        recyclerView.setAdapter(musicAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}