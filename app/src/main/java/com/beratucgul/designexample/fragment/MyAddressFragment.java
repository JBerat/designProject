package com.beratucgul.designexample.fragment;

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

import com.beratucgul.designexample.R;
import com.beratucgul.designexample.addressRecyclerAdapter;

import java.util.ArrayList;


public class MyAddressFragment extends Fragment {

    Button addAddressButton;
    RecyclerView myAddressRecyclerView;
    addressRecyclerAdapter addressRecyclerAdapter;
    ArrayList<Integer> addressUpdateList  = new ArrayList<>();
    ArrayList<Integer> addressDeleteList = new ArrayList<>();
    ArrayList<String> addressTypeList = new ArrayList<>();
    ArrayList<String> addressPersonNameList = new ArrayList<>();
    ArrayList<String> addressPersonCityList = new ArrayList<>();
    ArrayList<String> addressPersonLocationList = new ArrayList<>();
    ArrayList<String> addressPersonDetailList = new ArrayList<>();
    ImageView backToProfilePage;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_address, container, false);

        addAddressButton = view.findViewById(R.id.addAddressButton);

        addAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAddressFragment addAddressFragment = new AddAddressFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.MyAddressLayoutId, addAddressFragment);
                fragmentTransaction.addToBackStack(addAddressFragment.getClass().getName()).commit();
            }
        });
        backToProfilePage = view.findViewById(R.id.backToProfilePage);
        backToProfilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment profileFragment = new ProfileFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                fragmentTransaction.replace(R.id.MyAddressLayoutId, profileFragment);
                fragmentTransaction.addToBackStack(profileFragment.getClass().getName()).commit();
            }
        });




        addressTypeList.add("New");
        addressPersonNameList.add("Berat");
        addressPersonCityList.add("Adana");
        addressPersonLocationList.add("Ziyapaşa");
        addressPersonDetailList.add("Detail");

        myAddressRecyclerView = view.findViewById(R.id.myAddressRecyclerView);
        myAddressRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        addressRecyclerAdapter = new addressRecyclerAdapter(addressTypeList, addressPersonNameList, addressPersonCityList,addressPersonLocationList,addressPersonDetailList);
        myAddressRecyclerView.setAdapter(addressRecyclerAdapter);


        addressRecyclerAdapter.setOnItemClickListener(new addressRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }

            @Override
            public void onUpdateClick(int position) {


            }
        });



        return view;
    }
    public void removeItem(int position){
        addressTypeList.remove(position);
        addressRecyclerAdapter.notifyItemRemoved(position);
    }

}