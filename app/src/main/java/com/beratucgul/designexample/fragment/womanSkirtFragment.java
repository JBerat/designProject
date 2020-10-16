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
import com.beratucgul.designexample.womenSkirtRecyclerAdapter;

import java.util.ArrayList;


public class womanSkirtFragment extends Fragment {

    RecyclerView womenSkirtRecyclerView;
    womenSkirtRecyclerAdapter womenSkirtRecyclerAdapter;
    ArrayList<Integer> SkirtPhoto = new ArrayList<>();
    ArrayList<String> SkirtName  = new ArrayList<>();
    ArrayList<String> SkirtType  = new ArrayList<>();
    ArrayList<String> SkirtRating  = new ArrayList<>();
    ArrayList<String> SkirtPrice  = new ArrayList<>();
    ImageView backToWomanFashionFragment;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_woman_skirt, container, false);

        backToWomanFashionFragment = view.findViewById(R.id.backToWomanFashionFragment);
        backToWomanFashionFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Backpresses();
            }
        });

        SkirtPhoto.add(R.drawable.background_splash);
        SkirtPhoto.add(R.drawable.googleplus);

        SkirtName.add("Deneme2");
        SkirtName.add("Deneme3");

        SkirtType.add("Top2");
        SkirtType.add("Top3");

        SkirtRating.add("2(5)");
        SkirtRating.add("4(5)");

        SkirtPrice.add("5 TL");
        SkirtPrice.add("4 TL");

        womenSkirtRecyclerView = view.findViewById(R.id.womenSkirtRecyclerView);
        womenSkirtRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),2));

        womenSkirtRecyclerAdapter = new womenSkirtRecyclerAdapter(SkirtPhoto, SkirtName, SkirtType, SkirtRating, SkirtPrice);
        womenSkirtRecyclerView.setAdapter(womenSkirtRecyclerAdapter);

        womenSkirtRecyclerAdapter.setOnItemClickListener(new womenSkirtRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                womenSkirtItemDetailFragment womenSkirtItemDetailFragment = new womenSkirtItemDetailFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.womanSkirtLayoutId, womenSkirtItemDetailFragment);
                fragmentTransaction.addToBackStack(womenSkirtItemDetailFragment.getClass().getName()).commit();

            }
        });



        // Inflate the layout for this fragment
        return view;
    }
    private void Backpresses() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.womanSkirtLayoutId, new WomenFashionFragment()).commit();
    }
}