package com.greenply.crm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.greenply.crm.Adapter.IntroAdapter;
import com.greenply.crm.custome_views.TextViewRegular;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class IntroScreen extends AppCompatActivity {

    ViewPager mViewPager;
    LinearLayout mLayoutDots;
    ArrayList<Integer> mListImg = new ArrayList<>();
    ArrayList<String> mListStr = new ArrayList<>();
    TextViewRegular mTxtNextBtn;
    RelativeLayout mLayoutNext;
    int curr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        mLayoutDots = (LinearLayout) findViewById(R.id.mLayoutDots);
        mTxtNextBtn = (TextViewRegular) findViewById(R.id.mTxtNextBtn);
        mLayoutNext = (RelativeLayout) findViewById(R.id.mLayoutNext);
        initList();
        IntroAdapter introAdapter = new IntroAdapter(IntroScreen.this,mListImg,mListStr);
        mViewPager.setAdapter(introAdapter);
        addBottomDots(0, mLayoutDots,mListImg.size());


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position, mLayoutDots,mListImg.size());
                if(position==2){
                    mTxtNextBtn.setText("FINISH");
                    mLayoutNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(IntroScreen.this, LoginScreen.class);
                            startActivity(i);
                            finish();
                        }
                    });
                }else {
                    mTxtNextBtn.setText("NEXT");
                    mLayoutNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            curr = mViewPager.getCurrentItem();
                            curr= curr+1;
                            mViewPager.setCurrentItem(curr, true);
                        }
                    });
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void initList() {
        mListImg.add(R.drawable.intro_one);
        mListImg.add(R.drawable.intro_two);
        mListImg.add(R.drawable.intro_three);
        mListStr.add("Create Your Own Digital Card");
        mListStr.add("Add Your Work Projects");
        mListStr.add("Share Your Card with Portfolio");
    }

    private void addBottomDots(int currentPage, LinearLayout mLayoutDots, int len) {
        TextView[] dots = new TextView[len];
        int[] colorsActive = new int[0];
        int[] colorsInactive = new int[0];
        colorsActive = getResources().getIntArray(R.array.array_dot_active_3);
        colorsInactive = getResources().getIntArray(R.array.array_dot_inactive_3);

        mLayoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(IntroScreen.this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(50);
            dots[i].setTextColor(colorsInactive[currentPage]);
            mLayoutDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}