package com.example.heshammuhammed.menu.Retrofit;

import com.example.heshammuhammed.menu.POJO.Key;
import com.example.heshammuhammed.menu.POJO.Main;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public interface MenuConnection {

    @POST("en/api/restaurant/get-categories")
    Call<Main> getMenu (@Body Key key);

    @POST("ar/api/restaurant/get-categories")
    Call<Main> getArabicMenu (@Body Key key);

    @POST("en/api/restaurant/get-categories")
    Call<Main> getEnglishMenu (@Body Key key);
}