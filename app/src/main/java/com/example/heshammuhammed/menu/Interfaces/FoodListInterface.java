package com.example.heshammuhammed.menu.Interfaces;

import com.example.heshammuhammed.menu.POJO.Main;

import java.util.HashMap;
import java.util.List;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public interface FoodListInterface {

    interface View{
        void showData(Main main);
        void setData(String image , String color , List<String> list , HashMap<String , List<String>> hashMap);
        void setMainData(String string ,List<Object> list);
        void setSubData(String string , List<Object> list);
    }

    interface Presenter{
        void getData(int id , int switchCase , int groupId , int childId);
    }
}