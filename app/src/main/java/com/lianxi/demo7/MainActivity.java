package com.lianxi.demo7;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Fragment1.MyListener {

    private ViewFlipper flipper;

    private int[] resId = {R.drawable.t1,R.drawable.t2,R.drawable.t3};

    private Intent intent;

    private Button bt1,bt2,bt3,bt4,bt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        Fragment fragment = fragmentManager.findFragmentById(R.id.frament);
//        Fragment1 fragment1 = (Fragment1) fragment;
//        fragment1.setSs("ssss");


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                intent = new Intent(MainActivity.this,ViewFlipperActivity.class);
                startActivity(intent);
                break;
            case R.id.bt2:
                intent = new Intent(MainActivity.this,ImageSwitcherActivity.class);
                startActivity(intent);
                break;
            case R.id.bt3:
                String str = "activity";
                Fragment1 fragment1 = new Fragment1();
                Bundle bundle = new Bundle();
                bundle.putString("str",str);
                fragment1.setArguments(bundle);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.ll,fragment1,"fragment1");
                fragmentTransaction.commit();
                break;
            case R.id.bt4:
                intent = new Intent(MainActivity.this,ViewPagerActivity.class);
                startActivity(intent);
                break;
            case R.id.bt5:
                intent = new Intent(MainActivity.this,ServiceActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void thank(String str) {
        bt3.setText(str);
    }
}
