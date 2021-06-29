package com.jalilasif.mc_jalilasif_192021.Fragment;

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

import com.jalilasif.mc_jalilasif_192021.Adapter.Adapter;
import com.jalilasif.mc_jalilasif_192021.Database.DatabaseHelper;
import com.jalilasif.mc_jalilasif_192021.Model.User;
import com.jalilasif.mc_jalilasif_192021.R;

import java.util.ArrayList;
import java.util.List;

public class Output extends Fragment {
    List<User> studentlist = new ArrayList<>();
    RecyclerView RV;
    Adapter adapter;
    Button btn_save, btn_view;
    DatabaseHelper sqliteDB_helper;
    public Output() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_output, container, false);
        RV = view.findViewById(R.id.recyclerview);
        btn_save = view.findViewById(R.id.btn_add);
        btn_view = view.findViewById(R.id.btn_v);
        sqliteDB_helper = new DatabaseHelper(getContext());
        viewDataOnTextView();
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDataOnTextView();
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new Input()).commit();
            }
        });
        return view;
    }
    public void viewDataOnTextView() {
        Cursor eachRecord_cursor = sqliteDB_helper.getStudentData();
        if (eachRecord_cursor.getCount() == 0) {
            Toast.makeText(getContext(), "No record", Toast.LENGTH_SHORT).show();
            return;
        }
        while (eachRecord_cursor.moveToNext()) {
            String id, name, city, age;
            id = eachRecord_cursor.getString(0);
            name = eachRecord_cursor.getString(1);
            city = eachRecord_cursor.getString(2);
            age = eachRecord_cursor.getString(3);
            studentlist.add(new User(id, name, city, age));
            adapter = new Adapter(studentlist, getContext());
            RV.setLayoutManager(new LinearLayoutManager(getContext()));
            RV.setHasFixedSize(true);
            RV.setAdapter(adapter);
        }
    }
}