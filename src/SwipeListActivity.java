package com.tradeapps.vt.mapstest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SwipeListActivity extends AppCompatActivity {

    private String operation;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Swipe> swipes = new ArrayList<Swipe>();
        CustomAddress ca1 = new CustomAddress("Nayanappanahalli", "Home - Mahaveer rhyolite Apartments",
                "560076", "India",12.8813386,77.6125572);
        CustomAddress ca2 = new CustomAddress("Bannerghatta main road","Reebok - Royal Meenakshi Mall",
                "560076", "India",12.8759231,77.5935119);
        String timeStamp1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String timeStamp2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

        Swipe s1 = new Swipe(timeStamp1,2800,ca1);
        Swipe s2 = new Swipe(timeStamp2, 4000, ca2);

        swipes.add(s1);
        swipes.add(s2);

        ListView listContent = (ListView) findViewById(R.id.list);

        //get data from the table by the ListAdapter
        ListAdapter customAdapter = new ListAdapter(this, R.layout.listitemrow, swipes);
        listContent.setAdapter(customAdapter);

        button = (Button) findViewById(R.id.button3);
        //onclicklistener code .....


    }

    public void addListenerOnSpinnerItemSelection() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


    public void onQuit(View v){
        finish();
    }

    public void onGetHome(View v){
        Intent i = new Intent(this, TimeRangeSelection.class);
        startActivity(i);
        finish();
    }

    public void onMapViewSelection(View v){
        finish();
    }

    class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {


        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

            Toast.makeText(parent.getContext(),
                    "Operation Selected : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();
            operation = String.valueOf(parent.getItemAtPosition(pos));


        }




        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }

}
