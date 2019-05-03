package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class pick_photo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  Button gallery = getView().findViewById(R.id.gallery);
       //     gallery.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
            //}
       // });
        return inflater.inflate(R.layout.fragment_pick_photo,container,false);

    }
}
