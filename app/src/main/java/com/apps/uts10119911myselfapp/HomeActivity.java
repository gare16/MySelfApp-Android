package com.apps.uts10119911myselfapp;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.apps.uts10119911myselfapp.databinding.ActivityHomeBinding;
import com.apps.uts10119911myselfapp.ui.DailyActivityFragment;
import com.apps.uts10119911myselfapp.ui.FavoriteFragment;
import com.apps.uts10119911myselfapp.ui.GalleryFragment;
import com.apps.uts10119911myselfapp.ui.HomeFragmentLayout;
import com.apps.uts10119911myselfapp.ui.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragmentLayout());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.homeFragment:
                    replaceFragment(new HomeFragmentLayout());
                    break;
                case R.id.dailyActivityFragment:
                    replaceFragment(new DailyActivityFragment());
                    break;
                case R.id.galleryFragment:
                    replaceFragment(new GalleryFragment());
                    break;
                case R.id.mediaFragment:
                    replaceFragment(new FavoriteFragment());
                    break;
                case R.id.profileFragment:
                    replaceFragment(new ProfileFragment());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

}
