package com.example.valepei.View;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.valepei.Adapter.NewsAdapter;
import com.example.valepei.Controller.NewsController;
import com.example.valepei.Model.POJO.News;
import com.example.valepei.Model.POJO.NewsTopHeadline;
import com.example.valepei.R;
import com.example.valepei.Util.ResultListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsTopFragment extends Fragment {

    NewsController newsController;
    RecyclerView recyclerViewNews;
    NewsAdapter newsAdapter;
    List<News> listadeNews = new ArrayList<>();
    Context context;

    public NewsTopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_news_top, container, false);
        recyclerViewNews = view.findViewById(R.id.recyclerViewTopHeadlines);
        newsController = new NewsController();

        ResultListener<NewsTopHeadline> EscuchadorActivityNews = new ResultListener<NewsTopHeadline>() {
            @Override
            public void finish(NewsTopHeadline resultado) {
                for (News news : resultado.getListaHeadline()) {
                    listadeNews.add(news);

                }

                newsAdapter = new NewsAdapter(context,listadeNews);
                recyclerViewNews.setAdapter(newsAdapter);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                recyclerViewNews.setLayoutManager(layoutManager);

            }
        };

        newsController.getnews(EscuchadorActivityNews);

        return view;
    }


}
