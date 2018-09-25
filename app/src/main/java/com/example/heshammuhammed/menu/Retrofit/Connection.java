package com.example.heshammuhammed.menu.Retrofit;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connection {

    public static final String BASE_URL = "http://50.87.52.41/~develps7/AutoZ/web/app_dev.php/";
    public static Retrofit retrofit = null;
    public static final String API_KEY ="b07ae77b9f59af870c91662a23ac8813758b0786";

    public static Retrofit getConnection() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build();
        }
        return retrofit;
    }
}