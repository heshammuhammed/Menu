package com.example.heshammuhammed.menu.POJO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public class Data implements Serializable {

    private Restaurant restaurant;
    private java.util.List<List> list = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
