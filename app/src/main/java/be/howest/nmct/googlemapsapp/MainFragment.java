package be.howest.nmct.googlemapsapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ruben on 25/04/2015.
 */
public class MainFragment extends Fragment {

    private Button btnOpdracht1, btnOpdracht2, btnOpdracht3, btnOpdracht4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main,container,false);

        btnOpdracht1 = (Button)v.findViewById(R.id.btnOpdracht1);
        btnOpdracht1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to 2nd screen with value from button 1

            }
        });

        btnOpdracht2 = (Button)v.findViewById(R.id.btnOpdracht2);
        btnOpdracht2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to 2nd screen with value from button 2

            }
        });

        btnOpdracht3 = (Button)v.findViewById(R.id.btnOpdracht3);
        btnOpdracht3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to 2nd screen with value from button 3

            }
        });

        btnOpdracht4 = (Button)v.findViewById(R.id.btnOpdracht4);
        btnOpdracht4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to 2nd screen with value from button 4

            }
        });

        return v;
    }
}
