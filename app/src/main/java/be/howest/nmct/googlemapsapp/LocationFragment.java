package be.howest.nmct.googlemapsapp;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LocationFragment extends Fragment {

    private TextView txtOpdracht;
    private EditText txtLat, txtLon;
    private Button btnToon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location,container,false);

        txtOpdracht = (TextView) v.findViewById(R.id.txtOpdracht);
        txtLat = (EditText) v.findViewById(R.id.txtLat);
        txtLon = (EditText) v.findViewById(R.id.txtLon);
        btnToon = (Button) v.findViewById(R.id.btnToon);
        btnToon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to 3rd screen (MAP) with lat and lon input from user and string value of button from screen 1

            }
        });

        return v;
    }


}
