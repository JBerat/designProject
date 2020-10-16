package com.beratucgul.designexample.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.beratucgul.designexample.R;


public class AddAddressFragment extends Fragment {
    ImageView backToAddressPage;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_address, container, false);;
        backToAddressPage = view.findViewById(R.id.backToAddressPage);
        backToAddressPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAddressFragment myAddressFragment = new MyAddressFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.AddAddressLayoutId, myAddressFragment);
                fragmentTransaction.addToBackStack(myAddressFragment.getClass().getName()).commit();
            }
        });


        return view;
    }
}