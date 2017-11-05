package app.searchlistingapp.com.ui.view;


import app.searchlistingapp.com.data.SearchDataModel;

/**
 * Created by debu on 5/11/17.
 */

public interface MainMVPview extends MVPview {
    void onDataReceived(SearchDataModel response);
}
