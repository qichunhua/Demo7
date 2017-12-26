package com.lianxi.demo7;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * 图片轮播
 */

public class ViewFlipperActivity extends AppCompatActivity {

    private android.widget.ViewFlipper flipper;

//    private int[] resId = {R.drawable.t1,R.drawable.t2,R.drawable.t3};
private String[] resId = {"#000000","#000fff","#ffffff"};
    private float startX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfilpper);
        flipper = (android.widget.ViewFlipper) findViewById(R.id.flipper);

        for (int i = 0;i < resId.length;i++){
            flipper.addView(getImageView(resId[i]));
        }
//        //设定ViewFlipper视图切换的时间间隔
//        flipper.setFlipInterval(3000);
//        //开始播放
//        flipper.startFlipping();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            //手指落下
            case MotionEvent.ACTION_DOWN:
            {
                startX = event.getX();
                break;
            }

            //手指滑动
            case MotionEvent.ACTION_MOVE:
            {
                if (event.getX() - startX > 100){
                    flipper.showPrevious();//显示前一页
                }

                if(startX - event.getX() > 100){
                    flipper.showNext();//显示后一页
                }
                break;
            }
            //手指离开
            case MotionEvent.ACTION_UP:
            {
                break;
            }
        }
        return super.onTouchEvent(event);
    }

    private ImageView getImageView(String resId){
        ImageView imageView = new ImageView(this);
//        imageView.setImageResource(resId);
//        imageView.setBackgroundResource(resId);
        imageView.setBackgroundColor(Color.parseColor(resId));
        return imageView;
    }
}
