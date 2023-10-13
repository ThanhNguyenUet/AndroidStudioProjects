package com.example.basic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;

import java.util.ArrayList;

public class RecyclerViewCustomAdapter extends RecyclerView.Adapter<RecyclerViewCustomAdapter.CountryViewHolder> {
    private ArrayList<String> countryNameList ;
    private ArrayList<String> detailsList ;
    private ArrayList<Integer> imageList ;

    private Context context;

    public RecyclerViewCustomAdapter(ArrayList<String> countryNameList, ArrayList<String> detailsList, ArrayList<Integer> imageList, Context context) {
        this.countryNameList = countryNameList;
        this.detailsList = detailsList;
        this.imageList = imageList;
        this.context = context;
    }

    // define creating layout of item & bind it to parent
    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_recyclerview_item, parent, false);
        return new CountryViewHolder(view);
    }

    // putting data to layout( deal with card view components )
    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.textViewCountryName.setText(countryNameList.get(position));
        holder.textViewDetails.setText(detailsList.get(position));
        holder.imageView.setImageResource(imageList.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    Toast.makeText(context, "You selected the United Kingdom", Toast.LENGTH_SHORT).show();
                } else if (position == 1){
                    Toast.makeText(context, "You selected the Germany", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Toast.makeText(context, "You selected the USA", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // specifies the number of data will be display
    @Override
    public int getItemCount() {
        return countryNameList.size();
    }

    // represent components in card design
    public class CountryViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewCountryName, textViewDetails;
        private ImageView imageView;

        private CardView cardView;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCountryName = itemView.findViewById(R.id.textViewCountryName);
            textViewDetails = itemView.findViewById(R.id.textViewDescription);
            imageView = itemView.findViewById(R.id.profile_image);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}

