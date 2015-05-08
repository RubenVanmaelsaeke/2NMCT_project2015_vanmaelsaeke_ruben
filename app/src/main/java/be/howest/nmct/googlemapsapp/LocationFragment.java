package be.howest.nmct.googlemapsapp;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LocationFragment extends Fragment {
    onShowMapsListener i;

    static final String OPDRACHT = "be.howest.nmct.OPDRACHT";
    static final String LAT = "be.howest.nmct.LAT";
    static final String LON = "be.howest.nmct.LON";

    public String opdracht;
    public String lat, lon;

    private TextView txtOpdracht;
    private EditText txtLat, txtLon;
    private Button btnToon;

    public interface onShowMapsListener{
        public void showMapsFragment(String opdracht, String lat, String lon);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        i = (onShowMapsListener) activity;
    }

    //noodzakelijk!!!!
    public LocationFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            opdracht = getArguments().getString(OPDRACHT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location,container,false);

        txtOpdracht = (TextView) v.findViewById(R.id.txtOpdracht);
        txtLat = (EditText) v.findViewById(R.id.txtLat);
        txtLon = (EditText) v.findViewById(R.id.txtLon);

        //set titel van de opdracht naar de content van de geklikte button
        txtOpdracht.setText(opdracht);

        btnToon = (Button) v.findViewById(R.id.btnToon);
        btnToon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to 3rd screen (MAP) with lat and lon input from user and string value of button from screen 1
                if (!txtLat.getText().toString().matches("") || !txtLon.getText().toString().matches("")){
                    lat = txtLat.getText().toString();
                    lon = txtLon.getText().toString();
                    i.showMapsFragment(opdracht, lat, lon);
                }
                else{
                    Toast.makeText(getActivity(), "Gelieve de coördinaten in te vullen...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    public static LocationFragment newInstance(String opdracht){
        LocationFragment fragment = new LocationFragment();
        Bundle args = new Bundle();
        args.putString(OPDRACHT, opdracht);
        fragment.setArguments(args);
        return fragment;
    }
}
