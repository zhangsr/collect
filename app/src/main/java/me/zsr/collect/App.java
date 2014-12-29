package me.zsr.collect;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * @description:
 * @author: Saul
 * @date: 14-10-26
 * @version: 1.0
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this, "f6zo0ccco6ma1kr587qephq14rdzy3363maiuebdcktyx1ws",
                "yyb1xoc0ytcpfvb79gnsqdfzdhtzhpaosqvror2s0fs4u1z8");

    }
}
