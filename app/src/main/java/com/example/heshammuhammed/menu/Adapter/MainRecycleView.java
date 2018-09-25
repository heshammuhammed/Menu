package com.example.heshammuhammed.menu.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heshammuhammed.menu.POJO.Meal;
import com.example.heshammuhammed.menu.POJO.Title;
import com.example.heshammuhammed.menu.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.view.Window.FEATURE_NO_TITLE;

/**
 * Created by HeshamMuhammed on 9/24/2018.
 */

// Recycle View For Menu Lists

public class MainRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Object> catalogues;

    public MainRecycleView(Context context, List<Object> catalogues) {
        this.context = context;
        this.catalogues = catalogues;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder holder;
        View view;
        switch (viewType) {
            case R.layout.title:
                view = LayoutInflater.from(context).inflate(R.layout.title, parent, false);
                holder = new TitleViewHolder(view);
                break;
            case R.layout.meal_details:
                view = LayoutInflater.from(context).inflate(R.layout.meal_details, parent, false);
                holder = new MyViewHolder(view);
                break;
            default:
                view = LayoutInflater.from(context).inflate(R.layout.title, parent, false);
                holder = new TitleViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            final Meal meal = (Meal) catalogues.get(position);
            ((MyViewHolder) holder).name.setText(meal.getNames());
            ((MyViewHolder) holder).price.setText(meal.getPrices());
            ((MyViewHolder) holder).descrption.setText(meal.getDescription());
            ((MyViewHolder) holder).price.setText(meal.getPrices());
            Picasso.get().load(meal.getImages()).into(((MyViewHolder) holder).image);
            ((MyViewHolder) holder).image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.imageview);
                    ImageView image = dialog.findViewById(R.id.dialogimage);
                    Picasso.get().load(meal.getImages()).into(image);
                    dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    dialog.show();
                }
            });

        } else if (holder instanceof TitleViewHolder) {
            Title title = (Title) catalogues.get(position);
            ((TitleViewHolder) holder).title.setText(title.getTitle());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (catalogues.get(position) instanceof Title) {
            return R.layout.title;
        } else if (catalogues.get(position) instanceof Meal) {
            return R.layout.meal_details;
        } else
            return -1;
    }

    @Override
    public int getItemCount() {
        return catalogues.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView price;
        TextView descrption;
        TextView name;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.mealimage);
            price = itemView.findViewById(R.id.mealprice);
            descrption = itemView.findViewById(R.id.mealdetails);
            name = itemView.findViewById(R.id.mealname);
        }
    }

    public class TitleViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public TitleViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.maintitle);
        }
    }
}