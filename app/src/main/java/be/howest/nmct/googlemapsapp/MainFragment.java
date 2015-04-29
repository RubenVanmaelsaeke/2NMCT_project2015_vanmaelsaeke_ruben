package be.howest.nmct.googlemapsapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Ruben on 25/04/2015.
 */
public class MainFragment extends Fragment {
    private Button btnToon;
    private EditText txtLocatie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main,container,false);

        txtLocatie = (EditText)v.findViewById(R.id.txtLocatie);

        btnToon = (Button)v.findViewById(R.id.btnToon);
        btnToon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GO TO MAP and show location from textfield

            }
        });

        return v;
    }
}
