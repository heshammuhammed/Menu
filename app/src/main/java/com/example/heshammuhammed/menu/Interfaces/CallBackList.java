package com.example.heshammuhammed.menu.Interfaces;

import com.example.heshammuhammed.menu.POJO.Main;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public interface CallBackList {

    void setMenu(Main main);
    void setMainMenu(Main main , int groupId);
    void setSubMenu(Main main , int groupId , int childId);
}
