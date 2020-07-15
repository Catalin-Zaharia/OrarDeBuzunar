package catalinzaharia.orardebuzunar;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrarActivity extends AppCompatActivity {
    int nrZiua;
    int no2,no3;
    Button buttonAOrar,buttonBOrar,buttonCOrar,buttonDOrar,buttonEOrar,buttonFOrar,buttonGOrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orar);
        recZiua();
        setaretext();
    }

    public void recZiua(){
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);

        nrZiua=sharedZiua.getInt("nrZi", 0);

    }

    private void setaretext() {
        buttonAOrar = (Button) findViewById(R.id.buttonAOrar);
        buttonBOrar = (Button) findViewById(R.id.buttonBOrar);
        buttonCOrar = (Button) findViewById(R.id.buttonCOrar);
        buttonDOrar = (Button) findViewById(R.id.buttonDOrar);
        buttonEOrar = (Button) findViewById(R.id.buttonEOrar);
        buttonFOrar = (Button) findViewById(R.id.buttonFOrar);
        buttonGOrar = (Button) findViewById(R.id.buttonGOrar);
        SharedPreferences sharedOrar = getSharedPreferences("orarSave", Context.MODE_PRIVATE);

        if (sharedOrar.getInt("no1", 0)==0)
        {
            buttonAOrar.setVisibility(View.INVISIBLE);
            buttonBOrar.setVisibility(View.INVISIBLE);
            buttonCOrar.setVisibility(View.INVISIBLE);
            buttonEOrar.setVisibility(View.INVISIBLE);
            buttonFOrar.setVisibility(View.INVISIBLE);
            buttonGOrar.setVisibility(View.INVISIBLE);
            buttonDOrar.setText("Nu ati selectat un orar pentru a fi afisat. Acesta poate fi selectat navigand la orarul dorit si apasand butonul \"Salvare\"");
        }
        else
        {
            if (sharedOrar.getInt("no1",0)==2)
            {
                no2=sharedOrar.getInt("no2",0);
                no3=sharedOrar.getInt("no3",0);
                afisOrarC();
            }
            if (sharedOrar.getInt("no1",0)==1)
            {
                no2=sharedOrar.getInt("no2",0);
                afisOrarP();
            }
            if (sharedOrar.getInt("no1",0)==3)
            {
                no2=sharedOrar.getInt("no2",0);
                afisOrarS();
            }
        }
    }

    private void afisOrarC() {
        buttonAOrar = (Button) findViewById(R.id.buttonAOrar);
        buttonBOrar = (Button) findViewById(R.id.buttonBOrar);
        buttonCOrar = (Button) findViewById(R.id.buttonCOrar);
        buttonDOrar = (Button) findViewById(R.id.buttonDOrar);
        buttonEOrar = (Button) findViewById(R.id.buttonEOrar);
        buttonFOrar = (Button) findViewById(R.id.buttonFOrar);
        buttonGOrar = (Button) findViewById(R.id.buttonGOrar);

        setaretextC(buttonAOrar, 2);
        setaretextC(buttonBOrar, 3);
        setaretextC(buttonCOrar, 4);
        setaretextC(buttonDOrar, 5);
        setaretextC(buttonEOrar, 6);
        setaretextC(buttonFOrar, 7);
        setaretextC(buttonGOrar, 8);
    }

    private void setaretextC(Button btn, int x)
    {
        if (array.tabeldate[nrZiua+no2+no3][x].equals(""))
            btn.setText("-");
        else
            btn.setText(verifslashC(x));
    }

    private String verifslashC(int x) {
        int s1 , s2 = 0, s3 , s4 = 0;
        boolean sp = false, ss = false;
        String stp, sts;
        if (array.tabeldate[nrZiua + no2 + no3][x].contains("/")) {
            sp = true;
            int is = array.tabeldate[nrZiua + no2 + no3][x].indexOf("/");
            s1 = Integer.parseInt(array.tabeldate[nrZiua + no2 + no3][x].substring(0, is));
            s2 = Integer.parseInt(array.tabeldate[nrZiua + no2 + no3][x].substring(is + 1));
        } else
            s1 = Integer.parseInt(array.tabeldate[nrZiua + no2 + no3][x]);
        if (array.tabeldate[nrZiua + no2 + no3][x + 7].contains("/")) {
            ss = true;
            int is = array.tabeldate[nrZiua + no2 + no3][x + 7].indexOf("/");
            s3 = Integer.parseInt(array.tabeldate[nrZiua + no2 + no3][x + 7].substring(0, is));
            s4 = Integer.parseInt(array.tabeldate[nrZiua + no2 + no3][x + 7].substring(is + 1));
        } else
            s3 = Integer.parseInt(array.tabeldate[nrZiua + no2 + no3][x + 7]);
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

    private void afisOrarP() {
       buttonAOrar = (Button) findViewById(R.id.buttonAOrar);
       buttonBOrar = (Button) findViewById(R.id.buttonBOrar);
         buttonCOrar = (Button) findViewById(R.id.buttonCOrar);
         buttonDOrar = (Button) findViewById(R.id.buttonDOrar);
        buttonEOrar = (Button) findViewById(R.id.buttonEOrar);
        buttonFOrar = (Button) findViewById(R.id.buttonFOrar);
        buttonGOrar = (Button) findViewById(R.id.buttonGOrar);

        setaretextP(buttonAOrar,2);
        setaretextP(buttonBOrar,3);
        setaretextP(buttonCOrar,4);
        setaretextP(buttonDOrar,5);
        setaretextP(buttonEOrar,6);
        setaretextP(buttonFOrar,7);
        setaretextP(buttonGOrar,8);

    }

    private void setaretextP(Button btn, int x) {

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

                    if (s1==no2)
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
                    else if (s2==no2)
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
                if (Integer.parseInt(array.tabeldate[i][x]) == no2) {
                    wr=false;
                    btn.setText(array.tabeldate[i][1] + "  " + array.tabelSali[Integer.parseInt(array.tabeldate[i][x+7])]);
                    i = nrZiua + 28;
                }
            }
        }
        if (wr)
            btn.setText("-");
    }

    private void afisOrarS() {
         buttonAOrar = (Button) findViewById(R.id.buttonAOrar);
         buttonBOrar = (Button) findViewById(R.id.buttonBOrar);
         buttonCOrar = (Button) findViewById(R.id.buttonCOrar);
         buttonDOrar = (Button) findViewById(R.id.buttonDOrar);
         buttonEOrar = (Button) findViewById(R.id.buttonEOrar);
         buttonFOrar = (Button) findViewById(R.id.buttonFOrar);
         buttonGOrar = (Button) findViewById(R.id.buttonGOrar);

        setaretextS(buttonAOrar,2);
        setaretextS(buttonBOrar,3);
        setaretextS(buttonCOrar,4);
        setaretextS(buttonDOrar,5);
        setaretextS(buttonEOrar,6);
        setaretextS(buttonFOrar,7);
        setaretextS(buttonGOrar,8);
    }

    private void setaretextS(Button btn, int x) {

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

                    if (s1==no2)
                    {
                        wr=false;
                        btn.setText(array.tabeldate[i][1] + "  " + array.tabelProf[Integer.parseInt(array.tabeldate[i][x].substring(0, is))]);
                        i = nrZiua + 28;
                    }
                    else if (s2==no2)
                    {
                        wr=false;
                        btn.setText(array.tabeldate[i][1] + "  " + array.tabelProf[Integer.parseInt(array.tabeldate[i][x].substring(is+1))]);
                        i = nrZiua + 28;
                    }
                }
                else
                if (Integer.parseInt(array.tabeldate[i][x+7]) == no2) {
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
}

    
