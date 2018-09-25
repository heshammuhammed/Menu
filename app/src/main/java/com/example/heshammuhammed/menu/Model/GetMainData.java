package com.example.heshammuhammed.menu.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.heshammuhammed.menu.Interfaces.CallBackModel;
import com.example.heshammuhammed.menu.POJO.Key;
import com.example.heshammuhammed.menu.POJO.Main;
import com.example.heshammuhammed.menu.Presenter.MainScreenPresenter;
import com.example.heshammuhammed.menu.Retrofit.Connection;
import com.example.heshammuhammed.menu.Retrofit.MenuConnection;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.heshammuhammed.menu.Retrofit.Connection.API_KEY;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public class GetMainData {

    private MenuConnection menuConnection;
    private Call<Main> getMenu;
    private Context context;
    private Main main;
    CallBackModel callBackModel;

    public GetMainData(Context context , CallBackModel callBackModel) {
        this.context = context;
        this.callBackModel = callBackModel;
    }

    public Main getData() {
        Toast.makeText(context, "HFOD", Toast.LENGTH_LONG).show();
        menuConnection = Connection.getConnection().create(MenuConnection.class);
        getMenu = menuConnection.getMenu(new Key(API_KEY));
        getMenu.enqueue(new Callback<Main>() {
            @Override
            public void onResponse(Call<Main> call, Response<Main> response) {
                if (response != null) {
                    Log.e("RESPONSE", response.body().toString());
                    main = response.body();
                    callBackModel.getMyData(main);
                }
            }

            @Override
            public void onFailure(Call<Main> call, Throwable t) {
                Log.e("ERROR", t.getMessage().toString());
                Toast.makeText(context, "Please Enable The Internet and Try Again", Toast.LENGTH_LONG).show();
            }
        });
        return main;
    }
}
//                Toast.makeText(context, main.getData().getList().size() + "", Toast.LENGTH_LONG).show();
//                for (int i = 0; i < main.getData().getList().size(); i++) {
//                    java.util.List<List> lists = main.getData().getList();
//                    Toast.makeText(context, lists.get(i).getTitle(), Toast.LENGTH_LONG).show();
//                }
//                Toast.makeText(context, main.getData().getList().get(1).getItems().get(0).getDescription() + "YES", Toast.LENGTH_LONG).show();
//              Toast.makeText(context, main.getData().getRestaurant().getColor().toString() + " COLOR", Toast.LENGTH_LONG).show();
