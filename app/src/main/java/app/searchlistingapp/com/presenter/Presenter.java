package app.searchlistingapp.com.presenter;


import app.searchlistingapp.com.ui.view.MVPview;

/**
 * Created by debu on 5/11/17.
 */

public interface Presenter<V extends MVPview> {
    void attachView(V mvpview);

    void detachView();
}
