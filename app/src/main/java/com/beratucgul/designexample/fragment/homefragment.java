package com.beratucgul.designexample.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;


import com.beratucgul.designexample.MainActivity;
import com.beratucgul.designexample.R;
import com.beratucgul.designexample.SliderAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class homefragment extends Fragment {

     private ViewPager mSlideViewPager;
     private SliderAdapter sliderAdapter;
     private TabLayout tabLayout;

     Button ManFashion, WomanFashion, Bags, Toys;

     private DrawerLayout mDrawer;
     private Toolbar toolbar;
     private NavigationView navigationView;
     private ActionBarDrawerToggle drawerToggle;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar= view.findViewById(R.id.toolbar1);

        mDrawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
      //  navigationView = view.findViewById(R.id.navigationView);










        mSlideViewPager = view.findViewById(R.id.mSlideViewPager);
        sliderAdapter = new SliderAdapter(this.getActivity());
        tabLayout = view.findViewById(R.id.tabLayout);
        mSlideViewPager.setAdapter(sliderAdapter);
        tabLayout.setupWithViewPager(mSlideViewPager);

        ManFashion = view.findViewById(R.id.ManFashion);
        WomanFashion = view.findViewById(R.id.WomanFashion);
        Bags = view.findViewById(R.id.Bags);
        Toys = view.findViewById(R.id.Toys);

        ManFashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // FragmentManager fragmentManager = getFragmentManager();
              //  Fragment newFragment = new MenFashionFragment();

                MenFashionFragment menFashionFragment = new MenFashionFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, menFashionFragment);
                fragmentTransaction.addToBackStack(menFashionFragment.getClass().getName()).commit();

            }
        });
        WomanFashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WomenFashionFragment womenFashionFragment = new WomenFashionFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.frame, womenFashionFragment);
                fragmentTransaction.addToBackStack(womenFashionFragment.getClass().getName()).commit();
            }
        });








        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

