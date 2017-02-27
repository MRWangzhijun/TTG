package com.mr_wang.ttg.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mr_wang.ttg.R;
import com.mr_wang.ttg.utils.SharedPreferencesUtils;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.IOException;
import java.util.List;


/**
 * Created by MR_Wang on 2017/2/22.
 */

public class Home_Fragment extends Fragment implements LocationListener {
    @ViewInject(R.id.home_top_city)
    private TextView topCity;
    private String cityName;
    //定位使用
    private LocationManager locationManager;


    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                   // topCity.setText(cityName);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        //在Fragment中注解注入

        x.view().inject(this, view);

        //获取数据并显示
        topCity.setText(SharedPreferencesUtils.getParam(getActivity(), "topCity", "位置走丢了") + "");

        topCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "成功", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

        //检查当前的GPS模块是否打开
        checkGPSIsOpen();

    }


    /**
     * 检查当前的GPS模块是否打开
     */
    private void checkGPSIsOpen() {

        //获取当前的LocationManager对象
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        boolean isOpen = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        //判断GPS定位是否打开
        if (!isOpen) {
            //进入GPS设置页面
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivityForResult(intent, 0);
        }

        //开始定位
        stateLocation();


    }

    /**
     * 使用GPS开始定位
     */
    private void stateLocation() {

        //参数：  1.定位模式  2.位置更改的最短时间（毫秒） 3.位置更改触发定位的最短距离（米）  4.监听对象
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //保存城市

        SharedPreferencesUtils.setParam(getActivity(),"topCity",topCity);
        //停止定位
        stopLocation();


    }


    /**
     * 停止定位
     */
    private void stopLocation() {
        if (locationManager != null) {
            if ((ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.removeUpdates(this);
        }
        
    }

    /**
     * 位置信息更改执行的方法
     * @param location
     */
    @Override
    public void onLocationChanged(Location location) {
        //更新当前的位置信息
        updateWithNewLocation(location);




    }

    //获取当前对应位置的经纬度，病定位城市
    private void updateWithNewLocation(Location location) {
        //默认经纬度
        double  lat=0.0,lng=0.0;

        if(location!=null) {
            lat=location.getLatitude();
            lng=location.getLongitude();
            Log.e("TAG", "当前经纬度==="+lat+"$$$$"+lng);

        }else {
            cityName="无法获取城市信息";
        }
        List<Address> list=null;
        //此类可以在经纬度和城市之间互相转换
        Geocoder ge=new Geocoder(getContext());

        try {
            list = ge.getFromLocation(lat, lng, 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        if(list!=null&&list.size()>0) {
            for(int i = 0; i < list.size(); i++) {
              Address address=list.get(i);
                cityName=address.getLocality();//获取城市名称
            }
        }
        //发送空消息
        handler.sendEmptyMessage(1);

    }

    /**
     * 当定位的状态发生改变时执行的方法
     * @param provider
     * @param status
     * @param extras
     */
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }


    /**
     * 当定位可用时执行的方法
     * @param provider
     */
    @Override
    public void onProviderEnabled(String provider) {

    }

    /**
     * 当定位不可用时执行的方法
     * @param provider
     */
    @Override
    public void onProviderDisabled(String provider) {

    }
}
