package com.kaungkhantlynn.testingtab;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

/**
 * Created by kaungkhantlynn on 12/13/15.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
