package com.example.env107.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AnotherRightFragment extends Fragment {

    @Nullable
    @Override
    //重写该方法去指定布局
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.
                inflate(R.layout.another_right_fragment,container,false);
    }
}