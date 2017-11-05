package app.searchlistingapp.com.injection.component;

import app.searchlistingapp.com.MainActivity;
import app.searchlistingapp.com.injection.PerActivity;
import app.searchlistingapp.com.injection.module.ActivityModule;
import dagger.Component;

/**
 * Created by debu on 5/11/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
