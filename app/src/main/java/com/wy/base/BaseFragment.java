package com.wy.base;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.wy.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * xutils3在继承Fragment的类中的使用
 */
@ContentView(R.layout.fragment_base)
public class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void onViewCreated(View v,Bundle savedInstanceState){
        super.onViewCreated(v, savedInstanceState);
    }

}
