package com.apps.uts10119911myselfapp.ui;

// Created by Mochamad Tegar
// 5/25/2022 4:38 PM

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.apps.uts10119911myselfapp.R;

public class VideoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        VideoView videoView = (VideoView) view.findViewById(R.id.videoView);
        MediaController mc = new MediaController(getActivity());
        videoView.setVideoPath("android.resource://"+getActivity().getPackageName()+"/"+R.raw.sample_video);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);

        return view;
    }
}