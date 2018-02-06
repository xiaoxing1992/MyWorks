package motoband.com.motobands.utils.test;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by Administrator on 2018/1/23.
 */

public class MemoryCache implements ImageCache {

    private LruCache<String, Bitmap> lruCache;

    public MemoryCache() {
        initImageCache();
    }

    private void initImageCache() {
        //可使用的最大内存
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取最大内存的4分之一 作为缓存
        int cacheSize = maxMemory / 4;
        // Bitmap所占用的内存空间数等于Bitmap的每一行所占用的空间数乘以Bitmap的行数
        lruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                // Bitmap所占用的内存空间数等于Bitmap的每一行所占用的空间数乘以Bitmap的行数
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(String url) {
        return lruCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        lruCache.put(url, bitmap);
    }

}
