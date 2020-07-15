package catalinzaharia.orardebuzunar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Clase3Activity extends AppCompatActivity {
    int nrZiua,nrClase,litClase;
    Button buttonAClase3;
    Button buttonBClase3;
    Button buttonCClase3;
    Button buttonDClase3;
    Button buttonEClase3;
    Button buttonFClase3;
    Button buttonGClase3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase3);
        nrClase = getIntent().getExtras().getInt("numarClase");
        litClase = getIntent().getExtras().getInt("literaClase");
        recZiua();
        afisOrar();
        salvareOrar();
    }

    private void salvareOrar() {
        Button buttonSalvareClase3 = findViewById(R.id.buttonSalvareClase3);
        buttonSalvareClase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedOrar = getSharedPreferences("orarSave", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedOrar.edit();
                editor.putInt("no1",2 );
                editor.putInt("no2",nrClase );
                editor.putInt("no3",litClase );
                editor.apply();
                Snackbar.make(findViewById(android.R.id.content), "Orarul este salvat", Snackbar.LENGTH_SHORT).show();
            }
        });
    }


    private void afisOrar() {
        buttonAClase3 = (Button) findViewById(R.id.buttonAClase3);
        buttonBClase3 = (Button) findViewById(R.id.buttonBClase3);
        buttonCClase3 = (Button) findViewById(R.id.buttonCClase3);
        buttonDClase3 = (Button) findViewById(R.id.buttonDClase3);
        buttonEClase3 = (Button) findViewById(R.id.buttonEClase3);
        buttonFClase3 = (Button) findViewById(R.id.buttonFClase3);
        buttonGClase3 = (Button) findViewById(R.id.buttonGClase3);

        setaretext(buttonAClase3, 2);
        setaretext(buttonBClase3, 3);
        setaretext(buttonCClase3, 4);
        setaretext(buttonDClase3, 5);
        setaretext(buttonEClase3, 6);
        setaretext(buttonFClase3, 7);
        setaretext(buttonGClase3, 8);
    }

    private void setaretext(Button btn, int x)
    {
        if (array.tabeldate[nrZiua+nrClase+litClase][x].equals(""))
            btn.setText("-");
        else
            btn.setText(verifslash(x));
    }

    private String verifslash(int x) {
            int s1 , s2 = 0, s3 , s4 = 0;
            boolean sp = false, ss = false;
            String stp, sts;
            if (array.tabeldate[nrZiua + nrClase + litClase][x].contains("/")) {
                sp = true;
                int is = array.tabeldate[nrZiua + nrClase + litClase][x].indexOf("/");
                s1 = Integer.parseInt(array.tabeldate[nrZiua + nrClase + litClase][x].substring(0, is));
                s2 = Integer.parseInt(array.tabeldate[nrZiua + nrClase + litClase][x].substring(is + 1));
            } else
                s1 = Integer.parseInt(array.tabeldate[nrZiua + nrClase + litClase][x]);
            if (array.tabeldate[nrZiua + nrClase + litClase][x + 7].contains("/")) {
                ss = true;
                int is = array.tabeldate[nrZiua + nrClase + litClase][x + 7].indexOf("/");
                s3 = Integer.parseInt(array.tabeldate[nrZiua + nrClase + litClase][x + 7].substring(0, is));
                s4 = Integer.parseInt(array.tabeldate[nrZiua + nrClase + litClase][x + 7].substring(is + 1));
            } else
                s3 = Integer.parseInt(array.tabeldate[nrZiua + nrClase + litClase][x + 7]);
            if (sp)
                stp = array.tabelProf[s1] + "/" + array.tabelProf[s2];
            else
                stp = array.tabelProf[s1];
            if (ss)
                sts = array.tabelSali[s3] + "/" + array.tabelSali[s4];
            else
                sts = array.tabelSali[s3];
            return stp + "  " + sts;
    }

    public void recZiua(){
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);

        nrZiua=sharedZiua.getInt("nrZi", 0);

    }
}
