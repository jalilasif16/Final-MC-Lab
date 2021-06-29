package com.jalilasif.mc_jalilasif_192021.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jalilasif.mc_jalilasif_192021.Adapter.fargadapter;
import com.jalilasif.mc_jalilasif_192021.Model.fragmodel;
import com.jalilasif.mc_jalilasif_192021.R;

import java.util.ArrayList;


public class fraghobby1 extends Fragment {



    public fraghobby1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fraghobby, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        ArrayList<fragmodel> hooby = new ArrayList<>();

        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Cricket", "Good for health"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Football", "Good for legs"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Reading", "Skills"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Singing", "love"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Outing", "Enjoyment"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new fargadapter(hooby));
        return view;

    }
}