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
import com.beratucgul.designexample.womenDressRecyclerAdapter;

import java.util.ArrayList;


public class womenDressFragment extends Fragment {

    womenDressRecyclerAdapter womenDressRecyclerAdapter;
    RecyclerView womenDressRecyclerView;
    ArrayList<Integer> DressPhoto = new ArrayList<>();
    ArrayList<String> DressName  = new ArrayList<>();
    ArrayList<String> DressType  = new ArrayList<>();
    ArrayList<String> DressRating  = new ArrayList<>();
    ArrayList<String> DressPrice  = new ArrayList<>();
    ImageView backToWomanFashionFragment;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_women_dress, container, false);

        backToWomanFashionFragment = view.findViewById(R.id.backToWomanFashionFragment);
        backToWomanFashionFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Backpresses();
            }
        });

        DressPhoto.add(R.drawable.background_splash);
        DressPhoto.add(R.drawable.googleplus);

        DressName.add("Deneme4");
        DressName.add("Deneme5");

        DressType.add("Top4");
        DressType.add("Top5");

        DressRating.add("2(5)");
        DressRating.add("4(5)");

        DressPrice.add("5 TL");
        DressPrice.add("4 TL");

        womenDressRecyclerView = view.findViewById(R.id.womenDressRecyclerView);
        womenDressRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),2));
        womenDressRecyclerAdapter = new womenDressRecyclerAdapter(DressPhoto, DressName, DressType, DressRating, DressPrice);
        womenDressRecyclerView.setAdapter(womenDressRecyclerAdapter);


        womenDressRecyclerAdapter.setOnItemClickListener(new womenDressRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                womenDressItemDetailFragment womenDressItemDetailFragment = new womenDressItemDetailFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.womanDressLayoutId, womenDressItemDetailFragment);
                fragmentTransaction.addToBackStack(womenDressItemDetailFragment.getClass().getName()).commit();
            }
        });



        // Inflate the layout for this fragment
        return view;
    }
    private void Backpresses() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.womanDressLayoutId, new WomenFashionFragment()).commit();
    }
}