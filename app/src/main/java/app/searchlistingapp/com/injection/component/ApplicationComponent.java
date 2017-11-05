package app.searchlistingapp.com.injection.component;

import javax.inject.Singleton;

import app.searchlistingapp.com.MainApplication;
import app.searchlistingapp.com.data.ApiService;
import app.searchlistingapp.com.data.DataManager;
import app.searchlistingapp.com.injection.module.ApplicationModule;
import dagger.Component;

/**
 * Created by debu on 5/11/17.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainApplication application);

    ApiService provideApiService();
    DataManager provideDataManager();
}
