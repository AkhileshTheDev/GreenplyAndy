package com.greenply.crm.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.greenply.crm.Modal.Menu;
import com.greenply.crm.R;
import com.greenply.crm.custome_views.TextViewRegular;

import java.util.ArrayList;


public class MenuAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    Activity context;
    ArrayList<Menu> mListMenu;
    
    public MenuAdapter(Activity context, ArrayList<Menu> mListMenu)
    {
        this.context = context;
        this.mListMenu = mListMenu;
    }
    static class ViewHolder {
        TextViewRegular txtMenuTitle;
        ImageView imgMenuIcon;
    }
    
    @Override
    public int getCount() {
        return mListMenu.size();
    }
    @Override
    public Object getItem(int location) {
        return mListMenu.get(location);
    }
    @Override
    public long getItemId(int position) {
       return mListMenu.indexOf(getItem(position));
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_side_menu, null);
            holder = new ViewHolder();
            holder.txtMenuTitle = (TextViewRegular) convertView.findViewById(R.id.txtMenuTitle);
            holder.imgMenuIcon = (ImageView) convertView.findViewById(R.id.imgMenuIcon);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Menu menu = mListMenu.get(position);
        holder.txtMenuTitle.setText(menu.getmStrMenuName());
        holder.imgMenuIcon.setImageResource(menu.getmIntMenuImg());
        return convertView;
    }
}
