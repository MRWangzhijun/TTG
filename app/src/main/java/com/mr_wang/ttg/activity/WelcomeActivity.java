package com.mr_wang.ttg.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.mr_wang.ttg.R;
import com.mr_wang.ttg.adapter.ViewPage_adapter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by MR_Wang on 2017/2/22.
 */

@ContentView(R.layout.welcome_page)
public class WelcomeActivity extends Activity{


    @ViewInject(R.id.wel_img)
    private ImageView wel_img;

    @ViewInject(R.id.wel_vp)
    private ViewPager wel_vp;

    @ViewInject(R.id.wel_btn)
    private ImageButton wel_btn;
    private List<ImageView> list;
    private ViewPage_adapter viewPage_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        showPage();
        getData();
        initViewPage();
    }


    private void showPage(){
        Timer timer=new Timer(true);

        TimerTask task=new TimerTask(){

            @Override
            public void run() {
                wel_img.setVisibility(View.GONE);
                wel_vp.setVisibility(View.VISIBLE);
            }
        };

        timer.schedule(task,3);

    }

    private void initViewPage() {
        wel_vp.setAdapter(viewPage_adapter);
        wel_vp.setOnPageChangeListener(new MyPageChangeListener());

    }

    private void getData(){
        ImageView img;
        int [] image={R.drawable.guide_01,R.drawable.guide_02,R.drawable.guide_03};
        list = new ArrayList<>();
        for(int i = 0; i < image.length; i++) {
             img=new ImageView(this);
            img.setImageResource(image[i]);
            list.add(img);
        }


        viewPage_adapter=new ViewPage_adapter(list);
    }

    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
