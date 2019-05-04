package com.example.myapplication;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import static android.app.Activity.RESULT_OK;

public class pick_photo extends Fragment  {
    private static final int IMAGE_PICK_CODE = 100;
    private static final int PERMISSION_CODE = 1001;
    ImageView imageView;
    Button gallery;
    Uri imageUri;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pick_photo,container,false);
        gallery = view.findViewById(R.id.gallery);
        imageView = view.findViewById(R.id.image);

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check runtime permission
              //  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
               //     if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                 //   }
                openGallery();
                }


        });
        return view;

    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,IMAGE_PICK_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }
}
