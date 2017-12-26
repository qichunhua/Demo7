package com.lianxi.demo7;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */

public class MyPagerAdapter extends PagerAdapter {
    private List<View> viewList;
    private List<String> titleList;

    public MyPagerAdapter(List<View> viewList,List<String> titleList){
        this.viewList = viewList;
        this.titleList = titleList;
    }
    //返回的是页面的数量
    @Override
    public int getCount() {
        return viewList.size();
    }

    //View是不是来自于对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //实例化一个页面
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.i("size",viewList.size() + "---------------------------");
        Log.i("position",position + "---------------------------");
        View view = viewList.get(position);
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    //销毁一个页面
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    //设置view页面的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
