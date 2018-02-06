package motoband.com.motobands.widget.ss;

/**
 * Created by Administrator on 2018/1/29.
 * 撒飒飒
 */

public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOs;

    public Computer() {
    }

    public void setmBoard(String mBoard) {
        this.mBoard = mBoard;
    }

    public void setmDisplay(String mDisplay) {
        this.mDisplay = mDisplay;
    }

    public abstract void setOs();

    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOs='" + mOs + '\'' +
                '}';
    }
}
