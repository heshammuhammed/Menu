package com.example.heshammuhammed.menu.Interfaces;

import com.example.heshammuhammed.menu.POJO.Main;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

// Main Screen MVP Interface
public interface MainScreenInterface {

    interface View{
        void  showImageAndColor(String image , String color);
    }

    interface Presenter{
        void getImageAndColor();
    }
}