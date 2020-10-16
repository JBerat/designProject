package com.beratucgul.designexample.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.beratucgul.designexample.R;
import com.beratucgul.designexample.womenTopRecyclerAdapter;

public class WomenFashionFragment extends Fragment {

    ImageView womenTop, womenSkirt, womenDress, womenShoes, womenBottoms;
    TextView womenTopText, womenSkirtText, womenDressText, womenShoesText, womenBottomText;
    ImageView backToHomePage;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_women_fashion, container, false);

        womenTop = view.findViewById(R.id.womenTop);
        womenSkirt = view.findViewById(R.id.womenSkirt);
        womenDress = view.findViewById(R.id.womenDress);
        womenShoes = view.findViewById(R.id.womenShoes);
        womenBottoms = view.findViewById(R.id.womenBottoms);

        womenTopText = view.findViewById(R.id.womenTopText);
        womenSkirtText = view.findViewById(R.id.womenSkirtText);
        womenDressText = view.findViewById(R.id.womenDressText);
        womenShoesText = view.findViewById(R.id.womenShoesText);
        womenBottomText = view.findViewById(R.id.womenBottomText);

        backToHomePage = view.findViewById(R.id.backToHomePage);


        backToHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.womenFashionLayoutId, );

                */

               Backpresses();
            }
        });

        womenTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                womenTopFragment womenTopFragment = new womenTopFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.womenFashionLayoutId, womenTopFragment);
                fragmentTransaction.addToBackStack(womenTopFragment.getClass().getName()).commit();
            }
        });

        womenSkirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                womanSkirtFragment womanSkirtFragment = new womanSkirtFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.womenFashionLayoutId, womanSkirtFragment);
                fragmentTransaction.addToBackStack(womanSkirtFragment.getClass().getName()).commit();
            }
        });

        womenDress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                womenDressFragment womenDressFragment = new womenDressFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.womenFashionLayoutId, womenDressFragment);
                fragmentTransaction.addToBackStack(womenDressFragment.getClass().getName()).commit();
            }
        });

        womenShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                womenShoesFragment womenShoesFragment = new womenShoesFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.womenFashionLayoutId, womenShoesFragment);
                fragmentTransaction.addToBackStack(womenShoesFragment.getClass().getName()).commit();
            }
        });

        womenBottoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                womenBottomFragment womenBottomFragment = new womenBottomFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.womenFashionLayoutId, womenBottomFragment);
                fragmentTransaction.addToBackStack(womenBottomFragment.getClass().getName()).commit();
            }
        });




        return view;
    }

    private void Backpresses() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.womenFashionLayoutId, new homefragment()).commit();

    }
}