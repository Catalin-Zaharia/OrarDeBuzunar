package catalinzaharia.orardebuzunar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import catalinzaharia.orardebuzunar.parser.JSONParser;
import catalinzaharia.orardebuzunar.utils.InternetConnection;


public class HomeActivity extends AppCompatActivity {
    String ziuacurentain;
    Button buttonZiuaHome;
    
    TextView textViewTitle;
    boolean net=true;
    int nrZiua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        buttonZiuaHome = findViewById(R.id.buttonZiuaHome);
        textViewTitle = findViewById(R.id.textViewTitle);

        ziuaInit();
        recZiua();
        configButtonClaseHome();
        new GetOrarTask().execute();
    }

    public class  GetOrarTask extends AsyncTask<Void,Void,Void> {
        JSONObject jorar;
        JSONArray jaorar,japrof,jasali;
        String textJson=null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            toast("Orarul se incarca");
        }

        @Override
        protected Void doInBackground(Void... params) {
            int i;
            try {

                if (citire("textJson.txt")!=null) {
                    net=false;
                    textJson = citire("textJson.txt");
                    jorar = new JSONObject(textJson);

                    jaorar = jorar.getJSONArray("Orar");
                    japrof = jorar.getJSONArray("Profs");
                    jasali = jorar.getJSONArray("Sali");

                    for (i = 0; i < japrof.length(); i++) {
                        JSONObject joprof = (JSONObject) japrof.get(i);
                        array.tabelProf[i + 1] = (String) joprof.get("prof");
                    }
                    array.pC = i;
                    for (i = 0; i < jasali.length(); i++) {
                        JSONObject josali = (JSONObject) jasali.get(i);
                        array.tabelSali[i + 1] = (String) josali.get("sala");
                    }
                    array.sC = i;
                    for (i = 0; i < jaorar.length(); i++) {
                        JSONObject JO = (JSONObject) jaorar.get(i);
                        array.tabeldate[i + 1][1] = (String) JO.get("clasa");
                        array.tabeldate[i + 1][2] = (String) JO.get("prof1");
                        array.tabeldate[i + 1][3] = (String) JO.get("prof2");
                        array.tabeldate[i + 1][4] = (String) JO.get("prof3");
                        array.tabeldate[i + 1][5] = (String) JO.get("prof4");
                        array.tabeldate[i + 1][6] = (String) JO.get("prof5");
                        array.tabeldate[i + 1][7] = (String) JO.get("prof6");
                        array.tabeldate[i + 1][8] = (String) JO.get("prof7");
                        array.tabeldate[i + 1][9] = (String) JO.get("sala1");
                        array.tabeldate[i + 1][10] = (String) JO.get("sala2");
                        array.tabeldate[i + 1][11] = (String) JO.get("sala3");
                        array.tabeldate[i + 1][12] = (String) JO.get("sala4");
                        array.tabeldate[i + 1][13] = (String) JO.get("sala5");
                        array.tabeldate[i + 1][14] = (String) JO.get("sala6");
                        array.tabeldate[i + 1][15] = (String) JO.get("sala7");

                    }
                    toast("Orarul este incarcat offline");
                }
                if (InternetConnection.checkConnection(getApplicationContext())) {
                    net=false;
                    jorar = JSONParser.getDataFromWeb("https://script.google.com/macros/s/AKfycbwPbBLFTBitcZzVgra4AnSvNypv67vMF_5F1m-k0blj6Bz9-OXE/exec");

                    assert jorar != null;
                    jaorar = jorar.getJSONArray("Orar");
                    japrof = jorar.getJSONArray("Profs");
                    jasali = jorar.getJSONArray("Sali");

                    for(i=0;i<japrof.length();i++) {
                        JSONObject joprof = (JSONObject) japrof.get(i);
                        array.tabelProf[i+1] = (String) joprof.get("prof");
                    }
                    array.pC=i;
                    for(i=0;i<jasali.length();i++) {
                        JSONObject josali = (JSONObject) jasali.get(i);
                        array.tabelSali[i+1] = (String) josali.get("sala");
                    }
                    array.sC=i;
                    for(i =0 ;i <jaorar.length(); i++){
                        JSONObject JO = (JSONObject) jaorar.get(i);
                        array.tabeldate[i+1][1] = (String) JO.get("clasa");
                        array.tabeldate[i+1][2] = (String) JO.get("prof1");
                        array.tabeldate[i+1][3] = (String) JO.get("prof2");
                        array.tabeldate[i+1][4] = (String) JO.get("prof3");
                        array.tabeldate[i+1][5] = (String) JO.get("prof4");
                        array.tabeldate[i+1][6] = (String) JO.get("prof5");
                        array.tabeldate[i+1][7] = (String) JO.get("prof6");
                        array.tabeldate[i+1][8] = (String) JO.get("prof7");
                        array.tabeldate[i+1][9] = (String) JO.get("sala1");
                        array.tabeldate[i+1][10] = (String) JO.get("sala2");
                        array.tabeldate[i+1][11] = (String) JO.get("sala3");
                        array.tabeldate[i+1][12] = (String) JO.get("sala4");
                        array.tabeldate[i+1][13] = (String) JO.get("sala5");
                        array.tabeldate[i+1][14] = (String) JO.get("sala6");
                        array.tabeldate[i+1][15] = (String) JO.get("sala7");

                    }
                    toast("Orarul este actualizat");

                }
                else if (net)
                    toast("Nu exista o conexiune la Internet pentru a incarca orarul");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (!net)
            {
           scriere("textJson.txt",jorar.toString());
            }
        }
    }

    private void toast(final String txt)
    {
        runOnUiThread(new Runnable() {
            public void run()
            {

                Toast tst =Toast.makeText(HomeActivity.this, txt, Toast.LENGTH_SHORT);
                tst.setGravity(Gravity.BOTTOM,0,0);
                tst.show();
            }
        });
    }


    private void scriere(String nume, String text)
    {
        FileOutputStream outputStream = null;
        try{
            outputStream= openFileOutput(nume, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String citire(String nume) {
        FileInputStream fileInputStream = null;
        String text = null;
        try {
            fileInputStream=openFileInput(nume);
            InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder= new StringBuilder();
            String prel;
            while ((prel= bufferedReader.readLine()) != null)
            {
                stringBuilder.append(prel);
            }
            text = stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (fileInputStream != null)
            {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return text;
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
        editor.putInt("nrZi", nrZiua);
        editor.apply();
    }

    public void recZiua(){
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);
        ziuacurentain= sharedZiua.getString("ziuaCr","");
        nrZiua= sharedZiua.getInt("nrZi",0);
        buttonZiuaHome.setText(ziuacurentain);
    }

    public void ziuaInit() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.US);
        Date d = new Date();
        ziuacurentain = sdf.format(d);

        switch (ziuacurentain) {
            case "Monday":
                ziuacurentain = "Luni";
                nrZiua=1;
                break;
            case "Tuesday":
                ziuacurentain = "Marti";
                nrZiua=1+28;
                break;
            case "Wednesday":
                ziuacurentain = "Miercuri";
                nrZiua=1+28*2;
                break;
            case "Thursday":
                ziuacurentain = "Joi";
                nrZiua=1+28*3;
                break;
            case "Friday":
                ziuacurentain = "Vineri";
                nrZiua=1+28*4;
                break;
            case "Saturday":
                ziuacurentain = "Luni";
                nrZiua=1;
                break;
            case "Sunday":
                ziuacurentain = "Luni";
                nrZiua=1;
                break;
        }
            sendZiua();
        }

    private void configButtonClaseHome() {
        Button buttonClaseHome = (Button) findViewById(R.id.buttonClaseHome);
        Button buttonZiuaHome = (Button) findViewById(R.id.buttonZiuaHome);
        Button buttonProfHome = (Button) findViewById(R.id.buttonProfHome);
        Button buttonSaliHome = (Button) findViewById(R.id.buttonSaliHome);
        final Button buttonOrarHome= findViewById(R.id.buttonOrarHome);
        buttonClaseHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Clase1Activity.class);
                sendZiua();
                startActivity(intent);
            }
        });
        buttonProfHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Prof1Activity.class);
                sendZiua();
                startActivity(intent);
            }
        });
        buttonSaliHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Sali1Activity.class);
                sendZiua();
                startActivity(intent);
            }
        });
        buttonZiuaHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ZileActivity.class);
                startActivity(intent);
            }
        });
        buttonOrarHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(HomeActivity.this, OrarActivity.class);
                startActivity(intent);
            }
        });
    }
}

