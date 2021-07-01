package com.jalilasif.mc_jalilasif_192021.SQL;


import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jalilasif.mc_jalilasif_192021.R;

import java.util.ArrayList;
import java.util.List;

public class viewfrag extends Fragment {

    List<Hobby> hobby_list= new ArrayList<>();
    RecyclerView recyclerView;
    SQLAdapter recyclerviewadapter;
    Button btn_s,btn_v;
    HobbyRecordDatabase sqliteDB_helper;

    public viewfrag() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_viewfrag, container, false);
        recyclerView= view.findViewById(R.id.recycler192021);
        btn_s=view.findViewById(R.id.btn_add);
        btn_v=view.findViewById(R.id.btn_v);
        sqliteDB_helper = new HobbyRecordDatabase(getContext());
        viewDataOnTextView();
        btn_v.setOnClickListener(v -> viewDataOnTextView());

        btn_s.setOnClickListener(v -> requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new addfrag()).commit());

        return view;
    }
    public  void viewDataOnTextView(){

        Cursor eachRecord_cursor = sqliteDB_helper.getHobby();
        if (eachRecord_cursor.getCount()==0){
            Toast.makeText(getContext(),"No Record",Toast.LENGTH_SHORT).show();
            return;
        }
        while (eachRecord_cursor.moveToNext()){

            String hobby, description;
            hobby = eachRecord_cursor.getString(0) ;
            description =eachRecord_cursor.getString(1);
            hobby_list.add(new Hobby(hobby,description));

            recyclerviewadapter = new SQLAdapter(hobby_list, getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(recyclerviewadapter);
        }
    }
}