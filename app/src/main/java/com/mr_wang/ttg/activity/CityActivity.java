package com.mr_wang.ttg.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.mr_wang.ttg.R;
import com.mr_wang.ttg.entity.City;
import com.mr_wang.ttg.utils.CONSTS;
import com.mr_wang.ttg.view.SiderBar;
import org.xutils.http.annotation.HttpResponse;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.x;

/**
 * Created by MR_Wang on 2017/2/24.
 */

@ContentView(R.layout.city_activity)
public class CityActivity extends Activity implements SiderBar.OnTouchingLetterChangedListener{

    @ViewInject(R.id.city_listview)
    private ListView listDatas;

    private List<City> cityList;




    @ViewInject(R.id.city_siderbar)
    private SiderBar siderBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        View view= LayoutInflater.from(this).inflate(R.layout.city_activity,null,false);
        listDatas.addHeaderView(view);
        cityList=new ArrayList<City>();
        //执行异步任务
        new execute();
        //给自定义View控件SiderBar设置Touch监听
        siderBar.setOnTouchLetterChangedListener(this);

    }


        @OnClick({R.id.index_city_back,R.id.index_city_flushcity})
        public void onClick(View view){
            switch (view.getId()) {
                case R.id.index_city_back ://返回
                    finish();
                    break;
                case R.id.index_city_flushcity://刷新
                    new CityDataTask().execute();
                    break;
            }
        }


    @OnItemClick({R.id.city_list})
    public void onItemClick(AdapterView<?> parent,View view,int position){
        Intent intent=new Intent();
        TextView textview=view.findViewById(R.id.city_list_item_name);
        intent.putExtra("citName", textview.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }


    @Override
    public void onTouchingLetterChanged(String s) {
            //找到listView中显示的索引位置
            listDatas.setSelection(findIndex(cityList,s));
    }

    private int findIndex(List<City> cityList, String s) {


    }

    private class CityDataTask extends AsyncTask<Void,Void,List<City>> {


        @Override
        protected List<City> doInBackground(Void... params) {
            HttpClient client=new DefaultHttpClick();
            HttpPost httpPost=new HttpPost(CONSTS.City_Data_URL);


            try {
                HttpResponse httpResponse=client.execue(httpPost);
                if(httpResponse.getStatusLine().getStatusCode()==200) {
                    String jsonString = EntityUtils.toString(httpResponse.getEn);

                    return parseCityDatasJson(jsonString);
                }
                } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //关闭
                client.getConnectionManager().closeExpiredConnections();
                httpPost.abort();//中断请求
            }
            return null;
        }
    }


    protected  void onPostExecute(List<City> result){}
}
