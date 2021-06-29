package com.jalilasif.mc_jalilasif_192021.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.jalilasif.mc_jalilasif_192021.Database.DatabaseHelper;
import com.jalilasif.mc_jalilasif_192021.R;

public class Input extends Fragment {
    EditText edt_id,edt_name,edt_city,edt_age;
    Button btn_save,btn_view;
    DatabaseHelper sqliteDB_helper;
    public Input() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_input, container, false);
        edt_id=view.findViewById(R.id.edt_id);
        edt_name=view.findViewById(R.id.edt_name);
        edt_city=view.findViewById(R.id.edt_city);
        edt_age=view.findViewById(R.id.edt_age);
        btn_save=view.findViewById(R.id.btn_save);
        btn_view=view.findViewById(R.id.btn_view);
        sqliteDB_helper = new DatabaseHelper(getContext());
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id= edt_id.getText().toString();
                String name= edt_name.getText().toString();
                String city= edt_city.getText().toString();
                String age= edt_age.getText().toString();
                boolean checkSaved= sqliteDB_helper.insertData(id,name,city,age);
                if(checkSaved==true){
                    Toast.makeText(getContext(),"saved successfully",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(),"Not Saved",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new Output()).commit();
            }
        });
        return view;
    }
}