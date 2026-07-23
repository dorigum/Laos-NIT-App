package la.gov.nit.nitretrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by Jerry on 3/31/2018.
 */

public interface MemberManagerInterface {


    @FormUrlEncoded
    @POST("/memberRegister/register.php")
    public Call<ResponseBody> registerUser(@Field("name") String name,
                                           @Field("surname") String surname,
                                           @Field("ethnic") String ethnic,
                                           @Field("dob") String dob,
                                           @Field("phone") String phone,
                                           @Field("email") String email,
                                           @Field("social") String social);
}
