package fr.ppm.tp02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {
    private Context context;
    private int resource;

    public PersonAdapter(Context context, int resource, List<Person> persons) {
        super(context, resource, persons);
        this.context = context;
        this.resource = resource;
    }

    @Override
    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Person person = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.person_list_item, parent, false);
        }
        TextView name = convertView.findViewById(R.id.name);
        TextView phoneNumber = convertView.findViewById(R.id.phone_number);
        TextView email = convertView.findViewById(R.id.email);

        name.setText(person.getFullName());
        phoneNumber.setText(person.getPhoneNumber());
        email.setText(person.getEmail());
        return convertView;
    }

}
