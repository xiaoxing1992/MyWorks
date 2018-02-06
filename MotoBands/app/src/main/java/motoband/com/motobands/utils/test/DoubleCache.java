package motoband.com.motobands.utils.test;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2018/1/23.
 */

public class DoubleCache implements ImageCache {
    MemoryCache memoryCache = new MemoryCache();
    DiskCache diskCache = new DiskCache();

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = memoryCache.get(url);
        if (bitmap == null) {
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        memoryCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }
}
