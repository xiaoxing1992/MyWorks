package motoband.com.motobands.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/25.
 */
public class AdvertisingImgModel implements Serializable{

    public static final int ADLinkType_Link = 0;// 普通外链
    public static final int ADLinkType_MGP = 1;// 活动（MotobandGP）
    public static final int ADLinkType_Keyword = 2;// 话题页面
    public static final int ADLinkType_Mall = 3;// 商品详细页
    public static final int ADLinkType_Insurance = 4;// 保险页面
    public static final int ADLinkType_Finance = 5;// 贷款页面
    public static final int ADLinkType_Box = 6;// 文章详细页面

    private int adimgid;
    private int adid;
    private int linktype;
    private String imgurl;
    private String linkurl;
    private int gpid;
    private String keyword;
    private String mallurl;
    private String boxid;
    private int orderindex;

    public AdvertisingImgModel() {
    }

    public AdvertisingImgModel(int adimgid, int adid, int linktype, String imgurl, String linkurl, int gpid, String keyword, String mallurl, String boxid, int orderindex) {
        this.adimgid = adimgid;
        this.adid = adid;
        this.linktype = linktype;
        this.imgurl = imgurl;
        this.linkurl = linkurl;
        this.gpid = gpid;
        this.keyword = keyword;
        this.mallurl = mallurl;
        this.boxid = boxid;
        this.orderindex = orderindex;
    }

    public int getAdimgid() {
        return adimgid;
    }

    public void setAdimgid(int adimgid) {
        this.adimgid = adimgid;
    }

    public int getAdid() {
        return adid;
    }

    public void setAdid(int adid) {
        this.adid = adid;
    }

    public int getLinktype() {
        return linktype;
    }

    public void setLinktype(int linktype) {
        this.linktype = linktype;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public int getGpid() {
        return gpid;
    }

    public void setGpid(int gpid) {
        this.gpid = gpid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMallurl() {
        return mallurl;
    }

    public void setMallurl(String mallurl) {
        this.mallurl = mallurl;
    }

    public String getBoxid() {
        return boxid;
    }

    public void setBoxid(String boxid) {
        this.boxid = boxid;
    }

    public int getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(int orderindex) {
        this.orderindex = orderindex;
    }

    @Override
    public String toString() {
        return "AdvertisingImgModel{" +
                "adimgid=" + adimgid +
                ", adid=" + adid +
                ", linktype=" + linktype +
                ", imgurl='" + imgurl + '\'' +
                ", linkurl='" + linkurl + '\'' +
                ", gpid=" + gpid +
                ", keyword='" + keyword + '\'' +
                ", mallurl='" + mallurl + '\'' +
                ", boxid='" + boxid + '\'' +
                ", orderindex=" + orderindex +
                '}';
    }
}
