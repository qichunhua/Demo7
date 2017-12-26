package com.lianxi.demo7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

/**
 * Created by Administrator on 2017/12/19.
 */

public class ImageSwitcherActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private ImageSwitcher is;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageswitcher);
        is = (ImageSwitcher) findViewById(R.id.is);
        is.setBackgroundResource(R.drawable.t2);
        is.setFactory(this);
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }
}
