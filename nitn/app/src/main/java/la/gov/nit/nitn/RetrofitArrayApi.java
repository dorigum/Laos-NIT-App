package la.gov.nit.nitn;
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
    @GET("/wp-json/wp/v2/posts?categories=12")
    Call<List<WPPost>> getPostYoungIdeaLa();

    @GET("/wp-json/wp/v2/posts?categories=21")
    Call<List<WPPost>> getPostYoungIdeaEn();

    //Todo...

}

