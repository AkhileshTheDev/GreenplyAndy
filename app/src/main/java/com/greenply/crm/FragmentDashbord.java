
package com.greenply.crm;


import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.greenply.crm.Adapter.DashPagerAdapter;
import java.util.ArrayList;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


public class FragmentDashbord extends Fragment {

    ArrayList<Integer> mListImg = new ArrayList<>();
    ViewPager mViewPager;
    LinearLayout mLayoutDots;


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashbord, container, false);
        mViewPager = (ViewPager) rootView.findViewById(R.id.mViewPager);
        mLayoutDots = (LinearLayout) rootView.findViewById(R.id.mLayoutDots);
        initList();
        DashPagerAdapter introAdapter = new DashPagerAdapter(getActivity(),mListImg);
        mViewPager.setAdapter(introAdapter);
        addBottomDots(0, mLayoutDots,mListImg.size());

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            addBottomDots(position, mLayoutDots,mListImg.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return rootView;
    }

    private void initList() {
        mListImg.add(R.drawable.banner);
        mListImg.add(R.drawable.banner);
        mListImg.add(R.drawable.banner);
    }

    private void addBottomDots(int currentPage, LinearLayout mLayoutDots, int len) {
        TextView[] dots = new TextView[len];
        int[] colorsActive = new int[0];
        int[] colorsInactive = new int[0];
        colorsActive = getResources().getIntArray(R.array.array_dot_active_3);
        colorsInactive = getResources().getIntArray(R.array.array_dot_inactive_3);

        mLayoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(50);
            dots[i].setTextColor(colorsInactive[currentPage]);
            mLayoutDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

}