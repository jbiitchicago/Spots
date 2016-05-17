package com.tradeapps.vt.mapstest2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TimeRangeSelection extends AppCompatActivity {
    private RadioGroup radioGroup;
    private String message = "";
    private String card = "";
    public final static String EXTRA_MESSAGE = "com.tradeapps.vt.mapstest2.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_range_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  assert toolbar != null;
       // toolbar.setTitle("Spots");
        setSupportActionBar(toolbar);



        /* Initialize Radio Group and attach click handler */
        radioGroup = (RadioGroup) findViewById(R.id.radioDateRange);
        //radioGroup.clearCheck();

        /* Attach CheckedChangeListener to radio group */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if(null!=rb && checkedId > -1){
                    Toast.makeText(TimeRangeSelection.this, rb.getText(), Toast.LENGTH_SHORT).show();
                    message += " "+String.valueOf(rb.getText());
                   // Log.d("radioText",radioText);
                }

            }
        });

        Spinner spinner=(Spinner)findViewById(R.id.input1);
        //ArrayAdapter<String> adp;
       /* List<String> list = new ArrayList<String>();
        list.add("Card1 - 4693 - XXXX - XXXX - 5312");
        list.add("Card2 - 4691 - XXXX - XXXX - 7899");
        adp= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,list);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adp);*/
        addListenerOnSpinnerItemSelection();
    }

    public void addListenerOnSpinnerItemSelection() {
        Spinner spinner = (Spinner) findViewById(R.id.input1);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void onSubmit(View v) {
        RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        Toast.makeText(TimeRangeSelection.this, rb.getText(), Toast.LENGTH_SHORT).show();
       // if(radioText!=null) {
        //*********************START THE NEXT ACTIVITY- MAPS PLOT*****************************
            Intent i = new Intent(TimeRangeSelection.this, MapsPlot.class);
            i.putExtra(EXTRA_MESSAGE, message);
            startActivity(i);
       // ************************************************************************************
    }

    public void onQuit(View v) {
        finish();
    }


    class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {


        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

            ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            ((TextView) parent.getChildAt(0)).setTextSize(20);

            Toast.makeText(parent.getContext(),
                    "Card Selected : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_LONG).show();
            card = String.valueOf(parent.getItemAtPosition(pos));
            message +=" "+card;


        }




        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }

    }


