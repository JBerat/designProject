package com.beratucgul.designexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class addressRecyclerAdapter extends RecyclerView.Adapter<addressRecyclerAdapter.RowHolder> {

    ArrayList<Integer> addressUpdateList;
    ArrayList<Integer> addressDeleteList;
    ArrayList<String> addressTypeList;
    ArrayList<String> addressPersonNameList;
    ArrayList<String> addressPersonCityList;
    ArrayList<String> addressPersonLocationList;
    ArrayList<String> addressPersonDetailList;
    Button addressCurrentButton;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
        void onUpdateClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }



    public addressRecyclerAdapter(ArrayList<String> addressTypeList, ArrayList<String> addressPersonNameList, ArrayList<String> addressPersonCityList, ArrayList<String> addressPersonLocationList, ArrayList<String> addressPersonDetailList) {

        this.addressTypeList = addressTypeList;
        this.addressPersonNameList = addressPersonNameList;
        this.addressPersonCityList = addressPersonCityList;
        this.addressPersonLocationList = addressPersonLocationList;
        this.addressPersonDetailList = addressPersonDetailList;

    }

    @NonNull
    @Override
    public addressRecyclerAdapter.RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.my_address_recycler_row, parent, false);
        return new RowHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull addressRecyclerAdapter.RowHolder holder, int position) {
        holder.addressType.setText(addressTypeList.get(position));
        holder.addressPersonName.setText(addressPersonNameList.get(position));
        holder.addressPersonCity.setText(addressPersonCityList.get(position));
        holder.addressPersonLocation.setText(addressPersonLocationList.get(position));
        holder.addressPersonDetail.setText(addressPersonDetailList.get(position));



    }

    @Override
    public int getItemCount() {
        return addressTypeList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {

        TextView addressType, addressPersonName, addressPersonCity, addressPersonLocation, addressPersonDetail;
     //   ImageView addressUpdateView, addressDeleteView;
        Button addressCurrentButton;
        public ImageView mDeleteImage;
        public ImageView mUpdateImage;

        public RowHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            addressType = itemView.findViewById(R.id.addressType);
       //     addressUpdateView = itemView.findViewById(R.id.addressUpdateView);
         //   addressDeleteView = itemView.findViewById(R.id.addressDeleteView);
            addressPersonName = itemView.findViewById(R.id.addressPersonName);
            addressPersonCity = itemView.findViewById(R.id.addressPersonCity);
            addressPersonLocation = itemView.findViewById(R.id.addressPersonLocation);
            addressPersonDetail = itemView.findViewById(R.id.addressPersonDetail);
          //  addressCurrentButton = itemView.findViewById(R.id.addressCurrentButton);
            mDeleteImage = itemView.findViewById(R.id.addressDeleteView);
            mUpdateImage = itemView.findViewById(R.id.addressUpdateView);


            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
            mUpdateImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });

        }

    }
}
