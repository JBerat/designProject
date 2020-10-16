package com.beratucgul.designexample;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beratucgul.designexample.fragment.PayFragment;
import com.beratucgul.designexample.fragment.ProfileFragment;
import com.beratucgul.designexample.fragment.SearchFragment;
import com.beratucgul.designexample.fragment.homefragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

public class HomePage extends AppCompatActivity {

    Button ManFashion, WomanFashion, Bags, Toys;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setItemIconTintList(null);

        loadFragment(new homefragment());

        ManFashion = findViewById(R.id.ManFashion);
        WomanFashion = findViewById(R.id.WomanFashion);
        Bags = findViewById(R.id.Bags);
        Toys = findViewById(R.id.Toys);







    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }




        private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment = new homefragment();
                        break;
                    case R.id.navigation_search:
                        fragment = new SearchFragment();
                        break;
                    case R.id.navigation_profile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.navigation_pay:
                        fragment = new PayFragment();
                        break;
                }
                return loadFragment(fragment);
            }
        };






}