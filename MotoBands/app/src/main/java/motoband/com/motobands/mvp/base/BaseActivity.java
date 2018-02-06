package motoband.com.motobands.mvp.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import motoband.com.motobands.R;
import motoband.com.motobands.utils.PreUtils;
import motoband.com.motobands.utils.ScreenUtil;
import motoband.com.motobands.widget.theme.ColorRelativeLayout;
import motoband.com.motobands.widget.theme.Theme;

/**
 * Created by Administrator on 2017/7/18.
 * 作用：这是一个普通的模板模式
 */

public abstract class BaseActivity extends Activity {

    //获取上下文
    protected Activity mContext;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        setContentView(getLayoutId());
        getIntentData();
        mContext = this;
        mUnBinder = ButterKnife.bind(this);

        //初始化ui
        initView();

        initEventAndData(savedInstanceState);
        initEventAndData();

    }

    private void setTitleHeight(View view) {
        if (view != null) {
            ColorRelativeLayout title = (ColorRelativeLayout) view.findViewById(R.id.title);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                if (title != null) {
                    ViewGroup.LayoutParams lp = title.getLayoutParams();
                    lp.height = ScreenUtil.dip2px(this, 48);
                    title.setLayoutParams(lp);
                    title.setPadding(0, 0, 0, 0);
                }
            }
        }
    }

    protected static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }

    //获取布局Id
    protected abstract int getLayoutId();



    protected void init() {
        setTranslucentStatus(true);
        onPreCreate();
        //MyApplication.getInstance().registerActivity(this);
    }

    /**
     * 设置沉浸式
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }

    private void onPreCreate() {
        Theme theme = PreUtils.getCurrentTheme(this);
        switch (theme) {
            case Blue:
                setTheme(R.style.BlueTheme);
                break;
            case Red:
                setTheme(R.style.RedTheme);
                break;
            case Brown:
                setTheme(R.style.BrownTheme);
                break;
            case Green:
                setTheme(R.style.GreenTheme);
                break;
            case Purple:
                setTheme(R.style.PurpleTheme);
                break;
            case Teal:
                setTheme(R.style.TealTheme);
                break;
            case Pink:
                setTheme(R.style.PinkTheme);
                break;
            case DeepPurple:
                setTheme(R.style.DeepPurpleTheme);
                break;
            case Orange:
                setTheme(R.style.OrangeTheme);
                break;
            case Indigo:
                setTheme(R.style.IndigoTheme);
                break;
            case LightGreen:
                setTheme(R.style.LightGreenTheme);
                break;
            case Lime:
                setTheme(R.style.LimeTheme);
                break;
            case DeepOrange:
                setTheme(R.style.DeepOrangeTheme);
                break;
            case Cyan:
                setTheme(R.style.CyanTheme);
                break;
            case BlueGrey:
                setTheme(R.style.BlueGreyTheme);
                break;
            case Black:
                setTheme(R.style.BlackTheme);
                break;
        }

    }

    protected void getIntentData() {
    }

    protected void initView() {
    }

    /**
     * 初始化时间和数据,调用在onCreate方法中
     */
    protected  void initEventAndData(){

    }

    /**
     * 带Bundle的方法,用于恢复Fragment获取其他属性的方法时候可以调用
     */
    protected void initEventAndData(Bundle savedInstanceState) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        setTitleHeight(getRootView(this));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mUnBinder.unbind();
        //  EventBus.getDefault().unregister(this);
    }
}
