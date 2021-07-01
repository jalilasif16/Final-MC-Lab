package com.jalilasif.mc_jalilasif_192021.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jalilasif.mc_jalilasif_192021.Adapter.RecyclerViewAdapter;
import com.jalilasif.mc_jalilasif_192021.DashboardActivity;
import com.jalilasif.mc_jalilasif_192021.Database.DatabaseHelper;
import com.jalilasif.mc_jalilasif_192021.MapsActivity;
import com.jalilasif.mc_jalilasif_192021.Model.Data;
import com.jalilasif.mc_jalilasif_192021.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Data> student_list = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerviewadapter;
    EditText t_id,t_name,t_city,t_age;
    Button btn_s,btn_v;
   DatabaseHelper sqliteDB_helper;
    String allRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t_id=findViewById(R.id.edt_id);
        t_name=findViewById(R.id.edt_name);
        t_city=findViewById(R.id.edt_city);
        t_age=findViewById(R.id.edt_age);
        btn_s=findViewById(R.id.btn_save);
        btn_v=findViewById(R.id.btn_view);
        sqliteDB_helper = new DatabaseHelper(this);
        recyclerView= findViewById(R.id.recycler192021);

        btn_s.setOnClickListener(v -> {
            String id= t_id.getText().toString();
            String name= t_name.getText().toString();
            String city= t_city.getText().toString();
            String age= t_age.getText().toString();

            boolean checkSaved= sqliteDB_helper.insertData(id,name,city,age);
            if(checkSaved){
                Toast.makeText(MainActivity.this,"Saved Successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            }
            else{
                Toast.makeText(MainActivity.this,"Not Saved",Toast.LENGTH_SHORT).show();
            }
        });

        btn_v.setOnClickListener(v -> viewDataOnTextView());
    }

    public  void viewDataOnTextView(){
        allRecords="";
        Cursor eachRecord_cursor =sqliteDB_helper.getStudentData();

        if (eachRecord_cursor.getCount()==0)
        {
            Toast.makeText(this,"No record found!",Toast.LENGTH_SHORT).show();
            return;
        }

        while (eachRecord_cursor.moveToNext()){

            String id,name,city,age;
            id= eachRecord_cursor.getString(0) ;
            name=eachRecord_cursor.getString(1);
            city=eachRecord_cursor.getString(2);
            age=eachRecord_cursor.getString(3);
            student_list.add(new Data(id,name,city,age));

        }

        recyclerviewadapter = new RecyclerViewAdapter(student_list,MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerviewadapter);
    }
}