package com.example.demo.okhttp;

import android.os.Environment;
import android.util.Log;

import com.example.demo.BuildConfig;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Turing on 2017/4/13.
 */

public class L {
    private static final String TAG = "mvp";
    private static final String LOG_FILE_NAME = "keepfucklog.txt";
    static private final boolean LOG_TO_FILE = false;
    private static final String MTAG = " - mvpmvp: ";


    static {
        if (BuildConfig.DEBUG) {
            if (LOG_TO_FILE) {
                writeLog("--------------------- NEW LOG ------------------------------------\r\n");
            }
        }
    }

    public static void i(String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, localDate() + MTAG + msg);
            if (LOG_TO_FILE) {
                writeLog(localDate() + MTAG + msg);
            }
        }
    }

    public static void i(String TAG, String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, localDate() + MTAG + msg);
            if (LOG_TO_FILE) {
                writeLog(localDate() + MTAG + msg);
            }
        }
    }


    public static void e(String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, localDate() + MTAG + msg);
            if (LOG_TO_FILE) {
                writeLog(localDate() + MTAG + msg);
            }
        }
    }

    public static void e(String TAG, String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, localDate() + MTAG + msg);
            if (LOG_TO_FILE) {
                writeLog(localDate() + MTAG + msg);
            }
        }
    }


    static private String localDate() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return fmt.format(new Date());
    }

    static private void writeLog(String msg) {
        if (BuildConfig.DEBUG) {
            try {
                File file = new File(Environment.getExternalStorageDirectory().getPath() + LOG_FILE_NAME);
                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                FileChannel fc = raf.getChannel();
                fc.position(fc.size());
                fc.write(ByteBuffer.wrap(msg.getBytes()));
                fc.close();
                raf.close();
            } catch (Exception e) {

            }
        }
    }

    public static void printLongLog(String msg) {
        int logLength = 2048;
        if (msg.length() > logLength) {
            L.i("msg.length() : " + msg.length());
            for (int i = 0; i < msg.length(); i += logLength) {
                if (i + logLength < msg.length()){
                    Log.i(TAG + i, localDate() + MTAG + msg.substring(i, i + logLength));
                }
                else{
                    Log.i(TAG + i, localDate() + MTAG + msg.substring(i, msg.length()));
                }
            }
        } else
            Log.i(TAG, localDate() + MTAG + msg);
    }

}
