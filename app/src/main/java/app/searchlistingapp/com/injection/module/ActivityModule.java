package app.searchlistingapp.com.injection.module;

import android.app.Activity;
import android.content.Context;

import app.searchlistingapp.com.injection.ActivityContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by debu on 5/11/17.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mActivity;
    }
}
