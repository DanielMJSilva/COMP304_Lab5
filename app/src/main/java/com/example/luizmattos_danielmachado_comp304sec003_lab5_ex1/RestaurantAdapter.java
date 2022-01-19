package com.example.luizmattos_danielmachado_comp304sec003_lab5_ex1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    //private List<Restaurant> restaurantList;

    public RestaurantAdapter(@NonNull Context context, ArrayList<Restaurant> restaurantList) {
        super(context, R.layout.restaurant_list, restaurantList);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Restaurant restaurant = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.restaurant_list, parent, false);
        }
        TextView restaurantName = (TextView) convertView.findViewById(R.id.tv_Name);
        TextView restaurantAddress = (TextView) convertView.findViewById(R.id.tv_Address);
        restaurantName.setText(restaurant.getName());
        restaurantAddress.setText(restaurant.getAddress());
        return convertView;
    }

}
