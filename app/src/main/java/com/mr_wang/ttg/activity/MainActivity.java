package com.mr_wang.ttg.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mr_wang.ttg.R;
import com.mr_wang.ttg.fragment.Home_Fragment;
import com.mr_wang.ttg.fragment.My_Fragment;
import com.mr_wang.ttg.fragment.Search_Fragment;
import com.mr_wang.ttg.fragment.Tuan_Fragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener  {

    @ViewInject(R.id.radioGroup)
    private RadioGroup mRadioGroup;

    @ViewInject(R.id.home)
    private RadioButton home_but;

    private Home_Fragment home_fragment;
    private My_Fragment my_fragment;
    private Search_Fragment search_fragment;
    private Tuan_Fragment tuan_fragment;


    private FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initView();
        changFragment(new Home_Fragment(), false);
    }




    private void initView(){
        fm=getSupportFragmentManager();
        //已在布局中设置
        // home_but.setChecked(true);
        //给按钮组实现监听
        mRadioGroup.setOnCheckedChangeListener(this);

    }

    /**
     * 切换不同的Fragment
     * @param fragment
     * @param isInit  判断是否添加到回退栈
     */
    public  void  changFragment(Fragment fragment, boolean isInit){

        //开启事物
        FragmentTransaction ft=fm.beginTransaction();
        //替换Fragemnt
        ft.replace(R.id.main_fl,fragment);

        //防止出现多个碎片重叠效果
        if(!isInit) {
            ft.addToBackStack(null);
        }

        //提交事务
        ft.commit();



    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.home ://首页
                    changFragment(new Home_Fragment(),true);
                break;
            case R.id.my ://我得
                changFragment(new My_Fragment(),true);
                break;
            case R.id.search ://发现
                changFragment(new Search_Fragment(),true);
                break;
            case R.id.tuan ://团购
                changFragment(new Tuan_Fragment(),true);
                break;

        }

    }
}
