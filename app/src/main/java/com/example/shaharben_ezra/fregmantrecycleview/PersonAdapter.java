package com.example.shaharben_ezra.fregmantrecycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    public  interface ItemClicked{
        void OnItemClicked(int i );
    }
    private ArrayList<Person>people;

     ItemClicked itemClickListener;
//data cons
    public  PersonAdapter(Context context, ArrayList<Person>list){
        people=list;
         itemClickListener =(ItemClicked)context;

    }
    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    itemClickListener.OnItemClicked(people.indexOf((Person)v.getTag()));

                }
            });
        }
    }
    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout,viewGroup,false);

        return new ViewHolder(v);
    }
///run for every element
    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemView.setTag(people.get(i));
        viewHolder.tvName.setText(people.get(i).getName());

    }

    @Override
    public int getItemCount() {

        return people.size();
    }
}
