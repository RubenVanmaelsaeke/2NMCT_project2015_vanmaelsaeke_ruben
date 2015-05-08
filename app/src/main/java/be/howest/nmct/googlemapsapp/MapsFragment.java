package be.howest.nmct.googlemapsapp;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment implements OnMapReadyCallback {

    MapFragment mMap;

    static final String OPDRACHT = "be.howest.nmct.OPDRACHT";
    static final String LAT = "be.howest.nmct.LAT";
    static final String LON = "be.howest.nmct.LON";

    public String opdracht;
    public Double lat, lon;

    //noodzakelijk!!!!
    public MapsFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            opdracht = getArguments().getString(OPDRACHT);
            lat = Double.valueOf(getArguments().getString(LAT));
            lon = Double.valueOf(getArguments().getString(LON));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_maps,container,false);

        mMap = getMapFragment();
        mMap.getMapAsync(this);

        return v;
    }

    private MapFragment getMapFragment() {
        FragmentManager fm;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {

            fm = getFragmentManager();
        } else {

            fm = getChildFragmentManager();
        }
        return (MapFragment) fm.findFragmentById(R.id.mMap);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng location = new LatLng(lat, lon);

        map.setMyLocationEnabled(true);

        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));

        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker))
                .title(opdracht)
                .snippet("Voltooi " + opdracht + " en krijg de volgende coördinaten")
                .position(location));

        Toast.makeText(getActivity(), "Klik op de marker en rechtsonderaan heb je de optie om de route uit te stippelen", Toast.LENGTH_LONG).show();
    }

    public static MapsFragment newInstance(String opdracht, String lat, String lon){
        MapsFragment fragment = new MapsFragment();
        Bundle args = new Bundle();
        args.putString(OPDRACHT, opdracht);
        args.putString(LAT, lat);
        args.putString(LON, lon);
        fragment.setArguments(args);
        return fragment;
    }
}
