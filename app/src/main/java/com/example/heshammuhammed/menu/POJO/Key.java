package com.example.heshammuhammed.menu.POJO;

import java.io.Serializable;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public class Key implements Serializable {
    private String apiKey;

    public Key(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}