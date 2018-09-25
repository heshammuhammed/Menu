package com.example.heshammuhammed.menu.View;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.heshammuhammed.menu.Interfaces.MainScreenInterface;
import com.example.heshammuhammed.menu.Presenter.MainScreenPresenter;
import com.example.heshammuhammed.menu.R;
import com.squareup.picasso.Picasso;

public class MainScreen extends AppCompatActivity implements View.OnClickListener, MainScreenInterface.View {

    ImageView showRestaurant, showLanguage, mainIcon;
    TextView arabicLang, englishLang;
    int chooseLanguage = 0;
    MainScreenInterface.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arabicLang = findViewById(R.id.arabicText);
        englishLang = findViewById(R.id.englishText);
        showLanguage = findViewById(R.id.languageImage);
        showRestaurant = findViewById(R.id.resturantImage);
        mainIcon = findViewById(R.id.imageView4);

        arabicLang.setVisibility(View.INVISIBLE);
        englishLang.setVisibility(View.INVISIBLE);

        showLanguage.setOnClickListener(this);
        showRestaurant.setOnClickListener(this);
        arabicLang.setOnClickListener(this);
        englishLang.setOnClickListener(this);

        presenter = new MainScreenPresenter(this, this);
        presenter.getImageAndColor();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.languageImage:
//                Toast.makeText(this, "LANGUAGE", Toast.LENGTH_LONG).show();
                if (arabicLang.getVisibility() == View.INVISIBLE && englishLang.getVisibility() == View.INVISIBLE) {
                    arabicLang.setTextColor(Color.parseColor("#FFFFFF"));
                    englishLang.setTextColor(Color.parseColor("#FFFFFF"));
                    chooseLanguage = 0;
                    arabicLang.setVisibility(View.VISIBLE);
                    englishLang.setVisibility(View.VISIBLE);
                } else {
                    chooseLanguage = 0;
                    arabicLang.setVisibility(View.INVISIBLE);
                    englishLang.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.resturantImage:
//                Toast.makeText(this, "RESTAURANT", Toast.LENGTH_LONG).show();
                if (chooseLanguage == 0) {
                    Toast.makeText(this, "Please Select Language", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(this,FoodList.class);
                    intent.putExtra("ID",chooseLanguage);
                    startActivity(intent);
                }
                break;
            case R.id.arabicText:
//                Toast.makeText(this, "Arabic is Chosen", Toast.LENGTH_LONG).show();
                arabicLang.setTextColor(Color.parseColor("#D04F53"));
                englishLang.setTextColor(Color.parseColor("#FFFFFF"));
                chooseLanguage = 1; // Selected Arabic
                break;
            case R.id.englishText:
//                Toast.makeText(this, "English is Chosen", Toast.LENGTH_LONG).show();
                englishLang.setTextColor(Color.parseColor("#D04F53"));
                arabicLang.setTextColor(Color.parseColor("#FFFFFF"));
                chooseLanguage = 2; // Select English
                break;
        }
    }

    // Set Color and Image At Starting
    @Override
    public void showImageAndColor(String image, String color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.parseColor(color));
        Picasso.get().load(image).into(mainIcon);
    }

    @Override
    protected void onStart() {
        super.onStart();
        chooseLanguage = 0;
        arabicLang.setVisibility(View.INVISIBLE);
        englishLang.setVisibility(View.INVISIBLE);
        arabicLang.setTextColor(Color.parseColor("#FFFFFF"));
        englishLang.setTextColor(Color.parseColor("#FFFFFF"));
    }
}