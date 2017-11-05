package app.searchlistingapp.com.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by debu on 5/11/17.
 */

@Singleton
public class DataManager {
    private final ApiService apiService;

    @Inject
    public DataManager(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<SearchDataModel> getData(String param){
        return this.apiService.getData(param)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
