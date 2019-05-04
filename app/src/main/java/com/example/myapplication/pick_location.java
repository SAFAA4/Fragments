package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import static android.app.Activity.RESULT_OK;


public class pick_location extends Fragment {
    int PLACE_PICKER_REQUEST = 1;
    TextView latitude_logtude;
    Button pickerlocation;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pick_location,container,false);
         pickerlocation = view.findViewById(R.id.map);
         latitude_logtude = view.findViewById(R.id.latlog);
         pickerlocation.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                 try {
                     startActivityForResult(builder.build(getActivity()),PLACE_PICKER_REQUEST);
                 } catch (GooglePlayServicesRepairableException e) {
                     e.printStackTrace();
                 } catch (GooglePlayServicesNotAvailableException e) {
                     e.printStackTrace();
                 }
             }
        });
        ImageView back1 = view.findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_fragment fragment5 = new main_fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment,fragment5);
                transaction.commit();
            }
        });

        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST){
            if(resultCode == RESULT_OK){
                Place place = PlacePicker.getPlace(data,getContext());
                StringBuilder stringBuilder = new StringBuilder();
                String latitude = String.valueOf(place.getLatLng().latitude);
                String longitude = String.valueOf(place.getLatLng().longitude);
                stringBuilder.append("LATITUDE :");
                stringBuilder.append(latitude);
                stringBuilder.append("\n");
                stringBuilder.append("LONGITUDE :");
                stringBuilder.append(longitude);
                latitude_logtude.setText(stringBuilder.toString());
            }
        }
    }
}
