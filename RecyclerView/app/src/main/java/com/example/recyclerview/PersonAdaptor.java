package com.example.recyclerview;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdaptor extends RecyclerView.Adapter<PersonAdaptor.ViewHolder> {

    private ArrayList<Person> people;

    ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public PersonAdaptor (Context context, ArrayList<Person> list){
        people = list;
        activity = (ItemClicked) context;

    }

        // Represent every item in the list
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPic;
        TextView tvName, tvSurname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);
            ivPic = itemView.findViewById(R.id.ivPic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(people.indexOf((Person) v.getTag()));

                }
            });
        }
    }

    @NonNull
    @Override // Gets a connection to layout
    public PersonAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override // Runs for every item in the array list
    public void onBindViewHolder(@NonNull PersonAdaptor.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(people.get(i));
        viewHolder.tvName.setText(people.get(i).getName());
        viewHolder.tvSurname.setText(people.get(i).getSurname());
        if(people.get(i).getPreference().equals("bus")) {
            viewHolder.ivPic.setImageResource(R.drawable.bus);
        }
        else{
            viewHolder.ivPic.setImageResource(R.drawable.plane);
        }

    }




    @Override
    public int getItemCount() {
        return people.size();
    }
}
