    package com.apps.uts10119911myselfapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.apps.uts10119911myselfapp.Adapter.OnboardingAdapter;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicators;
    private MaterialButton btnOnboardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicatiors);
        btnOnboardingAction = findViewById(R.id.btnOnboardingAction);

        setupOnboardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.onboardinViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setupOnboardingItems();
        setupOnboardingIndicators();
        setCurrentOnboardingIndicators(0);
        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicators(position);
            }
        });

        btnOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onboardingViewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()) {
                        onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                }else {
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        finish();
                }
            }
        });
    }

    private void setupOnboardingItems() {
        List<OnboardingItem> onboardingItems = new ArrayList<>();

        OnboardingItem startingApp = new OnboardingItem();
        startingApp.setTitle("Get Started");
        startingApp.setDescription("We are really happy to see you here.");
        startingApp.setImage(R.drawable.ic_peoplewithphone);

        OnboardingItem friendlyUser = new OnboardingItem();
        friendlyUser.setTitle("Sit Back & Relax");
        friendlyUser.setDescription("Relax in your room and enjoy.");
        friendlyUser.setImage(R.drawable.ic_relax);

        OnboardingItem galleryApp = new OnboardingItem();
        galleryApp.setTitle("Our Gallery");
        galleryApp.setDescription("Find your favorite photo in our gallery.");
        galleryApp.setImage(R.drawable.ic_nav_gallery);

        onboardingItems.add(startingApp);
        onboardingItems.add(friendlyUser);
        onboardingItems.add(galleryApp);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);
    }
    private void setupOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicatior_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicators.addView(indicators[i]);
        }
    }
    private void setCurrentOnboardingIndicators(int index) {
        int childCount = layoutOnboardingIndicators.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutOnboardingIndicators.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicatior_active)
                );
            }else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicatior_inactive)
                );
            }
        }
        if (index == onboardingAdapter.getItemCount() - 1 ){
            btnOnboardingAction.setText("Start");
        }else{
            btnOnboardingAction.setText("Next");
        }
    }
}