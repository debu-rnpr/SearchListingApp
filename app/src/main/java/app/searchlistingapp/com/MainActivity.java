package app.searchlistingapp.com;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import javax.inject.Inject;

import app.searchlistingapp.com.data.SearchDataModel;
import app.searchlistingapp.com.injection.ActivityContext;
import app.searchlistingapp.com.injection.component.DaggerActivityComponent;
import app.searchlistingapp.com.injection.module.ActivityModule;
import app.searchlistingapp.com.presenter.PresenterMain;
import app.searchlistingapp.com.ui.adapter.AdapterListing;
import app.searchlistingapp.com.ui.view.MainMVPview;

public class MainActivity extends AppCompatActivity implements MainMVPview{

    @Inject
    @ActivityContext
    Context context;
    @Inject
    PresenterMain presenterMain;
    @Inject
    AdapterListing adapterListing;
    private SearchDataModel dataModel;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerActivityComponent.builder().applicationComponent(MainApplication.getInstance()
                .getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build().inject(this);
        setContentView(R.layout.activity_main);
        presenterMain.attachView(this);
        setupListing();
        if(savedInstanceState != null){
            this.dataModel = (SearchDataModel) savedInstanceState.getSerializable("data");
            onDataReceived(dataModel);
        }else{
            presenterMain.initilize("india");
        }
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterMain.detachView();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataReceived(SearchDataModel response) {
        this.dataModel = response;
        adapterListing.setListResponses(response.getHits());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("data",dataModel);
        super.onSaveInstanceState(outState);
    }

    void setupListing(){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please wait");
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.listing);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapterListing);
    }
}
