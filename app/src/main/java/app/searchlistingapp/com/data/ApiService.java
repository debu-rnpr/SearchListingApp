package app.searchlistingapp.com.data;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by debu on 5/11/17.
 */

public interface ApiService {
    String BASE_URL = "https://hn.algolia.com/api/v1/";

    @GET("search")
    Observable<SearchDataModel> getData(@Query("query")String query);

    class Factory{
        public static ApiService create(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit.create(ApiService.class);
        }
    }
}
