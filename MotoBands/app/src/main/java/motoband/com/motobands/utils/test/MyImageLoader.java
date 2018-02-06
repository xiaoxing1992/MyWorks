package motoband.com.motobands.utils.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Administrator on 2018/1/23.
 */

public class MyImageLoader {
    //内存缓存
    ImageCache imageCache = new MemoryCache();


    //线程池   线程数为cpu的数量
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private Handler handler = new Handler(Looper.getMainLooper());

    private void updateImageView(final ImageView imageView, final Bitmap bitmap) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    //注入缓存实现
    public void setMemoryCache(ImageCache cache) {
        this.imageCache = cache;
    }

    public void displayImage(final String url, final ImageView imageView) {

        Bitmap imageCacheLruCache = imageCache.get(url);
        if (imageCacheLruCache != null) {
            imageView.setImageBitmap(imageCacheLruCache);
            return;
        }

        submitLoadRequest(url, imageView);
    }

    private void submitLoadRequest(final String url, final ImageView imageView) {
        imageView.setTag(url);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downLoadImage(url);
                if (bitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    updateImageView(imageView, bitmap);
                }
                imageCache.put(url, bitmap);
            }
        });
    }


    private Bitmap downLoadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(httpURLConnection.getInputStream());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
