package com.example.pr30_glazirinng;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";
    final int TASK1_CODE = 1;
    final int TASK2_CODE = 2;
    final int TASK3_CODE = 3;
    final Date startTime = new Date(); // Время старта задачи
    TextView tvTask1;
    TextView tvTask2;
    TextView tvTask3;
    ExecutorService executorService;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTask1 = findViewById(R.id.tvTask1);
        tvTask2 = findViewById(R.id.tvTask2);
        tvTask3 = findViewById(R.id.tvTask3);

        executorService = Executors.newFixedThreadPool(2);
    }
    public void onClickButton1(View view) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Log.d(LOG_TAG, "Task1: Started");
                try {
                    TimeUnit.SECONDS.sleep(8);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Date endTime = new Date(); // Время завершения задачи
                        long executionTimeMs = endTime.getTime() - startTime.getTime(); // Разница во времени в миллисекундах
                        long executionTimeSec = executionTimeMs / 1000; // время выполнения в секундах
                        String formattedExecutionTime = decimalFormat.format(executionTimeSec);
                        tvTask1.setText("Task1: Completed " + formattedExecutionTime + " sec");
                        Log.d(LOG_TAG, "Task1: Completed in " + formattedExecutionTime + " sec");
                    }
                });
            }
        });
    }

    public void onClickButton2(View view) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Log.d(LOG_TAG, "Task2: Started");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Date endTime = new Date(); // Время завершения задачи
                        long executionTimeMs = endTime.getTime() - startTime.getTime(); // Разница во времени в миллисекундах
                        long executionTimeSec = executionTimeMs / 1000; // время выполнения в секундах
                        String formattedExecutionTime = decimalFormat.format(executionTimeSec);
                        tvTask2.setText("Task2: Completed "+ formattedExecutionTime + " sec");
                        Log.d(LOG_TAG, "Task2: Completed in " + formattedExecutionTime + " sec");
                    }
                });
            }
        });
    }

    public void onClickButton3(View view) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Log.d(LOG_TAG, "Task3: Started");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Date endTime = new Date(); // Время завершения задачи
                        long executionTimeMs = endTime.getTime() - startTime.getTime(); // Разница во времени в миллисекундах
                        long executionTimeSec = executionTimeMs / 1000; // время выполнения в секундах
                        String formattedExecutionTime = decimalFormat.format(executionTimeSec);
                        tvTask3.setText("Task3: Completed "+ formattedExecutionTime + " sec");
                        Log.d(LOG_TAG, "Task3: Completed in " + formattedExecutionTime + " sec");
                    }
                });
            }
        });
    }

    public void onClickButtonClear(View view) {
        tvTask1.setText("Task1: "); // Очистка текста
        tvTask2.setText("Task2: "); // Очистка текста
        tvTask3.setText("Task3: "); // Очистка текста
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }
}