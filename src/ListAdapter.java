package com.tradeapps.vt.mapstest2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ListAdapter extends ArrayAdapter<Swipe> {

    private List<Swipe> swipes;

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<Swipe> swipes) {
        super(context, resource, swipes);
        this.swipes = swipes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.listitemrow, null);
        }

        Swipe s = getItem(position);

        if(s!=null){

            TextView tt1 = (TextView) v.findViewById(R.id.swipe1);
            TextView tt2 = (TextView) v.findViewById(R.id.swipe2);
            TextView tt3 = (TextView) v.findViewById(R.id.swipe3);

            if(tt3!=null){
                tt1.setText("  DATE & TIME - "+s.getTimestamp());
                tt2.setText("  AMOUNT - Rs."+s.getAmount());
                tt3.setText("  LOCATION DETAILS - "+s.getAddress().getmPremises()+","+s.getAddress().getmLocality()+
                        ","+s.getAddress().getmPostalCode()+","+s.getAddress().getmCountryName());
            }
        }


        return v;
    }


}
