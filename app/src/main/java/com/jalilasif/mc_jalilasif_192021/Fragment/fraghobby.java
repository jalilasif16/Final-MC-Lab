package com.jalilasif.mc_jalilasif_192021.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jalilasif.mc_jalilasif_192021.Adapter.fargadapter;
import com.jalilasif.mc_jalilasif_192021.Model.fragmodel;
import com.jalilasif.mc_jalilasif_192021.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Map;


public class fraghobby extends Fragment {

    FirebaseAuth mAthu;
    DatabaseReference ref;



    public fraghobby() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fraghobby, container, false);

        mAthu = FirebaseAuth.getInstance();
        String uid = mAthu.getCurrentUser().getUid();

        ref = FirebaseDatabase.getInstance().getReference("Data");
        ref.child(uid).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {

                if(task.isSuccessful()){
                    Map<String, Object> map = (Map<String, Object>) task.getResult();

                    Toast.makeText(getContext(),map.get("hobbies").toString(),Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        ArrayList<fragmodel> hooby = new ArrayList<>();

        hooby.add(new fragmodel("Cricket", "Good for health"));
        hooby.add(new fragmodel("Football", "Good for legs"));
        hooby.add(new fragmodel("Reading", "Skills"));
        hooby.add(new fragmodel("Singing", "love"));
        hooby.add(new fragmodel("Outing", "Enjoyment"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new fargadapter(hooby));
        return view;

    }
}