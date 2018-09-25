package com.example.heshammuhammed.menu.Model;

import android.content.Context;
import android.widget.Toast;

import com.example.heshammuhammed.menu.Interfaces.CallBackList;
import com.example.heshammuhammed.menu.POJO.Key;
import com.example.heshammuhammed.menu.POJO.Main;
import com.example.heshammuhammed.menu.Retrofit.Connection;
import com.example.heshammuhammed.menu.Retrofit.MenuConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.heshammuhammed.menu.Retrofit.Connection.API_KEY;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public class GetMenu {

    private MenuConnection menuConnection;
    private Call<Main> getMenu;
    Main main;
    Context context;
    CallBackList callBackList;

    public GetMenu(Context context, CallBackList callBackList) {
        this.context = context;
        this.callBackList = callBackList;
    }

    // Get Data From Retrofit For Second Screen (Model)
    public void getListMenu(int id, final int switchCase , final int groupId , final int childId) {
        menuConnection = Connection.getConnection().create(MenuConnection.class);
        if (id == 1) {
            getMenu = menuConnection.getArabicMenu(new Key(API_KEY));
        } else if (id == 2) {
            getMenu = menuConnection.getEnglishMenu(new Key(API_KEY));
        }

        getMenu.enqueue(new Callback<Main>() {
            @Override
            public void onResponse(Call<Main> call, Response<Main> response) {
                if (response.isSuccessful()) {
                    main = response.body();
                    if (switchCase == 0) {
                        callBackList.setMenu(main);      // Set Language
                    } else if (switchCase == 1) {
                        callBackList.setMainMenu(main ,groupId);  // Main Call
                    } else if (switchCase == 2) {
                        callBackList.setSubMenu(main , groupId , childId);   // Sub Call
                    }
                }
            }

            @Override
            public void onFailure(Call<Main> call, Throwable t) {
                Toast.makeText(context, "Please Enable The Internet and Try Again", Toast.LENGTH_LONG).show();
            }
        });
    }
}
