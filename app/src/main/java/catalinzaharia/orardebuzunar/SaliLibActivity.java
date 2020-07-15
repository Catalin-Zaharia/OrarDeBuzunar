package catalinzaharia.orardebuzunar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SaliLibActivity extends AppCompatActivity {
    String ziuacurentain;
    Button buttonZiuaSaliL1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sali_lib);
        buttonZiuaSaliL1= findViewById(R.id.buttonZiuaSaliL1);
        recZiua();
        configButtonSaliL();
    }

    @Override
    protected void onResume() {
        super.onResume();
        recZiua();
    }

    private void configButtonSaliL() {
        buttonZiuaSaliL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaliLibActivity.this, ZileActivity.class);
                startActivity(intent);
            }
        });
        Button button1SaliL1 = (Button) findViewById(R.id.button1SaliL1);
        Button button2SaliL1 = (Button) findViewById(R.id.button2SaliL1);
        Button button3SaliL1 = (Button) findViewById(R.id.button3SaliL1);
        Button button4SaliL1 = (Button) findViewById(R.id.button4SaliL1);
        Button button5SaliL1 = (Button) findViewById(R.id.button5SaliL1);
        Button button6SaliL1 = (Button) findViewById(R.id.button6SaliL1);
        Button button7SaliL1 = (Button) findViewById(R.id.button7SaliL1);
        button1SaliL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaliLibActivity.this, SaliL2Activity.class);
                intent.putExtra("ora",1);
                startActivity(intent);
            }
        });
        button2SaliL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaliLibActivity.this, SaliL2Activity.class);
                intent.putExtra("ora",2);
                startActivity(intent);
            }
        });
        button3SaliL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaliLibActivity.this, SaliL2Activity.class);
                intent.putExtra("ora",3);
                startActivity(intent);
            }
        });
        button4SaliL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaliLibActivity.this, SaliL2Activity.class);
                intent.putExtra("ora",4);
                startActivity(intent);
            }
        });
        button5SaliL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaliLibActivity.this, SaliL2Activity.class);
                intent.putExtra("ora",5);
                startActivity(intent);
            }
        });
        button6SaliL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaliLibActivity.this, SaliL2Activity.class);
                intent.putExtra("ora",6);
                startActivity(intent);
            }
        });
        button7SaliL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaliLibActivity.this, SaliL2Activity.class);
                intent.putExtra("ora",7);
                startActivity(intent);
            }
        });

    }

    public void recZiua(){
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);
        ziuacurentain= sharedZiua.getString("ziuaCr","");
        buttonZiuaSaliL1.setText(ziuacurentain);
    }

}
