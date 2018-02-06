package motoband.com.motobands.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class AdvertisingModel implements Serializable {

    public static final int ADTYPE_SPLASH = 0;// 闪屏类型
    public static final int ADTYPE_LOOP = 1;// 轮播类型

    private int adid;
    private String adtitle;
    private int adtype;
    private long starttime;
    private long endtime;
    private int state;
    private List<AdvertisingImgModel> adlist;

    public AdvertisingModel() {
    }

    public AdvertisingModel(int adid, String adtitle, int adtype, long starttime, long endtime, int state, List<AdvertisingImgModel> adlist) {
        this.adid = adid;
        this.adtitle = adtitle;
        this.adtype = adtype;
        this.starttime = starttime;
        this.endtime = endtime;
        this.state = state;
        this.adlist = adlist;
    }

    public int getAdid() {
        return adid;
    }

    public void setAdid(int adid) {
        this.adid = adid;
    }

    public String getAdtitle() {
        return adtitle;
    }

    public void setAdtitle(String adtitle) {
        this.adtitle = adtitle;
    }

    public int getAdtype() {
        return adtype;
    }

    public void setAdtype(int adtype) {
        this.adtype = adtype;
    }

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<AdvertisingImgModel> getAdlist() {
        return adlist;
    }

    public void setAdlist(List<AdvertisingImgModel> adlist) {
        this.adlist = adlist;
    }

    @Override
    public String toString() {
        return "AdvertisingModel{" +
                "adid=" + adid +
                ", adtitle='" + adtitle + '\'' +
                ", adtype=" + adtype +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", state=" + state +
                ", adlist=" + adlist +
                '}';
    }
}
