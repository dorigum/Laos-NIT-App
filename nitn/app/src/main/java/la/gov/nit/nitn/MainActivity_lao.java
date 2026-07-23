package la.gov.nit.nitn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MainActivity_lao extends AppCompatActivity {

    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lao);
        // 화면 전환 - 인텐트 날리기 (startActivity)
        //     1. 다음 넘어갈 화면을 준비한다 (layout xml, java)
        //    2. AndroidManifest.xml 에 Activity 를 등록한다
        //    3. Intent 객체를 만들어서 startActivity 한다

        Button b=(Button) findViewById(R.id.JOIN_button);
        b.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), membership.class);
                startActivity(intent);

            }
        });

        //이미지 버튼(it tips)
        ImageButton it = (ImageButton) findViewById(R.id.it_tips);
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        it_tips.class); // 다음 넘어갈 클래스 지정
                /*intent.putExtra("choix", "ITTIPS");
                intent.putExtra("lan", "La");//todo: get La or En from main page
                */
                startActivity(intent); // 다음 화면으로 넘어간다

            }
        });

        //이미지 버튼(about us)
        ImageButton au = (ImageButton) findViewById(R.id.about_us);
        au.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        about_us.class);
                startActivity(intent);
            }
        });

        //이미지 버튼(korea dbd)
        ImageButton ko = (ImageButton) findViewById(R.id.korea_dbd);
        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        korea_dbd.class);
                intent.putExtra("choix", "KDBD");
                startActivity(intent);
            }
        });



        //이미지 버튼(young idea)
        ImageButton yi = (ImageButton) findViewById(R.id.young_idea);
        yi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        young_idea.class);
                startActivity(intent);
            }
        });

        //이미지 버튼(love&life)
        ImageButton ll = (ImageButton) findViewById(R.id.love_life);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        love_life.class);
                startActivity(intent);
            }
        });

        //이미지 버튼(contact)
        ImageButton ct = (ImageButton) findViewById(R.id.contact);
        ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        contact.class);
                startActivity(intent);
            }
        });




        //이미지 버튼(offers)
        ImageButton of = (ImageButton) findViewById(R.id.offers);
        of.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        offers.class);
                startActivity(intent);
            }
        });

        //이미지 버튼(cooperation)
        ImageButton co = (ImageButton) findViewById(R.id.cooperation);
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        cooperation.class);
                startActivity(intent);
            }
        });

        //이미지 버튼(downloads)
        ImageButton dl = (ImageButton) findViewById(R.id.downloads);
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        downloads.class);
                startActivity(intent);
            }
        });

        //툴바 생성
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Noumsao Inno Tech"); //툴바 이름

        //뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                /*Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();*/
                return super.onOptionsItemSelected(item);

        }


    } // end onCreate()
} // end MainActivity