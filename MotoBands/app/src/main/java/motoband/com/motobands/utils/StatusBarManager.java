package motoband.com.motobands.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/12/29.
 */

public class StatusBarManager {
    /**
     * 设置activity的大局沉浸式
     *
     * @param activity
     */
    public static void setActivityStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
            ViewCompat.setFitsSystemWindows(rootView, false);
            rootView.setClipToPadding(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS |
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }


    /**
     * 设置fragment的状态栏
     *
     * @param activity getActivity
     * @param view     View view =  Inflate.infate()
     * @param resId    布局
     * @param colorId  　颜色
     */
    public static void setStatusBar(Activity activity, View view, int resId, int colorId) {
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            // getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            //
            View views = view.findViewById(resId);
            views.setBackgroundColor(activity.getResources().getColor(colorId));
            views.setVisibility(View.VISIBLE);
            //获取到状态栏的高度
            int statusHeight = getStatusBarHeight(activity);
            //动态的设置隐藏布局的高度
            ViewGroup.LayoutParams layoutParams = views.getLayoutParams();
            layoutParams.height = statusHeight;
            views.setLayoutParams(layoutParams);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS |
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            View view_bar =  view.findViewById(resId);
            view_bar.setBackgroundColor(activity.getResources().getColor(colorId));
            view_bar.setVisibility(View.VISIBLE);
            //获取到状态栏的高度
            int statusHeight = getStatusBarHeight(activity);
            //动态的设置隐藏布局的高度
            ViewGroup.LayoutParams layoutParams = view_bar.getLayoutParams();
            layoutParams.height = statusHeight;
            view_bar.setLayoutParams(layoutParams);
        }
    }


    /**
     * 设置fragment的状态栏  以View为状态栏布局的
     *
     * @param activity getActivity
     * @param view     View view =  Inflate.infate()
     * @param resId    布局
     * @param colorId  　颜色
     */
    public static void setStatusBarView(Activity activity, View view, int resId, int colorId) {
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            // getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            //
            View view_bar = view.findViewById(resId);
            view_bar.setBackgroundColor(activity.getResources().getColor(colorId));
            view_bar.setVisibility(View.VISIBLE);
            //获取到状态栏的高度
            int statusHeight = getStatusBarHeight(activity);
            //动态的设置隐藏布局的高度
            ViewGroup.LayoutParams layoutParams = view_bar.getLayoutParams();
            layoutParams.height = statusHeight;
            view_bar.setLayoutParams(layoutParams);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS |
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            View view_bar = view.findViewById(resId);
            view_bar.setBackgroundColor(activity.getResources().getColor(colorId));
            view_bar.setVisibility(View.VISIBLE);
            //获取到状态栏的高度
            int statusHeight = getStatusBarHeight(activity);
            //动态的设置隐藏布局的高度
            ViewGroup.LayoutParams layoutParams = view_bar.getLayoutParams();
            layoutParams.height = statusHeight;
            view_bar.setLayoutParams(layoutParams);
        }
    }


    /**
     * 通过反射的方式获取状态栏高度
     *
     * @return
     */
    private static int getStatusBarHeight(Activity activity) {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return activity.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
