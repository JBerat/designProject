package com.beratucgul.designexample.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.beratucgul.designexample.R;
import com.beratucgul.designexample.womenShoesRecyclerAdapter;

import java.util.ArrayList;


public class womenShoesFragment extends Fragment {

    RecyclerView womenShoesRecyclerView;
    ImageView backToWomanFashionFragment;
    womenShoesRecyclerAdapter womenShoesRecyclerAdapter;
    ArrayList<Integer> ShoesPhoto = new ArrayList<>();
    ArrayList<String> ShoesName  = new ArrayList<>();
    ArrayList<String> ShoesType  = new ArrayList<>();
    ArrayList<String> ShoesRating  = new ArrayList<>();
    ArrayList<String> ShoesPrice  = new ArrayList<>();





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_women_shoes, container, false);

        backToWomanFashionFragment = view.findViewById(R.id.backToWomanFashionFragment);
        backToWomanFashionFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Backpresses();
            }
        });

        ShoesPhoto.add(R.drawable.background_splash);
        ShoesPhoto.add(R.drawable.googleplus);

        ShoesName.add("Deneme6");
        ShoesName.add("Deneme7");

        ShoesType.add("Top6");
        ShoesType.add("Top7");

        ShoesRating.add("2(5)");
        ShoesRating.add("4(5)");

        ShoesPrice.add("5 TL");
        ShoesPrice.add("4 TL");

        womenShoesRecyclerView = view.findViewById(R.id.womenShoesRecyclerView);
        womenShoesRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),2));
        womenShoesRecyclerAdapter = new womenShoesRecyclerAdapter(ShoesPhoto, ShoesName, ShoesType, ShoesRating, ShoesPrice);
        womenShoesRecyclerView.setAdapter(womenShoesRecyclerAdapter);

        womenShoesRecyclerAdapter.setOnItemClickListener(new womenShoesRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                womenShoesItemDetailFragment womenShoesItemDetailFragment = new womenShoesItemDetailFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.womanShoesLayoutId, womenShoesItemDetailFragment);
                fragmentTransaction.addToBackStack(womenShoesItemDetailFragment.getClass().getName()).commit();

            }
        });



        // Inflate the layout for this fragment
        return view;
    }
    private void Backpresses() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.womanShoesLayoutId, new WomenFashionFragment()).commit();
    }
}