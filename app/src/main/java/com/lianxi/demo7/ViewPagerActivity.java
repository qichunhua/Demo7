package com.lianxi.demo7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */

public class ViewPagerActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private List<View> viewList;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    private PagerTabStrip tab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        viewPager = (ViewPager) findViewById(R.id.pager);
        tab = (PagerTabStrip) findViewById(R.id.tab);

        tab.setDrawFullUnderline(false);

        viewList = new ArrayList<>();
        titleList = new ArrayList<>();

        View view1 = View.inflate(this,R.layout.view1,null);
        View view2 = View.inflate(this,R.layout.view2,null);
        View view3 = View.inflate(this,R.layout.view3,null);
        View view4 = View.inflate(this,R.layout.view4,null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(viewList,titleList);

//        viewPager.setAdapter(myPagerAdapter);

        fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentView1());
        fragmentList.add(new FragmentView2());
        fragmentList.add(new FragmentView3());
        fragmentList.add(new FragmentView4());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList,titleList);
//        viewPager.setAdapter(myFragmentPagerAdapter);

        MyFragmentStatePagerAdapter myFragmentStatePagerAdapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(myFragmentStatePagerAdapter);
        viewPager.setOnPageChangeListener(this);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(ViewPagerActivity.this,"当前" + (position + 1) + "页",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
