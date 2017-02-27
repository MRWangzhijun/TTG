package com.mr_wang.ttg.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.mr_wang.ttg.R;

/**
 * Created by MR_Wang on 2017/2/24.
 */

public class SiderBar extends View {
    //创建对象时调用
    public SiderBar(Context context) {
        super(context);
    }

    //xml文件创建控件对象时调用
    public SiderBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    private Paint paint=new Paint();;//画笔

    //字母列表
    private static  String[] sideBar={"热门","A","B","C","D","E","F","G","H","I","J","K"
                                            ,"L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};


    private  OnTouchingLetterChangedListener letterChangedListener;


    private int choose;


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔颜色
        paint.setColor(Color.GRAY);
        //设置字体样式粗体
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextSize(20);

        //获取自定义View的宽高，是在配置文件中定义的
        int height=getHeight();
        int width=getWidth();

        //s设定每个字母所在控件的高度
        int each_height=height/sideBar.length;

        //给每个字母绘制出来

        for(int i = 0; i < sideBar.length; i++) {
            //字体所在区域在X轴的偏移量
            float x=width/2-paint.measureText(sideBar[i])/2;

            //字体所在区域在y轴的偏移量
            float y=(1+i)*each_height;

            canvas.drawText(sideBar[i],x,y,paint);
        }


    }


    /**
     * 定义监听事件接口
     */
    public interface OnTouchingLetterChangedListener{
        //根据滑动位置的索引做出处理  参数：字母索引
         void onTouchingLetterChanged(String s);
    }

    public void setLetterChangedListener(OnTouchingLetterChangedListener letterChangedListener) {
        this.letterChangedListener = letterChangedListener;
    }

    //分发对应的touch监听
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final  int action=event.getAction();//获取对应动作
        final  float y=event.getY();//点击的Y坐标
        final  OnTouchingLetterChangedListener listener=letterChangedListener;
        //获取点击Y轴坐标所占总高度的比例*数组长度= 数组中点击的字母索引
        final int c=(int) (y/getHeight()*sideBar.length);
        switch (action) {
            case MotionEvent.ACTION_UP ://手指抬起
                setBackgroundResource(android.R.color.transparent);
                invalidate();
                break;

            default:
                setBackgroundResource(R.drawable.sidebar_background);
                if(c>0&&c<sideBar.length) {
                    if(listener!=null) {
                        listener.onTouchingLetterChanged(sideBar[c]);
                    }
                    choose=c;
                    invalidate();
                }
                break;
        }
        return true;//直接响应，不再进行分发，
    }
}
