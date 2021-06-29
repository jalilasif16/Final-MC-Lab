package com.jalilasif.mc_jalilasif_192021.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jalilasif.mc_jalilasif_192021.Model.User;
import com.jalilasif.mc_jalilasif_192021.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    List<User> studentList;
    Context context;

    public Adapter(List<User> studentList, Context context) {
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
       User student= studentList.get(position);
        holder.txtid.setText(student.getId());
        holder.txtname.setText(student.getName());
        holder.txtcity.setText(student.getCity());
        holder.txtage.setText(student.getAge());
    }

    @Override
    public int getItemCount()
    {
        return studentList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtid,txtname,txtcity,txtage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtid=itemView.findViewById(R.id.txt_1);
            txtname=itemView.findViewById(R.id.txt_2);
            txtcity=itemView.findViewById(R.id.txt_3);
            txtage=itemView.findViewById(R.id.txt_4);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,studentList.get(getAdapterPosition()).getName(),Toast.LENGTH_LONG);
        }
    }
}

