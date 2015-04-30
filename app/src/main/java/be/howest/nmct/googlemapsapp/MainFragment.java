package be.howest.nmct.googlemapsapp;

import android.app.Activity;
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
    onShowLocationListener i;

    static final String OPDRACHT = "be.howest.nmct.OPDRACHT";

    public String currentOpdracht;

    private Button btnOpdracht1, btnOpdracht2, btnOpdracht3, btnOpdracht4;

    public interface onShowLocationListener{
        public void showLocationFragment(String opdracht);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        i = (onShowLocationListener) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            currentOpdracht = getArguments().getString(OPDRACHT);
        }
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
                currentOpdracht = btnOpdracht1.getText().toString();
                i.showLocationFragment(currentOpdracht);
            }
        });

        btnOpdracht2 = (Button)v.findViewById(R.id.btnOpdracht2);
        btnOpdracht2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to 2nd screen with value from button 2
                currentOpdracht = btnOpdracht2.getText().toString();
                i.showLocationFragment(currentOpdracht);
            }
        });

        btnOpdracht3 = (Button)v.findViewById(R.id.btnOpdracht3);
        btnOpdracht3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to 2nd screen with value from button 3
                currentOpdracht = btnOpdracht3.getText().toString();
                i.showLocationFragment(currentOpdracht);
            }
        });

        btnOpdracht4 = (Button)v.findViewById(R.id.btnOpdracht4);
        btnOpdracht4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to 2nd screen with value from button 4
                currentOpdracht = btnOpdracht4.getText().toString();
                i.showLocationFragment(currentOpdracht);
            }
        });

        return v;
    }

    public static MainFragment newInstance(String opdracht){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(OPDRACHT, opdracht);
        fragment.setArguments(args);
        return fragment;
    }

    //noodzakelijk!!!!
    public MainFragment(){

    }
}
