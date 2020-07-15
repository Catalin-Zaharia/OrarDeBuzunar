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

public class Clase1Activity extends AppCompatActivity {
    String ziuacurentain;
    Button buttonZiuaClase1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase1);

       buttonZiuaClase1= (Button) findViewById(R.id.buttonZiuaClase1);
        recZiua();
        configButtonClase1();
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
        buttonZiuaClase1.setText(ziuacurentain);
    }

    private void configButtonClase1() {
        Button button9Clase1 = (Button) findViewById(R.id.button9Clase1);
        Button button10Clase1 = (Button) findViewById(R.id.button10Clase1);
        Button button11Clase1 = (Button) findViewById(R.id.button11Clase1);
        Button button12Clase1 = (Button) findViewById(R.id.button12Clase1);
        buttonZiuaClase1= (Button) findViewById(R.id.buttonZiuaClase1);
        button9Clase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase1Activity.this, Clase2Activity.class);
                intent.putExtra("numarClase",9);
                sendZiua();
                startActivity(intent);
            }
        });
        button10Clase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase1Activity.this, Clase2Activity.class);
                intent.putExtra("numarClase",10);
                sendZiua();
                startActivity(intent);
            }
        });
        button11Clase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase1Activity.this, Clase2Activity.class);
                intent.putExtra("numarClase",11);
                sendZiua();
                startActivity(intent);
            }
        });
        button12Clase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase1Activity.this, Clase2Activity.class);
                intent.putExtra("numarClase",12);
                sendZiua();
                startActivity(intent);
            }
        });
        buttonZiuaClase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase1Activity.this, ZileActivity.class);
                startActivity(intent);
            }
        });
    }

}
