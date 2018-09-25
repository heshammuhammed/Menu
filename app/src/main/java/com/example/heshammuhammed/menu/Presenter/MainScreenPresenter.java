package com.example.heshammuhammed.menu.Presenter;

import android.content.Context;
import com.example.heshammuhammed.menu.Interfaces.CallBackModel;
import com.example.heshammuhammed.menu.Interfaces.MainScreenInterface;
import com.example.heshammuhammed.menu.Model.GetMainData;
import com.example.heshammuhammed.menu.POJO.Main;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public class MainScreenPresenter implements MainScreenInterface.Presenter , CallBackModel {

    Context context;
    MainScreenInterface.View view;
    Main main;
    GetMainData getMainData;

    public MainScreenPresenter (MainScreenInterface.View view, Context context){
        this.context = context;
        this.view = view;
    }

    @Override
    public void getImageAndColor() {
        getMainData = new GetMainData(context,this);
        main = getMainData.getData();
    }

    // Get Color , Image from main Object
    @Override
    public void getMyData(Main main) {
        String image = main.getData().getRestaurant().getImage();
        String color = main.getData().getRestaurant().getColor();
        view.showImageAndColor(image,color);
    }
}