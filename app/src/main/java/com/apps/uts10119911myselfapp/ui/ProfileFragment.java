package com.apps.uts10119911myselfapp.ui;

// Created by Mochamad Tegar
// 5/25/2022 4:38 PM

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.apps.uts10119911myselfapp.R;


public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ImageView facebookLink = (ImageView) view.findViewById(R.id.facebookLinks);
        ImageView instagramLink = (ImageView) view.findViewById(R.id.instagramLinks);
        ImageView gmailLink = (ImageView) view.findViewById(R.id.gmailLinks);
        ImageView findMeLink = (ImageView) view.findViewById(R.id.findmeLinks);
        ImageView whatsappLink = (ImageView) view.findViewById(R.id.whatsappLinks);
        Button aboutApps = (Button) view.findViewById(R.id.aboutApps);

        facebookLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/mtegar15/");
            }
        });

        instagramLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/tegardwiiiii");
            }
        });

        gmailLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SendMail.class);
                startActivity(i);
            }
        });

        findMeLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://goo.gl/maps/2oZ3gRyJdj8N5Xcw8");
            }
        });

        aboutApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAbout dialogAbout = new DialogAbout();
                dialogAbout.show(getFragmentManager(), "DialogAbout");
            }
        });

        whatsappLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://api.whatsapp.com/send?phone=6287821637614");
            }
        });

        return view;
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}