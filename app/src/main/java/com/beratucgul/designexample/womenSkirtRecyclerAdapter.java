package com.beratucgul.designexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class womenSkirtRecyclerAdapter extends RecyclerView.Adapter<womenSkirtRecyclerAdapter.RowHolder> {

    ArrayList<Integer> skirtPhoto;
    ArrayList<String> skirtNameArrayList;
    ArrayList<String> skirtTypeArrayList;
    ArrayList<String> ratingArrayList;
    ArrayList<String> priceArrayList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public womenSkirtRecyclerAdapter(ArrayList<Integer> skirtPhoto, ArrayList<String> skirtNameArrayList, ArrayList<String> skirtTypeArrayList, ArrayList<String> ratingArrayList, ArrayList<String> priceArrayList) {
        this.skirtPhoto = skirtPhoto;
        this.skirtNameArrayList = skirtNameArrayList;
        this.skirtTypeArrayList = skirtTypeArrayList;
        this.ratingArrayList = ratingArrayList;
        this.priceArrayList = priceArrayList;
    }

    @NonNull
    @Override
    public womenSkirtRecyclerAdapter.RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.women_skirt_recycler_row, parent, false);
        return new RowHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull womenSkirtRecyclerAdapter.RowHolder holder, int position) {

        holder.womanSkirtPhotoView.setImageResource(skirtPhoto.get(position));
        holder.SkirtName.setText(skirtNameArrayList.get(position));
        holder.SkirtType.setText(skirtTypeArrayList.get(position));
        holder.rating.setText(ratingArrayList.get(position));
        holder.price.setText(priceArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return skirtNameArrayList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder{

        ImageView womanSkirtPhotoView;
        TextView SkirtName, SkirtType, rating, price;

        public RowHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            womanSkirtPhotoView = itemView.findViewById(R.id.womanSkirtPhotoView);
            SkirtName = itemView.findViewById(R.id.SkirtName);
            SkirtType = itemView.findViewById(R.id.SkirtType);
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
