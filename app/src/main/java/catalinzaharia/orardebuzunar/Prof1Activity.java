package catalinzaharia.orardebuzunar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prof1Activity extends AppCompatActivity {
    String ziuacurentain;
    Button buttonZiuaProf1;
    SearchView searchProf1;
    ListView listViewProf1;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof1);
        buttonZiuaProf1= (Button) findViewById(R.id.buttonZiuaSaliL);
        recZiua();
        listViewProf1 = (ListView) findViewById(R.id.listViewProf1);
        searchProf1 = (SearchView) findViewById(R.id.searchProf1);
        ArrayList<String> arrayProf= new ArrayList<>();
        for (int i=1;i<=array.pC;i++) {
            if (array.tabelProf[i].length()>1)
            arrayProf.add(array.tabelProf[i]);

        }
        adapter= new ArrayAdapter<>(this, R.layout.listview_roottext, arrayProf);
        listViewProf1.setAdapter(adapter);


        configButtonProf1();
        search();
    }

    private void search() {
        searchProf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchProf1.setIconified(false);
            }
        });
        searchProf1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        recZiua();
    }

    public void recZiua(){
        SharedPreferences sharedZiua = getSharedPreferences("ziuaCurenta", Context.MODE_PRIVATE);

        ziuacurentain= sharedZiua.getString("ziuaCr","");
        buttonZiuaProf1.setText(ziuacurentain);
    }


    private void configButtonProf1() {

        buttonZiuaProf1= (Button) findViewById(R.id.buttonZiuaSaliL);
        buttonZiuaProf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Prof1Activity.this, ZileActivity.class);
                startActivity(intent);
            }
        });
        listViewProf1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position,long id) {
                array.numeProf= (String) listViewProf1.getItemAtPosition(position);
                Intent intent = new Intent(Prof1Activity.this, Prof2Activity.class);
                startActivity(intent);

            }
        });
    }
}
