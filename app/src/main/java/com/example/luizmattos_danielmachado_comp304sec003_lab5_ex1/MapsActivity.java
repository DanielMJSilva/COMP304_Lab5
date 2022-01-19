package com.example.luizmattos_danielmachado_comp304sec003_lab5_ex1;

import static android.app.ProgressDialog.show;

import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luizmattos_danielmachado_comp304sec003_lab5_ex1.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
    public ArrayList<Restaurant> restaurantByTypeList = new ArrayList<Restaurant>();
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    TextView type_title;
    TextView tv_location;
    ListView listViewByType;

    String name;
    double lat;
    double lon;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String type = getIntent().getStringExtra("type");

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        listViewByType = findViewById(R.id.list_view_type);
        type_title = findViewById(R.id.tv_type);
        type_title.setText(type);
        filterRestaurant(type);

        tv_location =findViewById(R.id.tv_location);

        RestaurantAdapter restaurantByTypeAdapter = new RestaurantAdapter(this, restaurantByTypeList);
        binding.listViewType.setAdapter(restaurantByTypeAdapter);

        binding.listViewType.setClickable(true);
        binding.listViewType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                name = restaurantByTypeList.get(position).getName();
                lat = Double.parseDouble(restaurantByTypeList.get(position).getLat());
                lon = Double.parseDouble(restaurantByTypeList.get(position).getLon());

                LatLng newLatLng = new LatLng(lat, lon);

                mMap.clear();

                mMap.addMarker(new MarkerOptions().position(newLatLng).title(name));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(newLatLng));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(17));

                Toast.makeText(getApplicationContext(), name + " selected", Toast.LENGTH_SHORT ).show();
                tv_location.setText(name + " at "  + restaurantByTypeList.get(position).getAddress()+"\n" + "( " + lat + ", " + lon + " )");
            }
        });
    }

    private void setupData()
    {
        Restaurant italian1 = new Restaurant("0","Italian", "Grazie","2373 Yonge St","43.70938852566742","-79.39864369038627");
        restaurantList.add(italian1);

        Restaurant italian2 = new Restaurant("1","Italian","Libretto", "155 University Ave","43.648709769100094","-79.38500377515409");
        restaurantList.add(italian2);

        Restaurant chinese1 = new Restaurant("2","Chinese","Mandarin","2200 Yonge St", "43.706250195064186","-79.39854733026696");
        restaurantList.add(chinese1);

        Restaurant chinese2 = new Restaurant("3","Chinese","Chi Dim Sum","2425 Yonge St","43.71064108274373","-79.39888016649726");
        restaurantList.add(chinese2);

        Restaurant greek1 = new Restaurant("4","Greek", "Mezes","456 Danforth Ave","43.67816683882258","-79.35025941514249");
        restaurantList.add(greek1);

        Restaurant greek2 = new Restaurant("5", "Greek","Pantheon Restaurant","407 Danforth Ave","43.67756525740331","-79.35138454201822");
        restaurantList.add(greek2);

        Restaurant indian1 = new Restaurant("6","Indian", "Pukka Pukka","2633 Yonge St","43.71584428543876","-79.40069342315624");
        restaurantList.add(indian1);

        Restaurant indian2 = new Restaurant("7","Indian", "Marigolg","552 Mt Pleasant Rd","43.70345076428259","-79.38819098231914");
        restaurantList.add(indian2);

        Restaurant brazilian1 = new Restaurant("8","Brazilian", "Rio 40 Restaurant","1256 St Clair Ave W","43.67765436658648","-79.44649013026765");
        restaurantList.add(brazilian1);

        Restaurant brazilian2 = new Restaurant("9","Brazilian", "Samba Brazil Eatery","1646 St Clair Ave W","43.67500651957506","-79.4573198798657");
        restaurantList.add(brazilian2);
    }

    private void filterRestaurant(String type){
        restaurantByTypeList.clear();
        setupData();
        for (int i = 0; i < restaurantList.size(); i++){
            if(type.equals(restaurantList.get(i).getType())){
                restaurantByTypeList.add(restaurantList.get(i));
            }
        }
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        // Add a marker and move the camera
        LatLng toronto = new LatLng(44.66888925033973, -79.39369135638974);
        mMap.addMarker(new MarkerOptions().position(toronto).title("Toronto"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toronto));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));

    }

    public void ChangeType(View view){
        if(mMap.getMapType() == GoogleMap.MAP_TYPE_TERRAIN){
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        } else if(mMap.getMapType() == GoogleMap.MAP_TYPE_SATELLITE){
            mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        }
    }

}