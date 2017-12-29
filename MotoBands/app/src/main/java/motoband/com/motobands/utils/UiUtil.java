package motoband.com.motobands.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/11/30.
 */

public class UiUtil {

    private static UiUtil instance;


    public static UiUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (UiUtil.class) {
                if (instance == null) {
                    instance = new UiUtil(context);
                }
            }
        }
        return instance;
    }


    public static final int STANDARD_WIDTH = 1080;
    public static final int STANDARD_HEIGHT = 1872;  //基准屏幕是需要除去48px 状态栏

    private static final String DIMEN_CLASS = "com.android.internal.R$dimen";

    public float displayMetricsWidth;
    public float displayMetricsHeight;

    //初始化
    private UiUtil(Context context) {
        //获取屏幕的真实宽高
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (displayMetricsWidth == 0.0F || displayMetricsHeight == 0.0F) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            //获取到状态栏的高度
            int systemBarHeight = getSystemBarHeight(context);

            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                //横屏
                displayMetricsWidth = (float) displayMetrics.heightPixels;
                displayMetricsHeight = (float) displayMetrics.widthPixels - systemBarHeight;

            } else {
                //竖屏
                displayMetricsWidth = (float) displayMetrics.widthPixels;
                displayMetricsHeight = (float) displayMetrics.heightPixels;

            }


        }
    }

    private int getSystemBarHeight(Context context) {
        return getValues(context, DIMEN_CLASS, "system_bar_height", 48);
    }


    private int getValues(Context context, String dimenClass, String attrName, int i) {
        try {
            Class e = Class.forName(dimenClass);
            Object obj = e.newInstance();
            Field field = e.getField(attrName);
            int x = Integer.parseInt(field.get(obj).toString());
            return context.getResources().getDimensionPixelOffset(x);
        } catch (Exception e) {
            return i;
        }
    }

    //开始获取缩放以后的结果
    public float getWidth(float width) {
        return width * this.displayMetricsWidth / 1080.0F;
    }

    public float getHeight(float height) {
        return height * this.displayMetricsHeight / 1872.0F;
    }

    //开始获取缩放以后的结果
    public int getWidth(int width) {
        return (int) (width * this.displayMetricsWidth / 1080.0F);
    }

    public int getHeight(int height) {
        return (int) (height * this.displayMetricsHeight / 1872.0F);
    }
}
