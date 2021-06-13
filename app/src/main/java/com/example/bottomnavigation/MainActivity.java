package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bottomnavigation.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.ibrahimsn.lib.OnItemSelectedListener;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        by default in home it shows fragmnet
        FragmentTransaction homeTrans = getSupportFragmentManager().beginTransaction();
        homeTrans.replace(R.id.fragment_container,new HomeFragment());
        homeTrans.commit();


//        custom navbar-1 smooth bar
        binding.bottomNav.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //int i -i is index not menu item lib
                switch (i){
                    case 0:
                        transaction.replace(R.id.fragment_container,new HomeFragment() );
                        break;
                    case 1:
                        transaction.replace(R.id.fragment_container,new CartFragment());
                        break;
                        case 2:
                            transaction.replace(R.id.fragment_container,new SearchFragment());
                        break;

//                        case 3:
//                            transaction.replace(R.id.fragment_container,new SettingsFragment());
//                        break;

                }
                transaction.commit();
                return false;//but in normal its true.
            }
        });


//normal nav bar<default bar>
//        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//
//        @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                switch (item.getItemId()) {
//
//                    case R.id.home:
////                        Toast.makeText(MainActivity.this, "Home Selected.", Toast.LENGTH_SHORT).show();
////                        FragmentTransaction homeTrans = getSupportFragmentManager().beginTransaction();
//                        transaction.replace(R.id.fragment_container,new HomeFragment());
////                        homeTrans.commit();
//                        break;
//                    case R.id.search:
////                        Toast.makeText(MainActivity.this, "Search Selected.", Toast.LENGTH_SHORT).show();
////                        FragmentTransaction searchTrans = getSupportFragmentManager().beginTransaction();
//                        transaction.replace(R.id.fragment_container,new SearchFragment());
////                        searchTrans.commit();
//                        break;
//                    case R.id.cart:
////                        Toast.makeText(MainActivity.this, "Cart Selected.", Toast.LENGTH_SHORT).show();
////                        FragmentTransaction cartTrans = getSupportFragmentManager().beginTransaction();
//                        transaction.replace(R.id.fragment_container,new CartFragment());
////                        cartTrans.commit();
//                        break;
//                    case R.id.settings:
////                        Toast.makeText(MainActivity.this, "Settings Selected.", Toast.LENGTH_SHORT).show();
////                        FragmentTransaction settingsTrans = getSupportFragmentManager().beginTransaction();
//                        transaction.replace(R.id.fragment_container,new SettingsFragment());
////                        settingsTrans.commit();
//                        break;
//                }
//                transaction.commit();
//                return true;
//
//            }
//        });

//video-2
//        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
//        bottomNav.setOnNavigationItemSelectedListener(navListener);
//    }
//    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    Fragment selectedFragment = null;
//
//                    switch (item.getItemId()) {
//
//                    case R.id.home:
////                        Toast.makeText(MainActivity.this, "Home Selected.", Toast.LENGTH_SHORT).show();
//                        selectedFragment = new HomeFragment();
//                        break;
//                    case R.id.search:
////                        Toast.makeText(MainActivity.this, "Search Selected.", Toast.LENGTH_SHORT).show();
//                        selectedFragment = new SearchFragment();
//                        break;
//                    case R.id.cart:
////                        Toast.makeText(MainActivity.this, "Cart Selected.", Toast.LENGTH_SHORT).show();
//                        selectedFragment = new CartFragment();
//                        break;
//                    case R.id.settings:
////                        Toast.makeText(MainActivity.this, "Settings Selected.", Toast.LENGTH_SHORT).show();
//                        selectedFragment = new SettingsFragment();
//                        break;
//                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
//                    return true;
//
//                }
//            };
    }
}