package catalinzaharia.orardebuzunar;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sali3Activity extends AppCompatActivity {
    int nrZiua,nrSala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sali3);
        recZiua();
        nrSala=getIntent().getExtras().getInt("etaj")*10+getIntent().getExtras().getInt("sala");

        afisorar();
        salvareOrar();
    }

    private void salvareOrar() {
        Button buttonSalvareSali3 = findViewById(R.id.buttonSalvareSali3);
        buttonSalvareSali3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedOrar = getSharedPreferences("orarSave", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedOrar.edit();
                editor.putInt("no1",2 );
                editor.putInt("no2",nrSala );
                editor.apply();
                Snackbar.make(findViewById(android.R.id.content), "Orarul este salvat", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void afisorar() {
        Button buttonASali3 = (Button) findViewById(R.id.buttonASali3);
        Button buttonBSali3 = (Button) findViewById(R.id.buttonBSali3);
        Button buttonCSali3 = (Button) findViewById(R.id.buttonCSali3);
        Button buttonDSali3 = (Button) findViewById(R.id.buttonDSali3);
        Button buttonESali3 = (Button) findViewById(R.id.buttonESali3);
        Button buttonFSali3 = (Button) findViewById(R.id.buttonFSali3);
        Button buttonGSali3 = (Button) findViewById(R.id.buttonGSali3);

        setaretext(buttonASali3,2);
        setaretext(buttonBSali3,3);
        setaretext(buttonCSali3,4);
        setaretext(buttonDSali3,5);
        setaretext(buttonESali3,6);
        setaretext(buttonFSali3,7);
        setaretext(buttonGSali3,8);
    }

    private void setaretext(Button btn, int x) {

        int i;
        boolean wr=true;
        for (i = nrZiua; i <= nrZiua + 27; i++) {
            boolean vf=true;
            if (array.tabeldate[i][x+7].equals("")) {
                vf=false;
            }
            if (vf) {

                if (array.tabeldate[i][x+7].contains("/"))
                {
                    int s1,s2, is2= array.tabeldate[i][x+7].indexOf("/"),is = array.tabeldate[i][x].indexOf("/");
                    s1 = Integer.parseInt(array.tabeldate[i][x+7].substring(0, is2));
                    s2 = Integer.parseInt(array.tabeldate[i][x+7].substring(is2 + 1));

                    if (s1==nrSala)
                    {
                        wr=false;
                        btn.setText(array.tabeldate[i][1] + "  " + array.tabelProf[Integer.parseInt(array.tabeldate[i][x].substring(0, is))]);
                        i = nrZiua + 28;
                    }
                    else if (s2==nrSala)
                    {
                        wr=false;
                        btn.setText(array.tabeldate[i][1] + "  " + array.tabelProf[Integer.parseInt(array.tabeldate[i][x].substring(is+1))]);
                        i = nrZiua + 28;
                    }
                }
                else
                if (Integer.parseInt(array.tabeldate[i][x+7]) == nrSala) {
                    wr=false;
                    if (array.tabeldate[i][x].contains("/")) {
                        int is = array.tabeldate[i][x].indexOf("/");
                        btn.setText(array.tabeldate[i][1] + "  " + array.tabelProf[Integer.parseInt(array.tabeldate[i][x].substring(0, is))]+"/"+array.tabelProf[Integer.parseInt(array.tabeldate[i][x].substring(is+1))]);
                    }
                    else
                        btn.setText(array.tabeldate[i][1] + "  " + array.tabelProf[Integer.parseInt(array.tabeldate[i][x])]);
                    i = nrZiua + 28;
                }
            }
        }
        if (wr)
            btn.setText("-");
    }

    public void recZiua(){
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);
        nrZiua=sharedZiua.getInt("nrZi", 0);
    }
}
