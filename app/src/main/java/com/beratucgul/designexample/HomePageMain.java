package com.beratucgul.designexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.beratucgul.designexample.fragment.PayFragment;
import com.beratucgul.designexample.fragment.ProfileFragment;
import com.beratucgul.designexample.fragment.SearchFragment;
import com.beratucgul.designexample.fragment.homefragment;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class HomePageMain extends AppCompatActivity {
    Toolbar mToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    AppBarConfiguration mAppBarConfiguration;
    BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home_page_main);

        mToolbar =  findViewById(R.id.toolbarLast);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
       // Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
      //  getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerLayout = findViewById(R.id.navigation_layout);
        navigationView = findViewById(R.id.navigation_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_search, R.id.navigation_profile, R.id.navigation_pay)
                .setDrawerLayout(drawerLayout)
                .build();

        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigation = findViewById(R.id.bottom_navigation);
       // bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        NavigationUI.setupWithNavController(bottomNavigation, navController);

       // View navView = navigationView.inflateHeaderView(R.layout.nav_header_main);

      /*  navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

                if(destination.getId() == R.id.nav_home || destination.getId() == R.id.nav_search || destination.getId() == R.id.nav_profile ||
                        destination.getId() == R.id.nav_pay) {
                    bottomNavigationMenu.setVisibility(View.GONE);
                }
                else{
                    bottomNavigationMenu.setVisibility(View.VISIBLE);
                }
            }
        });

       */


    }
 /*   private boolean loadFragment(Fragment fragment) {
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


  */


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}