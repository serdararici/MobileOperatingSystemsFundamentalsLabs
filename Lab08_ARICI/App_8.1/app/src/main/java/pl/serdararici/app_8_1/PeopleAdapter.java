package pl.serdararici.app_8_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PeopleAdapter extends ArrayAdapter<People> {
    private Context myContext;
    private List<People> peopleList;
    public PeopleAdapter(Context context, ArrayList<People> list) {
        super(context, 0, list);
        myContext = context;
        peopleList = list;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(myContext).
                    inflate(R.layout.list_item,parent,false);
        People currentPeople = peopleList.get(position);
        ImageView iv = listItem.findViewById(R.id.imageView);
        iv.setImageResource(currentPeople.getImage());
        TextView tv1 = listItem.findViewById(R.id.textViewName);
        tv1.setText(currentPeople.getName());
        TextView tv2 = listItem.findViewById(R.id.textViewMail);
        tv2.setText(currentPeople.getEmail());
        TextView tv3 = listItem.findViewById(R.id.textViewPhone);
        tv3.setText(currentPeople.getPhone());
        return listItem;
    }
}
