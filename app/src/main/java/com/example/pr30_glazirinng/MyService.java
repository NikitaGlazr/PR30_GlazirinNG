package com.example.pr30_glazirinng;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyService extends Service {
    private ThreadPoolExecutor executor;
    private static final String LOG_TAG = "MyService";
    @Override
    public void onCreate() {
        super.onCreate();
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
    }  @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Выполнение задачи
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Log.d(LOG_TAG, "ServiceTask: Started");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d(LOG_TAG, "ServiceTask: Completed");
            }
        });

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        executor.shutdown();
    }
}