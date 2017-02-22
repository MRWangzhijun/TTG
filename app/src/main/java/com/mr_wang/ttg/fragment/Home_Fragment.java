package com.mr_wang.ttg.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mr_wang.ttg.R;

/**
 * Created by MR_Wang on 2017/2/22.
 */

public class Home_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView view = new TextView(getActivity());
        view.setText("一");
        return inflater.inflate(R.layout.fragment_home,container,false);
    }
}
