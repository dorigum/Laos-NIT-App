package la.gov.nit.nitn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class it_tips extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Model> list;
    private RecyclerViewAdapter adapter;

    private String baseURL = "http://nit.gov.la";

    public static List<WPPost> mListPost;


    Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_tips);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Noumsao Inno Tech");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        mLayoutManager = new LinearLayoutManager(it_tips.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        list = new ArrayList<Model>();
        /// call retrofill
        getRetrofit();

        adapter = new RecyclerViewAdapter(list, it_tips.this);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayApi service = retrofit.create(RetrofitArrayApi.class);
        Call<List<WPPost>> call = null;

        /*String choix=getIntent().getStringExtra("choix");
        String lan=getIntent().getStringExtra("lan");


        switch (choix) {
            case "YOUNGIDEA": {
                if(lan=="EN") {
                    call = service.getPostYoungIdeaEn();
                    break;
                }else{
                    call = service.getPostYoungIdeaLa();
                    break;
                }
            }
            case "ITTIPS": {
                if(lan=="EN") {
                    call = service.getPostYoungIdeaEn();
                    break;
                }else{
                    call = service.getPostYoungIdeaLa();
                    break;
                }
            }
            //Todo;

            default:
                call=service.getPostInfo();
                break;
        }*/

        call.enqueue(new Callback<List<WPPost>>() {


            @Override
            public void onResponse(Call<List<WPPost>> call, Response<List<WPPost>> response) {
                Log.e("mainactivyt", " response " + response.body());
                mListPost = response.body();
                progressBar.setVisibility(View.GONE);

                for (int i = 0; i < response.body().size(); i++) {
                    Log.e("main ", " title " + response.body().get(i).getTitle().getRendered() + " " +
                            response.body().get(i).getId());

                    String tempdetails = response.body().get(i).getExcerpt().getRendered().toString();
                    tempdetails = tempdetails.replace("<p>", "");
                    tempdetails = tempdetails.replace("</p>", "");
                    tempdetails = tempdetails.replace("[&hellip;]", "");


                    list.add(new Model(Model.IMAGE_TYPE, response.body().get(i).getTitle().getRendered(), tempdetails, response.body().get(i).getFeatured_image_src()));

                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<WPPost>> call, Throwable t) {

            }
        });

    }
}
// layout xml 과 자바파일을 연결
// end onCreate()
// end MyTwo