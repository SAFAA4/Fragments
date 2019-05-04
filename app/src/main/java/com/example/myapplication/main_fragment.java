package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class main_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_fragment,container,false);

        Button loca = view.findViewById(R.id.location);
        loca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pick_location fragment2 = new pick_location();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment,fragment2);
                transaction.addToBackStack("fragmentStack1") ;
                transaction.commit();
            }
        });

        Button photo = view.findViewById(R.id.photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pick_photo fragment3 = new pick_photo();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment,fragment3);
                transaction.addToBackStack("fragmentStack1") ;
                transaction.commit();
            }
        });

        Button btnexit = view.findViewById(R.id.exit);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getActivity().moveTaskToBack(true);
               android.os.Process.killProcess(android.os.Process.myPid());
               System.exit(1);

            }
        });




        return view;
    }
}
