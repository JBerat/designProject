package com.beratucgul.designexample.fragment;

import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.beratucgul.designexample.ItemsTopModel;
import com.beratucgul.designexample.R;
import com.beratucgul.designexample.payCartRecyclerAdapter;

import java.util.ArrayList;


public class PayFragment extends Fragment {
    ImageView backToHomePageFragment;
    RecyclerView payRecyclerView;
    payCartRecyclerAdapter payCartRecyclerAdapter;



    ArrayList<Integer> payCartPhoto = new ArrayList<>();
    ArrayList<String> fashionNameList = new ArrayList<>();
    ArrayList<String> fashionTypeList = new ArrayList<>();
    ArrayList<String> fashionSizeList = new ArrayList<>();
    ArrayList<String> fashionSizeTypeList = new ArrayList<>();
    ArrayList<String> fashionNumberList = new ArrayList<>();
    ArrayList<String> fashionPriceList = new ArrayList<>();
    Button proceed;
    ItemsTopModel itemsTopModel;
    ArrayList<ItemsTopModel> itemsTopModels;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay, container, false);


       /* SharedPreferences sharedPreferences = getActivity().getSharedPreferences("WomanTopId", Context.MODE_PRIVATE);
        int photo = sharedPreferences.getInt("womanTopPhoto", 0);

        */
       proceed = view.findViewById(R.id.proceed);
       proceed.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               PayProceedFragment payProceedFragment = new PayProceedFragment();
               FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
               fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
               fragmentTransaction.replace(R.id.payFragmentLayoutId, payProceedFragment);
               fragmentTransaction.addToBackStack(payProceedFragment.getClass().getName()).commit();


           }
       });



        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Image", Context.MODE_PRIVATE);
        final int photo = sharedPreferences.getInt("image", 0);

      //  itemsTopModel = new ItemsTopModel(photo, "deneme", "deneme", "deneme", "deneme", "1", "5TL");

        SharedPreferences Size = getActivity().getSharedPreferences("Size", Context.MODE_PRIVATE);
        String size = Size.getString("size", "");


        payCartPhoto.add(photo);
        //payCartPhoto.add(photo);

        fashionNameList.add("Deneme2");
        //fashionNameList.add("deneme3");

        fashionTypeList.add("Deneme2");
        //fashionTypeList.add("deneme3");

        fashionSizeList.add("deneme3");
        //fashionSizeList.add("Deneme2");

        fashionSizeTypeList.add(size);
        //fashionSizeTypeList.add("Deneme2");
        fashionNumberList.add("Deneme2");
        //fashionNumberList.add("deneme3");


        fashionPriceList.add("5 TL");
        //fashionPriceList.add("5 TL");


        payRecyclerView = view.findViewById(R.id.payRecyclerView);
        payRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        payCartRecyclerAdapter = new payCartRecyclerAdapter(payCartPhoto, fashionNameList, fashionTypeList, fashionSizeTypeList, fashionPriceList);
        payRecyclerView.setAdapter(payCartRecyclerAdapter);





        // Inflate the layout for this fragment
        return view;
    }
    private void Backpresses() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.payFragmentLayoutId, new homefragment()).commit();
    }
}