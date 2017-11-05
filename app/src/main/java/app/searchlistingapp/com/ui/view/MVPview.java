package app.searchlistingapp.com.ui.view;

/**
 * Created by debu on 5/11/17.
 */

public interface MVPview {
    void showLoading();
    void hideLoading();
    void showError(String message);
}
