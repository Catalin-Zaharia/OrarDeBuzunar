package catalinzaharia.orardebuzunar;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Prof2Activity extends AppCompatActivity {

    int nrZiua, nrProf = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof2);
        recZiua();
        for (int i = 1; i <= array.pC; i++) {
            if (array.numeProf.equals(array.tabelProf[i]))
                nrProf = i;
        }
        afisOrar();
        salvareOrar();
    }

    private void salvareOrar() {
        Button buttonSalvareProf2 = findViewById(R.id.buttonSalvareProf2);
        buttonSalvareProf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedOrar = getSharedPreferences("orarSave", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedOrar.edit();
                editor.putInt("no1",1 );
                editor.putInt("no2",nrProf);
                editor.apply();
                Snackbar.make(findViewById(android.R.id.content), "Orarul este salvat", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void afisOrar() {
        Button button1Prof2 = (Button) findViewById(R.id.button1Prof2);
        Button button2Prof2 = (Button) findViewById(R.id.button2Prof2);
        Button button3Prof2 = (Button) findViewById(R.id.button3Prof2);
        Button button4Prof2 = (Button) findViewById(R.id.button4Prof2);
        Button button5Prof2 = (Button) findViewById(R.id.button5Prof2);
        Button button6Prof2 = (Button) findViewById(R.id.button6Prof2);
        Button button7Prof2 = (Button) findViewById(R.id.button7Prof2);

        setaretext(button1Prof2,2);
        setaretext(button2Prof2,3);
        setaretext(button3Prof2,4);
        setaretext(button4Prof2,5);
        setaretext(button5Prof2,6);
        setaretext(button6Prof2,7);
        setaretext(button7Prof2,8);

    }

    private void setaretext(Button btn, int x) {

        int i;
        boolean wr=true;
        for (i = nrZiua; i <= nrZiua + 27; i++) {
            boolean vf=true;
            if (array.tabeldate[i][x].equals("")) {
                vf=false;
            }
            if (vf) {

                if (array.tabeldate[i][x].contains("/"))
                {
                    int s1,s2, is = array.tabeldate[i][x].indexOf("/");
                    s1 = Integer.parseInt(array.tabeldate[i][x].substring(0, is));
                    s2 = Integer.parseInt(array.tabeldate[i][x].substring(is + 1));

                    if (s1==nrProf)
                    {
                        wr=false;
                        if (array.tabeldate[i][7+x].contains("/")) {
                            int is2 = array.tabeldate[i][x + 7].indexOf("/");
                            btn.setText(array.tabeldate[i][1] + "  " + array.tabelSali[Integer.parseInt(array.tabeldate[i][x + 7].substring(0, is2))]);
                        }
                        else
                            btn.setText(array.tabeldate[i][1] + "  " + array.tabelSali[Integer.parseInt(array.tabeldate[i][x+7])]);
                        i = nrZiua + 28;
                    }
                    else if (s2==nrProf)
                    {
                        wr=false;
                        if (array.tabeldate[i][7+x].contains("/")) {
                            int is2 = array.tabeldate[i][x + 7].indexOf("/");
                            btn.setText(array.tabeldate[i][1] + "  " + array.tabelSali[Integer.parseInt(array.tabeldate[i][x + 7].substring(1+is2))]);
                        }
                        else
                            btn.setText(array.tabeldate[i][1] + "  " + array.tabelSali[Integer.parseInt(array.tabeldate[i][x+7])]);
                        i = nrZiua + 28;
                    }
                }
                else
                if (Integer.parseInt(array.tabeldate[i][x]) == nrProf) {
                    wr=false;
                    btn.setText(array.tabeldate[i][1] + "  " + array.tabelSali[Integer.parseInt(array.tabeldate[i][x+7])]);
                    i = nrZiua + 28;
                }
            }
        }
        if (wr)
            btn.setText("-");
    }

    public void recZiua() {
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);
        nrZiua = sharedZiua.getInt("nrZi", 0);
    }

}