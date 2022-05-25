package com.apps.uts10119911myselfapp.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.uts10119911myselfapp.R;
import com.apps.uts10119911myselfapp.Adapter.DailyActivityRecyclerView;
import com.apps.uts10119911myselfapp.Adapter.FriendListRecyclerView;


public class DailyActivityFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_daily_activity, container, false);
        RecyclerView recyclerView1 = (RecyclerView) view.findViewById(R.id.friendList);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.dailyActivity);
        FriendListRecyclerView friendListRecyclerView = new FriendListRecyclerView();
        DailyActivityRecyclerView dailyActivityRecyclerView = new DailyActivityRecyclerView();
        recyclerView1.setAdapter(friendListRecyclerView);
        recyclerView2.setAdapter(dailyActivityRecyclerView);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager layoutManager2 = new GridLayoutManager(requireContext(),2,
                GridLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);

        return view;
    }
}