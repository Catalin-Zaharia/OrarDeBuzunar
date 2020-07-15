package catalinzaharia.orardebuzunar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sali1Activity extends AppCompatActivity {
    String ziuacurentain;
    Button buttonZiuaSali1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sali1);
        buttonZiuaSali1= (Button) findViewById(R.id.buttonZiuaSali1);
        recZiua();
        configButtonSali1();
    }

    @Override
    protected void onResume() {
        super.onResume();
        recZiua();
    }

    public void sendZiua() {
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedZiua.edit();
        editor.putString("ziuaCr", ziuacurentain);
        editor.apply();
    }

    public void recZiua(){
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);

        ziuacurentain= sharedZiua.getString("ziuaCr","");
        buttonZiuaSali1.setText(ziuacurentain);
    }

    private void configButtonSali1() {
        Button buttonDSali1 = (Button) findViewById(R.id.button1Sali1);
        Button buttonPSali1 = (Button) findViewById(R.id.button2Sali1);
        Button buttonE1Sali1 = (Button) findViewById(R.id.button3Sali1);
        Button buttonE2Sali1 = (Button) findViewById(R.id.button4Sali1);
        Button buttonE3Sali1 = (Button) findViewById(R.id.button5Sali1);
        Button buttonLSali1  = (Button) findViewById(R.id.buttonLSali1);
        buttonZiuaSali1= (Button) findViewById(R.id.buttonZiuaSali1);
        buttonDSali1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali1Activity.this, Sali2Activity.class);
                intent.putExtra("etajSali",0);
                sendZiua();
                startActivity(intent);
            }
        });
        buttonPSali1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali1Activity.this, Sali2Activity.class);
                intent.putExtra("etajSali",1);
                sendZiua();
                startActivity(intent);
            }
        });
        buttonE1Sali1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali1Activity.this, Sali2Activity.class);
                intent.putExtra("etajSali",2);
                sendZiua();
                startActivity(intent);
            }
        });
        buttonE2Sali1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali1Activity.this, Sali2Activity.class);
                intent.putExtra("etajSali",3);
                sendZiua();
                startActivity(intent);
            }
        });
        buttonE3Sali1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali1Activity.this, Sali2Activity.class);
                intent.putExtra("etajSali",4);
                sendZiua();
                startActivity(intent);
            }
        });
        buttonLSali1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali1Activity.this, SaliLibActivity.class);
                sendZiua();
                startActivity(intent);

            }
        });
        buttonZiuaSali1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali1Activity.this, ZileActivity.class);
                startActivity(intent);
            }
        });
    }
}
