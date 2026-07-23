package la.gov.nit.nit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class membership extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);
        Button b = (Button) findViewById(R.id.btnDone);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NextActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Congratulations on being a NIT member", Toast.LENGTH_LONG).show();

            }
        });
        Button finish = (Button) findViewById(R.id.btnCancel);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NextActivity.class);
                startActivity(intent);
            }
        });

    }

    }