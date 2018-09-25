package com.example.heshammuhammed.menu.POJO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public class SubCategory implements Serializable {
    private Integer id;
    private String title;
    private List<Item> items = null;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}