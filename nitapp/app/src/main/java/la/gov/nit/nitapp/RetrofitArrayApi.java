package la.gov.nit.nitapp;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Jaink on 14-09-2017.
 */

public interface RetrofitArrayApi {


    @GET("/wp-json/wp/v2/posts")
    Call<List<WPPost>> getPostInfo();
    /// to make call to dynamic URL
     // @GET
    //  Call<List<Object>> getPostInfo(@Url String url);


}

