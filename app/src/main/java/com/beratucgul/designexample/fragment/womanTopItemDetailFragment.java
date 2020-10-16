package com.beratucgul.designexample.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.beratucgul.designexample.ItemsModel;
import com.beratucgul.designexample.ItemsTopModel;
import com.beratucgul.designexample.R;

import java.io.File;
import java.util.ArrayList;


public class womanTopItemDetailFragment extends Fragment {

    ImageView backToWomanTopFragment , womanTopPhoto;
    Button womanAddItem;
    TextView topItemDescription;
    ArrayList<Integer> photoList;
    ItemsTopModel itemsModel;
    Button LargeSize;
    boolean a = true;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_woman_top_item_detail, container, false);

        backToWomanTopFragment = view.findViewById(R.id.backToWomanTopFragment);
        womanTopPhoto = view.findViewById(R.id.womanTopPhoto);
        womanAddItem = view.findViewById(R.id.womanAddItem);
        topItemDescription = view.findViewById(R.id.topItemDescription);
        LargeSize = view.findViewById(R.id.LargeSize);



        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Image", Context.MODE_PRIVATE);
        final int photo = sharedPreferences.getInt("image", 0);

        womanTopPhoto.setImageResource(photo);



        LargeSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // LargeSize.setBackgroundColor(Color.parseColor("#3A5EB2"));
                LargeSize.setBackgroundResource(R.drawable.button_new);
                LargeSize.setTextColor(getResources().getColor(R.color.priceBlue));

            }
        });





        backToWomanTopFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Backpresses();
            }
        });

        womanAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PayFragment payFragment = new PayFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.womanTopItemDetailLayoutId, payFragment);
                fragmentTransaction.addToBackStack(payFragment.getClass().getName()).commit();


                SharedPreferences Size = getActivity().getSharedPreferences("Size", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = Size.edit();
                editor1.putString("size", LargeSize.getText().toString());
                editor1.commit();




                SharedPreferences womanTopItem = getActivity().getSharedPreferences("WomanTopId", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = womanTopItem.edit();
                editor.putInt("womanTopPhoto", photo);
                editor.commit();

            }
        });



        // Inflate the layout for this fragment
        return view;
    }
    private void Backpresses() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.womanTopItemDetailLayoutId, new womenTopFragment()).commit();
    }
}