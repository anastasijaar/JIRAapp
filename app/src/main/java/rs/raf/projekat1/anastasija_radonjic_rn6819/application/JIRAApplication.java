package rs.raf.projekat1.anastasija_radonjic_rn6819.application;

import android.app.Application;

import timber.log.Timber;

public class JIRAApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
