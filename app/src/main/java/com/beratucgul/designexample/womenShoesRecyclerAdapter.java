package com.beratucgul.designexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class womenShoesRecyclerAdapter extends RecyclerView.Adapter<womenShoesRecyclerAdapter.RowHolder> {

    ArrayList<Integer> ShoesPhoto;
    ArrayList<String> ShoesNameArrayList;
    ArrayList<String> ShoesTypeArrayList;
    ArrayList<String> ratingArrayList;
    ArrayList<String> priceArrayList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }


    public womenShoesRecyclerAdapter(ArrayList<Integer> shoesPhoto, ArrayList<String> shoesNameArrayList, ArrayList<String> shoesTypeArrayList, ArrayList<String> ratingArrayList, ArrayList<String> priceArrayList) {
        ShoesPhoto = shoesPhoto;
        ShoesNameArrayList = shoesNameArrayList;
        ShoesTypeArrayList = shoesTypeArrayList;
        this.ratingArrayList = ratingArrayList;
        this.priceArrayList = priceArrayList;
    }

    @NonNull
    @Override
    public womenShoesRecyclerAdapter.RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.women_shoes_recycler_row, parent, false);
        return new RowHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull womenShoesRecyclerAdapter.RowHolder holder, int position) {
        holder.womanShoesPhotoView.setImageResource(ShoesPhoto.get(position));
        holder.ShoesName.setText(ShoesNameArrayList.get(position));
        holder.ShoesType.setText(ShoesTypeArrayList.get(position));
        holder.price.setText(priceArrayList.get(position));
        holder.rating.setText(ratingArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return ShoesNameArrayList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder{
        ImageView womanShoesPhotoView;
        TextView ShoesName, ShoesType, rating, price ;


        public RowHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            womanShoesPhotoView = itemView.findViewById(R.id.womanShoesPhotoView);
            ShoesName = itemView.findViewById(R.id.ShoesName);
            ShoesType = itemView.findViewById(R.id.ShoesType);
            rating = itemView.findViewById(R.id.rating);
            price = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });


        }
    }
}
