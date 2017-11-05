package app.searchlistingapp.com.injection.module;

import android.app.Application;

import javax.inject.Singleton;

import app.searchlistingapp.com.data.ApiService;
import app.searchlistingapp.com.data.DataManager;
import dagger.Module;
import dagger.Provides;

/**
 * Created by debu on 5/11/17.
 */

@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    ApiService provideApiService() {
        return ApiService.Factory.create();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(ApiService apiService){
        return new DataManager(apiService);
    }

}
