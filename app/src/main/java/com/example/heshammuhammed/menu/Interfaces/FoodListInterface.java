package com.example.heshammuhammed.menu.Interfaces;

import java.util.HashMap;
import java.util.List;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

// List Screen MVP Interface

public interface FoodListInterface {

    interface View{
        void setData(String image , String color , List<String> list , HashMap<String , List<String>> hashMap);
        void setMainData(String string ,List<Object> list);
        void setSubData(String string , List<Object> list);
    }

    interface Presenter{
        void getData(int id , int switchCase , int groupId , int childId);
    }
}