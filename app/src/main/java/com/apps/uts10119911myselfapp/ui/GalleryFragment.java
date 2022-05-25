package com.apps.uts10119911myselfapp.ui;

// Created by Mochamad Tegar
// 5/25/2022 4:38 PM

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.uts10119911myselfapp.R;
import com.apps.uts10119911myselfapp.Adapter.GalleryRecyclerV;

public class GalleryFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.galleryCartoon);
        GalleryRecyclerV galleryRecyclerV = new GalleryRecyclerV();
        recyclerView.setAdapter(galleryRecyclerV);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(),2,
                GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        return view;
    }
}