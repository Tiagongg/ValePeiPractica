package com.example.valepei.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.valepei.Adapter.NewsAdapter;
import com.example.valepei.Controller.NewsController;
import com.example.valepei.Model.POJO.News;
import com.example.valepei.Model.POJO.NewsTopHeadline;
import com.example.valepei.R;
import com.example.valepei.Util.ResultListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class NewsTopActivity extends AppCompatActivity {

    FragmentManager fm;
    NewsController newsController;
    BottomNavigationView bottomNavigationView;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_top);



        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


        fm = getSupportFragmentManager();

        NewsTopFragment mainFragment = new NewsTopFragment();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer,mainFragment);
        fragmentTransaction.commit();



    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.TopHeadline:
                    selectedFragment = new NewsTopFragment();
                    break;
                case R.id.Spanish:
                    selectedFragment = new SpanishevFragment();
                    break;
                case R.id.About:
                    selectedFragment = new AboutFragment();
                    break;
                case R.id.Search:
                    selectedFragment = new SearchFragment();
                    break;
            }

            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer,selectedFragment);
            fragmentTransaction.commit();

            return true;

        }
    };



}
