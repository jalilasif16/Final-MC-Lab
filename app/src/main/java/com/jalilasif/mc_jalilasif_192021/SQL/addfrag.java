package com.jalilasif.mc_jalilasif_192021.SQL;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.jalilasif.mc_jalilasif_192021.R;


public class addfrag extends Fragment {
    EditText t_hobby,t_description;
    Button btn_s,btn_v;
    HobbyRecordDatabase sqliteDB_helper;

    public addfrag() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_addfrag, container, false);
        t_hobby=view.findViewById(R.id.edt_hobby);
        t_description=view.findViewById(R.id.edt_description);
        btn_s=view.findViewById(R.id.btn_save);
        btn_v=view.findViewById(R.id.btn_view);
        sqliteDB_helper = new HobbyRecordDatabase(getContext());

        btn_s.setOnClickListener(v -> {
            String hobby = t_hobby.getText().toString();
            String description = t_description.getText().toString();

            boolean checkSaved= sqliteDB_helper.insertHobby(hobby,description);
            if(checkSaved){
                Toast.makeText(getContext(),"Saved Successfully",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getContext(),"Not Saved",Toast.LENGTH_SHORT).show();
            }
        });

        btn_v.setOnClickListener(v -> requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new viewfrag()).commit());

        return view;

    }
}