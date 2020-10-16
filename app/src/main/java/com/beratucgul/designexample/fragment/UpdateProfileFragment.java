package com.beratucgul.designexample.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.beratucgul.designexample.R;

public class UpdateProfileFragment extends Fragment {
        ImageView backToProfilePage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_update_profile, container, false);

        backToProfilePage = view.findViewById(R.id.backToProfilePage);
        backToProfilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment profileFragment = new ProfileFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations( R.anim.enter_right_to_left, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.updateProfileLayoutId, profileFragment);
                fragmentTransaction.addToBackStack(profileFragment.getClass().getName()).commit();
            }
        });



        // Inflate the layout for this fragment
        return view;
    }
}