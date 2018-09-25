package com.example.heshammuhammed.menu.POJO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public class List implements Serializable {

    private Integer id;
    private String title;
    private java.util.List<SubCategory> subCategories = null;
    private java.util.List<Item> items = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public java.util.List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(java.util.List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public java.util.List<Item> getItems() {
        return items;
    }

    public void setItems(java.util.List<Item> items) {
        this.items = items;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}