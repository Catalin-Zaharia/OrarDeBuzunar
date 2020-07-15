package catalinzaharia.orardebuzunar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sali2Activity extends AppCompatActivity {
    String ziuacurentain;
    Button buttonZiuaSali2;
    int etajSali2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sali2);

        buttonZiuaSali2= (Button) findViewById(R.id.buttonZiuaSali2);
        etajSali2=getIntent().getExtras().getInt("etajSali");
        recZiua();
        Button button1Sali2 = (Button) findViewById(R.id.button1Sali2);
        Button button2Sali2 = (Button) findViewById(R.id.button2Sali2);
        Button button3Sali2 = (Button) findViewById(R.id.button3Sali2);
        Button button4Sali2 = (Button) findViewById(R.id.button4Sali2);
        Button button5Sali2 = (Button) findViewById(R.id.button5Sali2);
        Button button6Sali2 = (Button) findViewById(R.id.buttonLSali2);
        Button button7Sali2 = (Button) findViewById(R.id.button7Sali2);
        Button button8Sali2 = (Button) findViewById(R.id.button8Sali2);
        switch(etajSali2){
            case 0:
                button1Sali2.setText("D Arhiva");
                button2Sali2.setText("D Fizica");
                button3Sali2.setText("D Chimie");
                button4Sali2.setText("D Biologie");
                button5Sali2.setText("D Geografie");
                button6Sali2.setVisibility(View.GONE);
                button7Sali2.setVisibility(View.GONE);
                button8Sali2.setVisibility(View.GONE);
                break;
            case 1:
                button1Sali2.setText("Teren Sport");
                button2Sali2.setText("P 1");
                button3Sali2.setText("P 2");
                button4Sali2.setText("P 3");
                button5Sali2.setVisibility(View.GONE);
                button6Sali2.setVisibility(View.GONE);
                button7Sali2.setVisibility(View.GONE);
                button8Sali2.setVisibility(View.GONE);
                break;
            case 2:
                button1Sali2.setText("I 1");
                button2Sali2.setText("I 3");
                button3Sali2.setText("I 4");
                button4Sali2.setText("I 5");
                button5Sali2.setText("I 6");
                button6Sali2.setText("I 7");
                button7Sali2.setText("I 8");
                button8Sali2.setVisibility(View.GONE);
                break;
            case 3:
                button1Sali2.setText("II 1");
                button2Sali2.setText("II 3");
                button3Sali2.setText("II 4");
                button4Sali2.setText("II 5");
                button5Sali2.setText("II 6");
                button6Sali2.setText("II 7");
                button7Sali2.setText("II 8");
                button8Sali2.setVisibility(View.GONE);
                break;
            case 4:
                button1Sali2.setText("III 1");
                button2Sali2.setText("III 2");
                button3Sali2.setText("III 3");
                button4Sali2.setText("III 4");
                button5Sali2.setText("III 5");
                button6Sali2.setText("III 6");
                button7Sali2.setText("III 7");
                button8Sali2.setText("III 8");
                break;
        }
        configButtonSali2();
    }



    @Override
    protected void onResume() {
        super.onResume();
        recZiua();
    }

    public void recZiua(){
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);

        ziuacurentain= sharedZiua.getString("ziuaCr","");
        buttonZiuaSali2.setText(ziuacurentain);
    }

    private void configButtonSali2() {
        Button button1Sali2 = (Button) findViewById(R.id.button1Sali2);
        Button button2Sali2 = (Button) findViewById(R.id.button2Sali2);
        Button button3Sali2 = (Button) findViewById(R.id.button3Sali2);
        Button button4Sali2 = (Button) findViewById(R.id.button4Sali2);
        Button button5Sali2 = (Button) findViewById(R.id.button5Sali2);
        Button button6Sali2 = (Button) findViewById(R.id.buttonLSali2);
        Button button7Sali2 = (Button) findViewById(R.id.button7Sali2);
        Button button8Sali2 = (Button) findViewById(R.id.button8Sali2);
        buttonZiuaSali2= (Button) findViewById(R.id.buttonZiuaSali2);
        buttonZiuaSali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali2Activity.this, ZileActivity.class);
                startActivity(intent);
            }
        });
        button1Sali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali2Activity.this, Sali3Activity.class);
                intent.putExtra("etaj",etajSali2);
                intent.putExtra("sala",1);
                startActivity(intent);
            }
        });
        button2Sali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali2Activity.this, Sali3Activity.class);
                intent.putExtra("etaj",etajSali2);
                intent.putExtra("sala",2);
                startActivity(intent);
            }
        });
        button3Sali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali2Activity.this, Sali3Activity.class);
                intent.putExtra("etaj",etajSali2);
                intent.putExtra("sala",3);
                startActivity(intent);
            }
        });
        button4Sali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali2Activity.this, Sali3Activity.class);
                intent.putExtra("etaj",etajSali2);
                intent.putExtra("sala",4);
                startActivity(intent);
            }
        });
        button5Sali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali2Activity.this, Sali3Activity.class);
                intent.putExtra("etaj",etajSali2);
                intent.putExtra("sala",5);
                startActivity(intent);
            }
        });
        button6Sali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali2Activity.this, Sali3Activity.class);
                intent.putExtra("etaj",etajSali2);
                intent.putExtra("sala",6);
                startActivity(intent);
            }
        });
        button7Sali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali2Activity.this, Sali3Activity.class);
                intent.putExtra("etaj",etajSali2);
                intent.putExtra("sala",7);
                startActivity(intent);
            }
        });
        button8Sali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sali2Activity.this, Sali3Activity.class);
                intent.putExtra("etaj",etajSali2);
                intent.putExtra("sala",8);
                startActivity(intent);
            }
        });
    }
}
