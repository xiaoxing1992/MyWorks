package motoband.com.motobands.model.bean;

import java.io.Serializable;

/**
 * 开屏图片
 * Created by Administrator on 2017/11/16.
 */
public class OpenScreenModel implements Serializable {

    private String osid;     // uuID
    private String userid;   // 用户ID
    private String nickname; // 用户昵称
    private String pic;      // 图片

    public OpenScreenModel() {
    }

    public OpenScreenModel(String osid, String userid, String nickname, String pic) {
        this.osid = osid;
        this.userid = userid;
        this.nickname = nickname;
        this.pic = pic;
    }

    public String getOsid() {
        return osid;
    }

    public void setOsid(String osid) {
        this.osid = osid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "OpenScreenModel{" +
                "osid='" + osid + '\'' +
                ", userid='" + userid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
