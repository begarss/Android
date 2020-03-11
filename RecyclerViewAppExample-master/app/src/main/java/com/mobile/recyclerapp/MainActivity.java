package com.mobile.recyclerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {


    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    Fragment f1 = new NewsList();
    Fragment f2 = new SavesList();
    List<Fragment> list = new ArrayList<>();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bot);
        pager = findViewById(R.id.pager);
        list.add(f1);
        list.add(f2);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.nav_home:
                                pager.setCurrentItem(0,false);
                                bottomNavigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

                                bottomNavigationView.getMenu().findItem(R.id.nav_home).setIcon(R.drawable.ic_home_black_24dp);
                                break;
                            case R.id.nav_book:
                                pager.setCurrentItem(1,false);
                                bottomNavigationView.getMenu().findItem(R.id.nav_book).setChecked(true);
                                //bottomNavigationView.getMenu().findItem(R.id.nav_home).setChecked(false);


                                break;
                        }
                        return false;
                    }
                });





    }





    public void myClick(News news, int option) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.pager);
        if (option==1)
            //((SavesList)fragment).saveNews(news);
            ((SavesList)fragment).saveNews(news);

        else
            ((SavesList)fragment).removeNews(news);
    }

    public void removeItemLike(News news) {
        ((NewsList)f1).removeLike(news);
        ((SavesList)f2).removeLike(news);
    }





}

