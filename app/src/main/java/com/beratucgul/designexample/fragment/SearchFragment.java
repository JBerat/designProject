package com.beratucgul.designexample.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.beratucgul.designexample.ItemsModel;
import com.beratucgul.designexample.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {

    private SearchView searchView;
    ListView listView;
    TextView SearchItemNumber, SearchText;

    int images[] = {R.drawable.apple, R.drawable.googleplus, R.drawable.searchicon, R.drawable.heart, R.drawable.cashicon, R.drawable.truckicon};
    String desc[] = {"Apple", "Google", "Search", "Heart", "Cash", "Truck"};
    String price[] = {"4TL", "5TL", "8TL", "10TL", "0TL", "20TL"};



    List<ItemsModel> listItems = new ArrayList<>();

    CustomAdapter customAdapter;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        SearchItemNumber = view.findViewById(R.id.SearchItemNumber);
        SearchText = view.findViewById(R.id.SearchText);

        searchView = view.findViewById(R.id.searchView);
        searchView.setQueryHint("Search");

        //SearchItemNumber.setText(images.length + "");




      listView = view.findViewById(R.id.listview);

        setHasOptionsMenu(true);

      for(int i = 0; i < desc.length; i++) {
          ItemsModel itemsModel = new ItemsModel(images[i], desc[i], price[i]);

          listItems.add(itemsModel);
      }

      customAdapter = new CustomAdapter(listItems, this.getActivity());  // or getContext
      listView.setAdapter(customAdapter);
      listView.setTextFilterEnabled(true);


      setupSearchView();

        return view;
    }

    private void setupSearchView()
    {
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("Search Here");
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {



        SearchText.setText(newText);
        customAdapter.getFilter().filter(newText);
        return true;
    }


  /*  @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater = getActivity().getMenuInflater();

        inflater.inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.search_view);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                customAdapter.getFilter().filter(newText);

                return true;
            }
        });


        super.onCreateOptionsMenu(menu, inflater);

    }

   */



  /*  @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.search_view) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   */

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<ItemsModel> itemsModelList;
        private List<ItemsModel> itemsModelListFiltered;
        private Context context;

        public CustomAdapter(List<ItemsModel> itemsModelList, Context context) {
            this.itemsModelList = itemsModelList;
            this.itemsModelListFiltered = itemsModelList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemsModelListFiltered.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_items, null);

            ImageView imageView = view.findViewById(R.id.imageView);
            TextView itemDesc = view.findViewById(R.id.itemDesc);
            TextView itemPrice = view.findViewById(R.id.itemPrice);

            imageView.setImageResource(itemsModelListFiltered.get(position).getImage());
            itemDesc.setText(itemsModelListFiltered.get(position).getDesc());
            itemPrice.setText(itemsModelListFiltered.get(position).getPrice());

            return view;
        }

        @Override
        public Filter getFilter() {

            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {

                    FilterResults filterResults = new FilterResults();

                    if(constraint == null || constraint.length() == 0) {
                        filterResults.count = itemsModelList.size();
                        filterResults.values = itemsModelList;



                    }else {
                        String searchStr = constraint.toString().toLowerCase().trim();

                        List<ItemsModel> resultData = new ArrayList<>();


                        for(ItemsModel itemsModel: itemsModelList) {
                            if(itemsModel.getDesc().toLowerCase().contains(searchStr) ) {
                                resultData.add(itemsModel);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }


                    //   || itemsModel.getPrice().contains(searchStr)

                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {

                    itemsModelListFiltered = (List<ItemsModel>) results.values;

                    SearchItemNumber.setText(String.valueOf(results.count));

                    notifyDataSetChanged();
                }
            };

            return filter;
        }
    }


}
