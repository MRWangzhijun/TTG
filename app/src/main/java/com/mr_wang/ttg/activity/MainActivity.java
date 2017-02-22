package com.mr_wang.ttg.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
public class MainActivity extends AppCompatActivity {
    private final String TAG = "SpeedDialActivity";

    @ViewInject(R.id.radioGroup)
    private RadioGroup mRadioGroup;
    @ViewInject(R.id.radioGroup)
    private Home_Fragment home_fragment;
    @ViewInject(R.id.radioGroup)
    private My_Fragment my_fragment;
    @ViewInject(R.id.radioGroup)
    private Search_Fragment search_fragment;
    @ViewInject(R.id.radioGroup)
    private Tuan_Fragment tuan_fragment;

    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);
        //setContentView(R.layout.activity_main);
      //  init_date();
       // setupWidgets();
    }


    private void init_date(){
        transaction = getFragmentManager()
                .beginTransaction();
        if (null == home_fragment) {
            home_fragment = new Home_Fragment();
        }
        transaction.add(R.id.main_fl,
                home_fragment);
        // Commit the transaction
        transaction.commit();
    }

    private void setupWidgets() {

        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                switch (checkedId) {
                    case R.id.home:
                        Log.v(TAG, "home_fragment");
                        if (null == home_fragment) {
                            home_fragment = new Home_Fragment();
                        }
                        transaction = getFragmentManager()
                                .beginTransaction();
                        transaction.replace(R.id.main_fl,
                                home_fragment);
                        // Commit the transaction
                        transaction.commit();
                        break;
                    case R.id.my:
                        Log.v(TAG, "my_fragment");
                        if (null == my_fragment) {
                            my_fragment = new My_Fragment();
                        }
                        transaction = getFragmentManager()
                                .beginTransaction();
                        transaction.replace(R.id.main_fl,
                                my_fragment);
                        // Commit the transaction
                        transaction.commit();
                        break;
                    case R.id.search:
                        Log.v(TAG, "setupWidgets():radio2 clicked");

                        if (null == search_fragment) {
                            search_fragment = new Search_Fragment();
                        }
                        transaction = getFragmentManager()
                                .beginTransaction();
                        transaction.replace(R.id.main_fl,
                                search_fragment);
                        // Commit the transaction
                        transaction.commit();
                        break;

                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        // dataEncapsulation.closeDataBase_speedDial();
    }
}
