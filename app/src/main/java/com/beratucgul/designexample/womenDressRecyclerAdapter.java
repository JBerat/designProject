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

public class womenDressRecyclerAdapter extends RecyclerView.Adapter<womenDressRecyclerAdapter.RowHolder> {

    ArrayList<Integer> dressPhoto;
    ArrayList<String> dressNameArrayList;
    ArrayList<String> dressTypeArrayList;
    ArrayList<String> ratingArrayList;
    ArrayList<String> priceArrayList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }


    public womenDressRecyclerAdapter(ArrayList<Integer> dressPhoto, ArrayList<String> dressNameArrayList, ArrayList<String> dressTypeArrayList, ArrayList<String> ratingArrayList, ArrayList<String> priceArrayList) {
        this.dressPhoto = dressPhoto;
        this.dressNameArrayList = dressNameArrayList;
        this.dressTypeArrayList = dressTypeArrayList;
        this.ratingArrayList = ratingArrayList;
        this.priceArrayList = priceArrayList;
    }

    @NonNull
    @Override
    public womenDressRecyclerAdapter.RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.women_dress_recycler_row, parent, false);
        return new RowHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull womenDressRecyclerAdapter.RowHolder holder, int position) {
        holder.womanDressPhotoView.setImageResource(dressPhoto.get(position));
        holder.dressName.setText(dressNameArrayList.get(position));
        holder.dressType.setText(dressTypeArrayList.get(position));
        holder.rating.setText(ratingArrayList.get(position));
        holder.price.setText(priceArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return dressNameArrayList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {

        ImageView womanDressPhotoView;
        TextView dressName, dressType, rating, price;

        public RowHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            womanDressPhotoView = itemView.findViewById(R.id.womanDressPhotoView);
            dressName = itemView.findViewById(R.id.dressName);
            dressType = itemView.findViewById(R.id.dressType);
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
