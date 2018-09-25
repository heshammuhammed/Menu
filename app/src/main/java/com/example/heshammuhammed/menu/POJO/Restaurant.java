package com.example.heshammuhammed.menu.POJO;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Restaurant implements Serializable{

    private String apiKey;
    private String title;
    private String image;
    private String color;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}