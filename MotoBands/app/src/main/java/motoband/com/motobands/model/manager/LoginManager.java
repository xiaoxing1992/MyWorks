package motoband.com.motobands.model.manager;

/**
 * 用户登录管理器
 * Created by hua on 2015/12/26.
 */
public class LoginManager {

    public static String userid;// 用户ID
    public static String sign;// 用户sign

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;// token

    private static LoginManager instance;

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

}
