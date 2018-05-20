package first.person.com.katekit.githubpersonfirst;

import android.app.Application;

import com.katekit.common.util.log.LogCrash;

/**
 * Created by 黄明灿 on 2018/5/20 16:05.
 * Describe :
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new LogCrash());
    }
}
