package com.jalilasif.mc_jalilasif_192021.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.jalilasif.mc_jalilasif_192021.Model.fragmodel;
import com.jalilasif.mc_jalilasif_192021.Model.fragmodel2;
import com.jalilasif.mc_jalilasif_192021.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class fragadapter2 extends RecyclerView.Adapter<fragadapter2.ItemViewHolder>{

    private final ArrayList<fragmodel2> itemModelArrayList;


    public fragadapter2(ArrayList<fragmodel2>itemModelArrayList){
        this.itemModelArrayList = itemModelArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view2,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemViewHolder holder, int position) {
        fragmodel2 itemModel = itemModelArrayList.get(position);
        holder.title.setText(itemModel.getTitle());
        holder.description.setText(itemModel.getDescription());

        holder.deleteButton.setOnClickListener(v -> {

            itemModelArrayList.remove(position);

            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return itemModelArrayList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView description;
        private final ImageButton deleteButton;


        public ItemViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);

            deleteButton = itemView.findViewById(R.id.list_item_delete_button);
        }
    }
}
