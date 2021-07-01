package com.jalilasif.mc_jalilasif_192021.SQL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jalilasif.mc_jalilasif_192021.R;

import java.util.List;

public class SQLAdapter extends RecyclerView.Adapter<SQLAdapter.ViewHolder> {
    List<Hobby> hobbyList;
    Context context;

    public SQLAdapter(List<Hobby> hobbyList, Context context) {
        this.hobbyList = hobbyList;
        this.context = context;
    }

    @NonNull
    @Override
    public SQLAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SQLAdapter.ViewHolder holder, int position) {
        Hobby hobby = hobbyList.get(position);

        holder.txt_hobby.setText(hobby.getHobby());
        holder.txt_description.setText(hobby.getDescription());
    }

    @Override
    public int getItemCount()
    {
        return hobbyList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txt_hobby,txt_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_hobby = itemView.findViewById(R.id.t1);
            txt_description = itemView.findViewById(R.id.t2);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,hobbyList.get(getAdapterPosition()).getHobby(),Toast.LENGTH_LONG).show();
        }
    }
}



