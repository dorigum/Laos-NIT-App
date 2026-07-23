package la.gov.nit.nit;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class cooperation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooperation);

        Button b = (Button) findViewById(R.id.lpryugovla_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent blog = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lpryu.gov.la/"));
                startActivity(blog);
            }
        });
        Button A = (Button) findViewById(R.id.KOICA_button);
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent blog = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.koica.go.kr/"));
                startActivity(blog);
            }
        });
        Button C = (Button) findViewById(R.id.SOLUTEK_button);
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent blog = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.solutek.co.kr/main.html"));
                startActivity(blog);
            }
        });
    }
    }
