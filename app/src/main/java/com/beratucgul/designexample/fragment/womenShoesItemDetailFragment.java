package com.beratucgul.designexample.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.beratucgul.designexample.R;


public class womenShoesItemDetailFragment extends Fragment {

    ImageView backToWomanTopFragment, womanSkirtPhoto;
    Button womanAddItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_women_shoes_item_detail, container, false);
        backToWomanTopFragment = view.findViewById(R.id.backToWomanTopFragment);
        backToWomanTopFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Backpresses();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
    private void Backpresses() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.womanShoesItemDetailLayoutId, new womenTopFragment()).commit();
    }
}