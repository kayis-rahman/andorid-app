package com.example.home.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.home.R;
import com.example.home.fragment.HomeFragment;
import com.example.home.fragment.MusicFragment;
import com.example.home.fragment.NewsFragment;
import com.example.home.fragment.ShowsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 *  {@link MainActivity} is the landing screen handler of this app.
 *  It's binding R.layout.activity_main xml layout.
 *
 * @author Kayis Rahman
 * @since 1.0.0
 */
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private final Fragment homeFragment = new HomeFragment();
    private final Fragment newsFragment = new NewsFragment();
    private final Fragment showsFragment = new ShowsFragment();
    private final Fragment musicFragment = new MusicFragment();
    private final FragmentManager fm = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;
    private Fragment activeFragment = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hiding fragments except active(Home) fragment via FragmentManager
        fm.beginTransaction().add(R.id.main_container, musicFragment, "4").hide(musicFragment).commit();
        fm.beginTransaction().add(R.id.main_container, showsFragment, "3").hide(showsFragment).commit();
        fm.beginTransaction().add(R.id.main_container, newsFragment, "2").hide(newsFragment).commit();
        fm.beginTransaction().add(R.id.main_container, homeFragment, "1").commit();

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Switching Fragments based on selected navigation
        switch (item.getItemId()) {
            case R.id.menuHome:
                fm.beginTransaction().hide(activeFragment).show(homeFragment).commit();
                activeFragment = homeFragment;
                return true;
            case R.id.menuNews:
                fm.beginTransaction().hide(activeFragment).show(newsFragment).commit();
                activeFragment = newsFragment;
                return true;
            case R.id.menuShows:
                fm.beginTransaction().hide(activeFragment).show(showsFragment).commit();
                activeFragment = showsFragment;
                return true;
            case R.id.menuMusic:
                fm.beginTransaction().hide(activeFragment).show(musicFragment).commit();
                activeFragment = musicFragment;
                return true;
        }
        return false;
    }
}