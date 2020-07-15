package catalinzaharia.orardebuzunar;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SaliL2Activity extends AppCompatActivity {

    int nrZiua, nrOra;
    ArrayAdapter<String> adapter;
    ArrayList<String> arraySali;
    ListView listViewSaliL2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sali_l2);
        recZiua();
        nrOra= getIntent().getExtras().getInt("ora");
        listViewSaliL2 = (ListView) findViewById(R.id.listViewSaliL2);
        arraySali= new ArrayList<>();
        popularearray(nrOra+8);
        adapter= new ArrayAdapter<>(this, R.layout.listview_roottext, arraySali);
        listViewSaliL2.setAdapter(adapter);
    }

    private void popularearray(int x) {
        int[] saliuzt = new int[40];
        int i,c=1;
        for (i=nrZiua;i<=nrZiua+27;i++)
        {
            boolean vf=true;
            if (array.tabeldate[i][x].equals("")) {
                vf=false;
            }
            if (vf) {
                if (array.tabeldate[i][x].contains("/")) {
                    int is = array.tabeldate[i][x].indexOf("/");
                    saliuzt[c] = Integer.parseInt(array.tabeldate[i][x].substring(0, is));
                    c++;
                    saliuzt[c] = Integer.parseInt(array.tabeldate[i][x].substring(is+1));
                    c++;
                    }
                else{
                    saliuzt[c] = Integer.parseInt(array.tabeldate[i][x]);
                    c++;
                    }
            }
        }
        for (i=1;i<=array.sC;i++){
            boolean sw=true;
            if (array.tabelSali[i].length()>0)
            {
                for (int j=1;j<=c;j++)
                {
                    if (array.tabelSali[i].equals(array.tabelSali[saliuzt[j]]))
                    {
                        sw=false;
                        j=c+1;
                    }
                }
                if (sw)
                    arraySali.add(array.tabelSali[i]);
            }
        }
    }

    public void recZiua() {
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);
        nrZiua = sharedZiua.getInt("nrZi", 0);
    }
}
