package com.example.myapplication.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class group extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        BottomNavigationView topNav = findViewById(R.id.top_navigation);
        topNav.setOnNavigationItemSelectedListener(navListener);
        Fragment initialFragment = new group_chat();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                initialFragment).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.
            OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_chat:
                    selectedFragment = new group_chat();

                    break;
                case R.id.nav_files:
                    selectedFragment = new group_files();

                    break;
                case R.id.nav_members:
                    selectedFragment = new group_members();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };
}
