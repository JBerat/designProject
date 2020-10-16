package com.beratucgul.designexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class payCartRecyclerAdapter extends RecyclerView.Adapter<payCartRecyclerAdapter.RowHolder> {

    ArrayList<Integer> payCartPhoto;
    ArrayList<String> fashionNameList;
    ArrayList<String> fashionTypeList;
    ArrayList<String> fashionSizeList;
    ArrayList<String> fashionSizeTypeList;
    ArrayList<String> fashionNumberList;
    ArrayList<String> fashionPriceList;
    ItemsTopModel itemsTopModel;
    ArrayList<ItemsTopModel> itemsTopModels;



      public payCartRecyclerAdapter(ArrayList<Integer> payCartPhoto, ArrayList<String> fashionNameList, ArrayList<String> fashionTypeList, ArrayList<String> fashionSizeTypeList, ArrayList<String> fashionPriceList) {
        this.payCartPhoto = payCartPhoto;
        this.fashionNameList = fashionNameList;
        this.fashionTypeList = fashionTypeList;
    //    this.fashionSizeList = fashionSizeList;
        this.fashionSizeTypeList = fashionSizeTypeList;
     //   this.fashionNumberList = fashionNumberList;
        this.fashionPriceList = fashionPriceList;
    }



    @NonNull
    @Override
    public payCartRecyclerAdapter.RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.pay_cart_recycler_row, parent, false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull payCartRecyclerAdapter.RowHolder holder, int position) {
        holder.addedPhotoImage.setImageResource(payCartPhoto.get(position));
        holder.addedFashionNameText.setText(fashionNameList.get(position));
        holder.addedFashionTypeText.setText(fashionTypeList.get(position));
     //   holder.addedFashionSize.setText(fashionSizeList.get(position));
        holder.addedFashionSizeType.setText(fashionSizeTypeList.get(position));
      //  holder.addedFashionNumber.setText(fashionNumberList.get(position));
        holder.totalItemPrice.setText(fashionPriceList.get(position));





    }

    @Override
    public int getItemCount() {
        return fashionNameList.size();

    }

    public class RowHolder extends RecyclerView.ViewHolder{

        ImageView addedPhotoImage;
        TextView addedFashionNameText, addedFashionTypeText, addedFashionSize, addedFashionSizeType, addedFashionNumber, totalItemPrice;

        public RowHolder(@NonNull View itemView) {
            super(itemView);

            addedPhotoImage = itemView.findViewById(R.id.addedPhotoImage);
            addedFashionNameText = itemView.findViewById(R.id.addedFashionNameText);
            addedFashionTypeText = itemView.findViewById(R.id.addedFashionTypeText);
            addedFashionSizeType = itemView.findViewById(R.id.addedFashionSizeType);
            totalItemPrice = itemView.findViewById(R.id.totalItemPrice);



        }

    }
}
