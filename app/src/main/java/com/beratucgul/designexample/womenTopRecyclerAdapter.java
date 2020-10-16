package com.beratucgul.designexample;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class womenTopRecyclerAdapter extends RecyclerView.Adapter<womenTopRecyclerAdapter.RowHolder> {


    ArrayList<Integer> topPhoto;
    ArrayList<String> topNameArrayList;
    ArrayList<String> topTypeArrayList;
    ArrayList<String> ratingArrayList;
    ArrayList<String> priceArrayList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

        mListener = listener;

    }



    public womenTopRecyclerAdapter(ArrayList<Integer> topPhoto, ArrayList<String> topNameArrayList, ArrayList<String> topTypeArrayList, ArrayList<String> ratingArrayList, ArrayList<String> priceArrayList) {
        this.topPhoto = topPhoto;
        this.topNameArrayList = topNameArrayList;
        this.topTypeArrayList = topTypeArrayList;
        this.ratingArrayList = ratingArrayList;
        this.priceArrayList = priceArrayList;
    }

    @NonNull
    @Override
    public womenTopRecyclerAdapter.RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.women_top_recycler_row, parent, false);
        return new RowHolder(view, mListener);

    }


    @Override
    public void onBindViewHolder(@NonNull womenTopRecyclerAdapter.RowHolder holder, int position) {
        holder.womanTopPhotoView.setImageResource(topPhoto.get(position));
        holder.TopName.setText(topNameArrayList.get(position));
        holder.TopType.setText(topTypeArrayList.get(position));
        holder.price.setText(priceArrayList.get(position));
        holder.rating.setText(ratingArrayList.get(position));

    }

    @Override
    public int getItemCount() {

        return topNameArrayList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {

        ImageView womanTopPhotoView;
        TextView TopName, TopType, rating, price ;

        public RowHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            womanTopPhotoView = itemView.findViewById(R.id.womanTopPhotoView);
            TopName = itemView.findViewById(R.id.TopName);
            TopType = itemView.findViewById(R.id.TopType);
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
