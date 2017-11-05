package app.searchlistingapp.com.presenter;

import javax.inject.Inject;

import app.searchlistingapp.com.data.DataManager;
import app.searchlistingapp.com.data.SearchDataModel;
import app.searchlistingapp.com.ui.view.MainMVPview;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by debu on 5/11/17.
 */

public class PresenterMain extends BasePresenter<MainMVPview> {
    private DataManager dataManager;
    private Disposable disposable;

    @Inject
    public PresenterMain(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(MainMVPview mvpview) {
        super.attachView(mvpview);
    }

    @Override
    public void detachView() {
        super.detachView();
        if(disposable != null)
            disposable.dispose();
    }

    public void initilize(String param){
        getMvpview().showLoading();
        disposable = dataManager.getData(param).subscribeWith(new DataObserver());
    }

    class DataObserver extends DisposableObserver<SearchDataModel>{

        @Override
        public void onNext(@NonNull SearchDataModel dataModel) {
            getMvpview().onDataReceived(dataModel);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            getMvpview().hideLoading();
            getMvpview().showError(e.getMessage());
        }

        @Override
        public void onComplete() {
            getMvpview().hideLoading();
        }
    }
}
