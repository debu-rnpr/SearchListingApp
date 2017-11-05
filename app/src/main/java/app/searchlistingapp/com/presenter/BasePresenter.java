package app.searchlistingapp.com.presenter;


import app.searchlistingapp.com.ui.view.MVPview;

/**
 * Created by debu on 5/11/17.
 */

public class BasePresenter<V extends MVPview> implements Presenter<V> {
    V mvpview;
    @Override
    public void attachView(V mvpview) {
        this.mvpview = mvpview;
    }

    @Override
    public void detachView() {
        this.mvpview = null;
    }

    public V getMvpview() {
        assert (this.mvpview != null);
        return mvpview;
    }
}
