package motoband.com.motobands.utils.test;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2018/1/23.
 */

public interface ImageCache {

    Bitmap get(String url);

    void put(String url, Bitmap bitmap);
}
