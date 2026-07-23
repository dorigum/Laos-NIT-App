package la.gov.nit.nitn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import la.gov.nit.nitn.membership;
import la.gov.nit.nitn.R;
import okhttp3.ResponseBody;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;






public class membership extends AppCompatActivity {
    /*private EditText editTexNAME;
    private EditText editTexSURNAME;
    private EditText editTexETHNIC;
    private EditText editTexDATEOFBIRTH;
    private EditText editTexPHONENUMBER;
    private EditText editTexEMAIL;
    private EditText editTexsns;*/

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

    /*Toolbar myToolbar;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        /*editTexNAME = (EditText) findViewById(R.id.etNAME);
        editTexSURNAME = (EditText) findViewById(R.id.etSURNAME);
        editTexETHNIC = (EditText) findViewById(R.id.etETHNIC);
        editTexDATEOFBIRTH = (EditText) findViewById(R.id.etDATEOFBIRTH);
        editTexPHONENUMBER = (EditText) findViewById(R.id.etPHONENUMBER);
        editTexEMAIL = (EditText) findViewById(R.id.etEMAIL);
        editTexsns = (EditText) findViewById(R.id.etsns);*/
        //

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
            name = (EditText)findViewById(R.id.etname);
        }

        if(surname==null)
        {
            surname = (EditText)findViewById(R.id.etsurname);
        }

        if(ethnic==null)
        {
            ethnic = (EditText)findViewById(R.id.etethnic);
        }
        if(dob==null)
        {
            dob = (EditText)findViewById(R.id.etdateofbirth);
        }
        if(phone==null)
        {
            phone = (EditText)findViewById(R.id.etphonenumber);
        }
        if(email==null)
        {
            email = (EditText)findViewById(R.id.etemail);
        }
        if(social==null)
        {
            social = (EditText)findViewById(R.id.etsns);
        }

        if(registerButton == null)
        {
            registerButton = (Button)findViewById(R.id.btnDone);
        }











    Button b = (Button) findViewById(R.id.btnDone);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                /*Toast.makeText(getApplicationContext(), "Congratulations on being a NIT member", Toast.LENGTH_LONG).show();*/


            }
        });
        Button finish = (Button) findViewById(R.id.btnCancel);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        //툴바
        /*myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Noumsao Inno Tech");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "환경설정 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);

        }

    }
}