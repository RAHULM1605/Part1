package com.groovenexus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomNavigationActivity extends AppCompatActivity implements MainScreenFragment.OnFragmentInteractionListener,PlaylistFragment.OnFragmentInteractionListener,ArtistFragment.OnFragmentInteractionListener,GalleryFragment.OnFragmentInteractionListener {


    BottomNavigationView navView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selected = new MainScreenFragment();

            Menu menu = navView.getMenu();
            MenuItem menuItem = menu.getItem(0);
            menuItem.setChecked(true);

            switch (item.getItemId()) {
                case R.id.nav_item1:
                    menuItem = menu.getItem(0);
                    selected = new MainScreenFragment();
                    break;
                case R.id.nav_item2:
                    menuItem = menu.getItem(1);
                    selected = new PlaylistFragment();
                    break;
                case R.id.nav_item3:
                    menuItem = menu.getItem(2);
                    selected = new ArtistFragment();
                    break;
                case R.id.nav_item4:
                    menuItem = menu.getItem(3);
                    selected = new GalleryFragment();
                    break;
            }
            menuItem.setChecked(true);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.toBeReplaced, selected);
            transaction.commit();
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        navView = findViewById(R.id.nav_view);
        Fragment selected = new MainScreenFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.toBeReplaced, selected);
        transaction.commit();
        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
