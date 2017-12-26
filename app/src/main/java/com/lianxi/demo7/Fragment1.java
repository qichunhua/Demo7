package com.lianxi.demo7;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/12/22.
 */

public class Fragment1 extends Fragment {

    private String ss;

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public interface MyListener{
        void thank(String str);
    }

    private MyListener  myListener;

    @Override
    public void onAttach(Context context) {
        myListener = (MyListener) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,container,false);
        final TextView tv1 = (TextView) view.findViewById(R.id.tv1);
        Button bt1 = (Button) view.findViewById(R.id.bt1);
        String str = getArguments().get("str") + "";
        tv1.setText(str);
        myListener.thank("tytrrrrrrrrrrrrrrrrrrrrrrrr");
        Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tv1.setText(ss);
            }
        });
        return view;
    }
}
