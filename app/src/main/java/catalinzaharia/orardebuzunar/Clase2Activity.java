package catalinzaharia.orardebuzunar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Clase2Activity extends AppCompatActivity {
    String ziuacurentain;
    Button buttonZiuaClase2;
    int numarClase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase2);

        numarClase = getIntent().getExtras().getInt("numarClase");
        buttonZiuaClase2= (Button) findViewById(R.id.buttonZiuaClase2);
        Button buttonAClase2 = (Button) findViewById(R.id.buttonAClase2);
        Button buttonBClase2 = (Button) findViewById(R.id.buttonBClase2);
        Button buttonCClase2 = (Button) findViewById(R.id.buttonCClase2);
        Button buttonDClase2 = (Button) findViewById(R.id.buttonDClase2);
        Button buttonEClase2 = (Button) findViewById(R.id.buttonEClase2);
        Button buttonFClase2 = (Button) findViewById(R.id.buttonFClase2);
        Button buttonGClase2 = (Button) findViewById(R.id.buttonGClase2);
        buttonAClase2.setText(numarClase+ " A");
        buttonBClase2.setText(numarClase+ " B");
        buttonCClase2.setText(numarClase+ " C");
        buttonDClase2.setText(numarClase+ " D");
        buttonEClase2.setText(numarClase+ " E");
        buttonFClase2.setText(numarClase+ " F");
        buttonGClase2.setText(numarClase+ " G");
        recZiua();
        configButtonClase2();
    }

    @Override
    protected void onResume() {
        super.onResume();
        recZiua();
    }

    public void recZiua(){
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);

        ziuacurentain= sharedZiua.getString("ziuaCr","");
        buttonZiuaClase2.setText(ziuacurentain);
    }

    private void configButtonClase2() {

        Button buttonZiuaClase2= (Button) findViewById(R.id.buttonZiuaClase2);
        buttonZiuaClase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase2Activity.this, ZileActivity.class);
                startActivity(intent);
            }
        });
        Button buttonAClase2 = (Button) findViewById(R.id.buttonAClase2);
        Button buttonBClase2 = (Button) findViewById(R.id.buttonBClase2);
        Button buttonCClase2 = (Button) findViewById(R.id.buttonCClase2);
        Button buttonDClase2 = (Button) findViewById(R.id.buttonDClase2);
        Button buttonEClase2 = (Button) findViewById(R.id.buttonEClase2);
        Button buttonFClase2 = (Button) findViewById(R.id.buttonFClase2);
        Button buttonGClase2 = (Button) findViewById(R.id.buttonGClase2);
        buttonAClase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase2Activity.this, Clase3Activity.class);
                intent.putExtra("numarClase",7*(numarClase-9));
                intent.putExtra("literaClase", 0);
                startActivity(intent);
            }
        });
        buttonBClase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase2Activity.this, Clase3Activity.class);
                intent.putExtra("numarClase",7*(numarClase-9));
                intent.putExtra("literaClase", 1);
                startActivity(intent);
            }
        });
        buttonCClase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase2Activity.this, Clase3Activity.class);
                intent.putExtra("numarClase",7*(numarClase-9));
                intent.putExtra("literaClase", 2);
                startActivity(intent);
            }
        });
        buttonDClase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase2Activity.this, Clase3Activity.class);
                intent.putExtra("numarClase",7*(numarClase-9));
                intent.putExtra("literaClase", 3);
                startActivity(intent);
            }
        });
        buttonEClase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase2Activity.this, Clase3Activity.class);
                intent.putExtra("numarClase",7*(numarClase-9));
                intent.putExtra("literaClase", 4);
                startActivity(intent);
            }
        });
        buttonFClase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase2Activity.this, Clase3Activity.class);
                intent.putExtra("numarClase",7*(numarClase-9));
                intent.putExtra("literaClase", 5);
                startActivity(intent);
            }
        });
        buttonGClase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clase2Activity.this, Clase3Activity.class);
                intent.putExtra("numarClase",7*(numarClase-9));
                intent.putExtra("literaClase", 6);
                startActivity(intent);
            }
        });
    }
}
