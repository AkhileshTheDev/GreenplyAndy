package com.greenply.crm.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.greenply.crm.R;
import com.greenply.crm.custome_views.TextViewBold;

import java.util.ArrayList;
import androidx.viewpager.widget.PagerAdapter;

/**
 * Created by Nikita Pathak on 29/04/2020.
 */

public class IntroAdapter extends PagerAdapter {
    LayoutInflater layoutInflater;
    Activity context;
    ArrayList<Integer> mListItem;
    ArrayList<String> mListStr;


    public IntroAdapter(Activity context, ArrayList<Integer> mListItem, ArrayList<String> mListStr) {
    this.context = context;
    this.mListItem = mListItem;
    this.mListStr = mListStr;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_pager_intro, container, false);
        ImageView mImageProduct = (ImageView)view.findViewById(R.id.mImageProduct);
        TextViewBold mTxtPager = (TextViewBold)view.findViewById(R.id.mTxtPager);
        mImageProduct.setImageResource(mListItem.get(position));
        mTxtPager.setText(mListStr.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return mListItem.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
