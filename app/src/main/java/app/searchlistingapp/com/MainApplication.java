package app.searchlistingapp.com;

import android.app.Application;

import app.searchlistingapp.com.injection.component.ApplicationComponent;
import app.searchlistingapp.com.injection.component.DaggerApplicationComponent;
import app.searchlistingapp.com.injection.module.ApplicationModule;

/**
 * Created by debu on 5/11/17.
 */

public class MainApplication extends Application {
    private ApplicationComponent applicationComponent;
    private static MainApplication application;

    public static MainApplication getInstance() {
        assert application != null;
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        initiateInjector();
    }

    private void initiateInjector(){
        this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
