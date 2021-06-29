package com.jalilasif.mc_jalilasif_192021;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.jalilasif.mc_jalilasif_192021.Activity.MainActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText et1, et2, et3, et4;

    Button b1, b2, b3, b4;

    database g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.etname);
        et2 = findViewById(R.id.etuserName);
        et3 = findViewById(R.id.etpassword);
        b1 = findViewById(R.id.insert);
        b2 = findViewById(R.id.delete);
        b3 = findViewById(R.id.view);
        b4 = findViewById(R.id.update);

        g = new database(this);
        //g.getReadableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 = et1.getText().toString();
                String username1 = et2.getText().toString();
                String password1 = et3.getText().toString();

                if(name1.equals("") || username1.equals("") || password1.equals(""))
                {
                    Toast.makeText(MainActivity2.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Boolean i = g.insert_data(name1,username1,password1);
                    if(i==true)
                    {
                        Toast.makeText(MainActivity2.this, "Data inserted", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        Toast.makeText(MainActivity2.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                    }
                }

                et1.setText("");
                et2.setText("");
                et3.setText("");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = et2.getText().toString();

                Boolean i = g.delete_data(username);

                if(i==true)
                {
                    Toast.makeText(MainActivity2.this, "Deleted", Toast.LENGTH_SHORT).show();

                    et2.setText("");
                }

                else
                {
                    Toast.makeText(MainActivity2.this, "Not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor t = g.getinfo();

                if(t.getCount()==0){

                    Toast.makeText(MainActivity2.this, "No data found", Toast.LENGTH_SHORT).show();

                }

                StringBuffer buffer = new StringBuffer();

                while(t.moveToNext())

                {
                    buffer.append("Name :: " + t.getString(1)+"\n");
                    buffer.append("UserName :: " + t.getString(2)+"\n");
                    buffer.append("Password :: " + t.getString(3)+"\n\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);

                builder.setCancelable(true);
                builder.setTitle("SignUp Users Data");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name2 = et1.getText().toString();
                String username2 = et2.getText().toString();
                String password2 = et3.getText().toString();


                Boolean i = g.update_data(name2,username2,password2);

                if(i==true)
                {
                    Toast.makeText(MainActivity2.this, "Updated", Toast.LENGTH_SHORT).show();

                    et2.setText("");
                }

                else
                {
                    Toast.makeText(MainActivity2.this, "Not updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}