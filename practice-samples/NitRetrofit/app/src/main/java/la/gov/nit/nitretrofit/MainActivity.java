package la.gov.nit.nitretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static String TAG_RETROFIT_GET_POST = "RETROFIT_GET_POST";

     EditText name = null;
     EditText surname = null;
     EditText ethnic = null;
     EditText dob = null;
     EditText phone = null;
     EditText email = null;
     EditText social = null;

    private Button registerButton = null;
    String returnBodyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControls();

        /* When register user account button is clicked. */
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String name1 = name.getText().toString();
                String surname1 = surname.getText().toString();
                String ethnic1 = ethnic.getText().toString();
                String dob1 = dob.getText().toString();
                String phone1 = phone.getText().toString();
                String email1 = email.getText().toString();
                String social1 = social.getText().toString();

                // Use default converter factory, so parse response body text to okhttp3.ResponseBody object.
                Call<ResponseBody> call = MemberManager.getUserManagerService(null).registerUser(name1, surname1, ethnic1, dob1, phone1, email1, social1);

                // Create a Callback object, because we do not set JSON converter, so the return object is ResponseBody be default.
                retrofit2.Callback<ResponseBody> callback = new Callback<ResponseBody>() {

                    /* When server response. */
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                        StringBuffer messageBuffer = new StringBuffer();
                        int statusCode = response.code();
                        if (statusCode == 200) {
                            try {
                                // Get return string.
                                //returnBodyText = response.body().string();
                                JSONObject jresponse = new JSONObject(response.body().string());
                                returnBodyText=jresponse.getString("message");
                            } catch (IOException ex) {
                                Log.e(TAG_RETROFIT_GET_POST, ex.getMessage());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            // If server return error.
                            messageBuffer.append("Server return error code is ");
                            messageBuffer.append(statusCode);
                            messageBuffer.append("\r\n\r\n");
                            messageBuffer.append("Error message is ");
                            messageBuffer.append(response.message());
                        }

                        // Show a Toast message.
                        Toast.makeText(getApplicationContext(), returnBodyText, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {


                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                };

                // Use callback object to process web server return data in asynchronous mode.
                call.enqueue(callback);
            }
        });

    }

    /* Initialize all UI controls. */
    private void initControls()
    {
        if(name==null)
        {
            name = (EditText)findViewById(R.id.name);
        }

        if(surname==null)
        {
            surname = (EditText)findViewById(R.id.surname);
        }

        if(ethnic==null)
        {
            ethnic = (EditText)findViewById(R.id.ethnic);
        }
        if(dob==null)
        {
            dob = (EditText)findViewById(R.id.dob);
        }
        if(phone==null)
        {
            phone = (EditText)findViewById(R.id.phone);
        }
        if(email==null)
        {
            email = (EditText)findViewById(R.id.email);
        }
        if(social==null)
        {
            social = (EditText)findViewById(R.id.social);
        }

        if(registerButton == null)
        {
            registerButton = (Button)findViewById(R.id.retrofit_register_button);
        }


    }




}
