package pl.serdararici.countries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {

    private Context myContext;
    private List<Country> countriesList;
    public CountryAdapter(Context context, ArrayList<Country> list) {
        super(context, 0, list);
        myContext = context;
        countriesList = list;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(myContext).
                    inflate(R.layout.list_item,parent,false);
        Country currentCountry = countriesList.get(position);
        ImageView iv = listItem.findViewById(R.id.imageView);
        iv.setImageResource(currentCountry.getFlag());
        TextView tv1 = listItem.findViewById(R.id.country);
        tv1.setText(currentCountry.getCountry());
        TextView tv2 = listItem.findViewById(R.id.capital);
        tv2.setText(currentCountry.getCapital());
        return listItem;
    }

}
