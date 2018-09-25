package com.example.heshammuhammed.menu.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.heshammuhammed.menu.Interfaces.CallBackList;
import com.example.heshammuhammed.menu.Interfaces.FoodListInterface;
import com.example.heshammuhammed.menu.Model.GetMenu;
import com.example.heshammuhammed.menu.POJO.Main;
import com.example.heshammuhammed.menu.POJO.Meal;
import com.example.heshammuhammed.menu.POJO.Title;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public class FoodListPresenter implements FoodListInterface.Presenter, CallBackList {

    FoodListInterface.View view;
    Context context;
    GetMenu getMenu;

    public FoodListPresenter(FoodListInterface.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void getData(int id, int switchCase, int groupId, int childId) {
        getMenu = new GetMenu(context, this);
        getMenu.getListMenu(id, switchCase, groupId, childId);
    }

    @Override
    public void setMenu(Main main) {
        List<String> mainList = new ArrayList<>();
        HashMap<String, List<String>> mainHashMap = new HashMap<>();
        for (int i = 0; i < main.getData().getList().size(); i++) {
            if (main.getData().getList().get(i).getSubCategories() == null) {
                mainList.add(main.getData().getList().get(i).getTitle());
                mainHashMap.put(main.getData().getList().get(i).getTitle(), new ArrayList<String>());
            } else {
                List<String> tempList = new ArrayList<>();
                for (int y = 0; y < main.getData().getList().get(i).getSubCategories().size(); y++) {
                    tempList.add(main.getData().getList().get(i).getSubCategories().get(y).getTitle());
                }
                mainList.add(main.getData().getList().get(i).getTitle());
                mainHashMap.put(main.getData().getList().get(i).getTitle(), tempList);
            }
        }
        String image = main.getData().getRestaurant().getImage();
        String color = main.getData().getRestaurant().getColor();
        view.setData(image, color, mainList, mainHashMap);
    }

    @Override
    public void setMainMenu(Main main, int i) {
        List<Object> list = new ArrayList<>();
        int temp = 0;
        if (main.getData().getList().get(i).getSubCategories() != null) {
            for (int y = 0; y < main.getData().getList().get(i).getSubCategories().size(); y++) {
                list.add(new Title(main.getData().getList().get(i).getSubCategories().get(y).getTitle()));
                list.add(new Title(" "));
                list.add(new Title(" "));
                for (int z = 0; z < main.getData().getList().get(i).getSubCategories().get(y).getItems().size(); z++) {
                    String price, image, title, desc;
                    price = main.getData().getList().get(i).getSubCategories().get(y).getItems().get(z).getPrice() + "";
                    image = main.getData().getList().get(i).getSubCategories().get(y).getItems().get(z).getImage() + "";
                    title = main.getData().getList().get(i).getSubCategories().get(y).getItems().get(z).getTitle() + "";
                    desc = main.getData().getList().get(i).getSubCategories().get(y).getItems().get(z).getDescription() + "";
                    Meal meal = new Meal();
                    meal.setPrices(price);
                    meal.setImages(image);
                    meal.setDescription(desc);
                    meal.setNames(title);
                    list.add(meal);
                    temp++;
                    if (temp == 3) {
                        temp = 0;
                    }
                }
                while (temp < 3) {
                    list.add(new Title(" "));
                    temp++;
                }
                temp = 0;
            }
        } else {
            for (int w = 0; w < main.getData().getList().get(i).getItems().size(); w++) {
                String price, image, title, desc;
                price = main.getData().getList().get(i).getItems().get(w).getPrice() + "";
                image = main.getData().getList().get(i).getItems().get(w).getImage() + "";
                title = main.getData().getList().get(i).getItems().get(w).getTitle() + "";
                desc = main.getData().getList().get(i).getItems().get(w).getDescription() + "";
                Meal meal = new Meal();
                meal.setPrices(price);
                meal.setImages(image);
                meal.setDescription(desc);
                meal.setNames(title);
                list.add(meal);
            }
        }
        view.setMainData(main.getData().getRestaurant().getColor(), list);
    }

    @Override
    public void setSubMenu(Main main, int i, int y) {

        List<Object> list = new ArrayList<>();
        for (int z = 0; z < main.getData().getList().get(i).getSubCategories().get(y).getItems().size(); z++) {
            String price, image, title, desc;
            price = main.getData().getList().get(i).getSubCategories().get(y).getItems().get(z).getPrice() + "";
            image = main.getData().getList().get(i).getSubCategories().get(y).getItems().get(z).getImage() + "";
            title = main.getData().getList().get(i).getSubCategories().get(y).getItems().get(z).getTitle() + "";
            desc = main.getData().getList().get(i).getSubCategories().get(y).getItems().get(z).getDescription() + "";
            Meal meal = new Meal();
            meal.setPrices(price);
            meal.setImages(image);
            meal.setDescription(desc);
            meal.setNames(title);
            list.add(meal);
        }
        view.setSubData(main.getData().getRestaurant().getColor(), list);
    }
}