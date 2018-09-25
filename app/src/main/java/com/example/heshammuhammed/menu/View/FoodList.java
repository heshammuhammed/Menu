package com.example.heshammuhammed.menu.View;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.heshammuhammed.menu.Adapter.ExpandableListAdapter;
import com.example.heshammuhammed.menu.Adapter.MainRecycleView;
import com.example.heshammuhammed.menu.Interfaces.FoodListInterface;
import com.example.heshammuhammed.menu.POJO.Main;
import com.example.heshammuhammed.menu.POJO.Meal;
import com.example.heshammuhammed.menu.POJO.Title;
import com.example.heshammuhammed.menu.Presenter.FoodListPresenter;
import com.example.heshammuhammed.menu.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodList extends AppCompatActivity implements FoodListInterface.View {

    Intent intent;
    int id;
    FoodListInterface.Presenter presenter;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> listData;
    HashMap<String, List<String>> hashMap;
    ImageView logo;
    List<Object> catalogue;
    MainRecycleView mainRecycleView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        expandableListView = findViewById(R.id.recyclerView);
        recyclerView = findViewById(R.id.mainRec);
        logo = findViewById(R.id.imageView);

        intent = getIntent();
        id = intent.getIntExtra("ID", 999);

        catalogue = new ArrayList<>();

        presenter = new FoodListPresenter(this, this);
        presenter.getData(id, 0, -1, -1);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                presenter.getData(id, 2, i, i1);
                return true;
            }
        });

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                    presenter.getData(id, 1, i, -1);
                return false;
            }
        });
    }

    // Set Main Data Screen (Image , Color , Menus List)
    @Override
    public void setData(String image, String color, List<String> list, HashMap<String, List<String>> hashMap) {
        this.listData = list;
        this.hashMap = hashMap;

        expandableListAdapter = new ExpandableListAdapter(this, listData, hashMap);
        expandableListView.setAdapter(expandableListAdapter);

        Picasso.get().load(image).into(logo);

        View view = findViewById(R.id.constraintLayout2);
        view.setBackgroundColor(Color.parseColor(color));
        View view3 = findViewById(R.id.mainConstrain);
        view3.setBackgroundColor(Color.parseColor(color));
    }

    // Set Data of Main Menu
    @Override
    public void setMainData(String color , List<Object> list) {
        View view = findViewById(R.id.constraintLayout);
        view.setBackgroundColor(Color.parseColor(color));
        mainRecycleView = new MainRecycleView(this, list);
        recyclerView.setAdapter(mainRecycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    // Set Data of Sub Menu
    @Override
    public void setSubData(String color , List<Object> list) {
        View view = findViewById(R.id.constraintLayout);
        view.setBackgroundColor(Color.parseColor(color));
        mainRecycleView = new MainRecycleView(this, list);
        recyclerView.setAdapter(mainRecycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }
}