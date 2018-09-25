package com.example.heshammuhammed.menu.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.example.heshammuhammed.menu.R;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HeshamMuhammed on 9/23/2018.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    List<String> listData;
    HashMap<String, List<String>> hashMap;

    public ExpandableListAdapter(Context context, List<String> listData, HashMap<String, List<String>> hashMap) {
        this.context = context;
        this.listData = listData;
        this.hashMap = hashMap;
    }

    @Override
    public int getGroupCount() {
        return listData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return hashMap.get(listData.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listData.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return hashMap.get(listData.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(i);
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.main_category_row,null);
        }
        TextView textView  = view.findViewById(R.id.mainCategoryText);
        textView.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String childTitle = (String) getChild(i , i1);
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.sub_category_row,null);
        }
        TextView textView  = view.findViewById(R.id.subCategoryText);
        textView.setText(childTitle);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}