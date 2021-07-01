package com.jalilasif.mc_jalilasif_192021.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jalilasif.mc_jalilasif_192021.Model.Data;
import com.jalilasif.mc_jalilasif_192021.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Data> studentList;
    Context context;

    public RecyclerViewAdapter(List<Data> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data student = studentList.get(position);
        holder.txt_id.setText(student.getId());
        holder.txt_name.setText(student.getName());
        holder.txt_city.setText(student.getCity());
        holder.txt_age.setText(student.getAge());
    }

    @Override
    public int getItemCount()
    {
        return studentList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txt_id,txt_name,txt_city,txt_age;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_id=itemView.findViewById(R.id.t1);
            txt_name=itemView.findViewById(R.id.t2);
            txt_city=itemView.findViewById(R.id.t3);
            txt_age=itemView.findViewById(R.id.t4);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,studentList.get(getAdapterPosition()).getName(),Toast.LENGTH_LONG).show();
        }
    }
}