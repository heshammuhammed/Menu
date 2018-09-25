package com.example.heshammuhammed.menu.Interfaces;

import com.example.heshammuhammed.menu.POJO.Main;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

// Call Back Method For List Screen (From Model To Presenter)

public interface CallBackList {

    void setMenu(Main main);
    void setMainMenu(Main main , int groupId);
    void setSubMenu(Main main , int groupId , int childId);
}
