package com.beratucgul.designexample.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.beratucgul.designexample.R;
import com.beratucgul.designexample.womenTopRecyclerAdapter;

import java.util.ArrayList;

public class womenTopFragment extends Fragment {

    womenTopRecyclerAdapter womenTopRecyclerAdapter;
    RecyclerView womenTopRecyclerView;
    ArrayList<Integer> TopPhoto = new ArrayList<>();
    ArrayList<String> TopName  = new ArrayList<>();
    ArrayList<String> TopType  = new ArrayList<>();
    ArrayList<String> TopRating  = new ArrayList<>();
    ArrayList<String> TopPrice  = new ArrayList<>();
    ImageView backToWomanFashionFragment;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_women_top, container, false);

        backToWomanFashionFragment = view.findViewById(R.id.backToWomanFashionFragment);

        backToWomanFashionFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Backpresses();
            }
        });

        TopPhoto.add(R.drawable.background_splash);
        TopPhoto.add(R.drawable.googleplus);

        TopName.add("Deneme");
        TopName.add("Deneme1");

        TopType.add("Top");
        TopType.add("Top1");

        TopRating.add("2(5)");
        TopRating.add("4(5)");

        TopPrice.add("5 TL");
        TopPrice.add("4 TL");


       womenTopRecyclerView = view.findViewById(R.id.womenTopRecyclerView);
       womenTopRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 2));
      // womenTopRecyclerAdapter = new womenTopRecyclerAdapter(R.drawable.background_splash, "DENEME", "TOP", "8", "12TL");
       womenTopRecyclerAdapter = new womenTopRecyclerAdapter(TopPhoto,TopName, TopType, TopRating, TopPrice);
       womenTopRecyclerView.setAdapter(womenTopRecyclerAdapter);

       womenTopRecyclerAdapter.setOnItemClickListener(new womenTopRecyclerAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(int position) {
               TopPhoto.get(position);

               womanTopItemDetailFragment womanTopItemDetailFragment = new womanTopItemDetailFragment();
               FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
               fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right);
               fragmentTransaction.replace(R.id.womanTopLayoutId, womanTopItemDetailFragment);
               fragmentTransaction.addToBackStack(womanTopItemDetailFragment.getClass().getName()).commit();

               SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Image", Context.MODE_PRIVATE);
               SharedPreferences.Editor editor = sharedPreferences.edit();
               editor.putInt("image", TopPhoto.get(position));
               editor.commit();

               SharedPreferences Name = getActivity().getSharedPreferences("Name", Context.MODE_PRIVATE);
               SharedPreferences.Editor editor1 = Name.edit();
               editor1.putString("name", TopName.get(position));
               editor1.commit();

               SharedPreferences Type = getActivity().getSharedPreferences("Type", Context.MODE_PRIVATE);
               SharedPreferences.Editor editor2 = Type.edit();
               editor2.putString("type", TopType.get(position));
               editor2.commit();






           }
       });






        // Inflate the layout for this fragment
        return view;
    }
    private void Backpresses() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.womanTopLayoutId, new WomenFashionFragment()).commit();
    }
}