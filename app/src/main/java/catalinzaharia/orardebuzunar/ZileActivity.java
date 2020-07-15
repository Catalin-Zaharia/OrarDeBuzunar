package catalinzaharia.orardebuzunar;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ZileActivity extends AppCompatActivity {
    String ziuacurentain;
    int nrZiua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zile);

        configButtonZile();
    }

    public void sendZiua() {
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedZiua.edit();
        editor.putString("ziuaCr", ziuacurentain);
        editor.putInt("nrZi", nrZiua);
        editor.apply();
    }

    private void configButtonZile() {
        Button buttonLuni = (Button) findViewById(R.id.buttonLuni);
        Button buttonMarti = (Button) findViewById(R.id.button2Sali2);
        Button buttonMiercuri = (Button) findViewById(R.id.button3Sali2);
        Button buttonJoi = (Button) findViewById(R.id.button4Sali2);
        Button buttonVineri = (Button) findViewById(R.id.button5Sali2);
        buttonLuni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ziuacurentain="Luni";
                nrZiua=1;
                sendZiua();
                finish();
            }
        });
        buttonMarti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ziuacurentain="Marti";
                nrZiua=1+28;
                sendZiua();
                finish();
            }
        });
        buttonMiercuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ziuacurentain="Miercuri";
                nrZiua=1+28*2;
                sendZiua();
                finish();
            }
        });
        buttonJoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ziuacurentain="Joi";
                nrZiua=1+28*3;
                sendZiua();
                finish();
            }
        });
        buttonVineri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ziuacurentain="Vineri";
                nrZiua=1+28*4;
                sendZiua();
                finish();
            }
        });
    }
}
