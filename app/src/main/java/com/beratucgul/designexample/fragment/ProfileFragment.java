package com.beratucgul.designexample.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.beratucgul.designexample.MainActivity;
import com.beratucgul.designexample.R;

import java.security.Provider;


public class ProfileFragment extends Fragment {

    ImageView profileQuit, profileUpdate, profileAddress, profileFavourites;
    Button activeOrderButton, previousOrderButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profileQuit = view.findViewById(R.id.profileQuit);
        profileUpdate = view.findViewById(R.id.profileUpdate);
        profileAddress = view.findViewById(R.id.profileAddress);
        profileFavourites = view.findViewById(R.id.profileFavourites);

        activeOrderButton = view.findViewById(R.id.activeOrderButton);
        previousOrderButton = view.findViewById(R.id.previousOrderButton);



        activeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActiveOrderFragment activeOrderFragment = new ActiveOrderFragment();
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.profileLayoutId, activeOrderFragment);
                fragmentTransaction.addToBackStack(activeOrderFragment.getClass().getName()).commit();
            }
        });





        profileQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), "Log out is successful", Toast.LENGTH_SHORT).show();

            }
        });



        profileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UpdateProfileFragment updateProfileFragment = new UpdateProfileFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.profileLayoutId, updateProfileFragment);
                fragmentTransaction.addToBackStack(updateProfileFragment.getClass().getName()).commit();

            }
        });

        profileAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyAddressFragment myAddressFragment = new MyAddressFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.profileLayoutId, myAddressFragment);
                fragmentTransaction.addToBackStack(myAddressFragment.getClass().getName()).commit();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}