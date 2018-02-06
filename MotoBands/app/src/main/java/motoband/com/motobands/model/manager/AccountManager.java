package motoband.com.motobands.model.manager;

import android.text.TextUtils;

import motoband.com.motobands.model.constants.SPConstants;
import motoband.com.motobands.mvp.base.MyApplication;
import motoband.com.motobands.utils.SPUtils;

/**
 * Created by Administrator on 2017/10/31.
 */

public class AccountManager {

    private static AccountManager instance;

    private AccountManager() {
    }

    public static AccountManager getInstance() {
        if (instance == null) {
            synchronized (AccountManager.class) {
                if (instance == null) {
                    instance = new AccountManager();
                }
            }
        }
        return instance;
    }

    /**
     * 是否需要登录
     *
     * @return true：需要，false：不需要
     */
    public boolean needLogin() {
        LoginManager.userid = SPUtils.getString(MyApplication.getContext(), SPConstants.USERID, null);
        LoginManager.sign = SPUtils.getString(MyApplication.getContext(), SPConstants.SIGN, null);
        LoginManager.getInstance().setToken(SPUtils.getString(MyApplication.getContext(), SPConstants.TOKEN, null));

        return TextUtils.isEmpty(LoginManager.userid)
                || TextUtils.isEmpty(LoginManager.sign)
                || TextUtils.isEmpty(LoginManager.getInstance().getToken());
    }
}
