package com.jalilasif.mc_jalilasif_192021.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;
import com.jalilasif.mc_jalilasif_192021.Model.User;
import com.jalilasif.mc_jalilasif_192021.R;

import java.util.Objects;

public class SignUp extends AppCompatActivity {
    EditText name,edt1,edt2;
    Button btnSubmit;
    Button btn2;
    RadioGroup rg;
    RadioButton rb;
    private FirebaseAuth mAuth;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=findViewById(R.id.Name);
        edt1=findViewById(R.id.edt_email);
        edt2=findViewById(R.id.edt_pass);
        myRef= FirebaseDatabase.getInstance().getReference("Data");

        btnSubmit = (Button) findViewById(R.id.btnSignIn2);
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, MainActivity.class);
                startActivity(i);
            }
        });
        rg=findViewById(R.id.edtGender);
        btn2= (Button) findViewById(R.id.btnSignUp);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createaccount();
            }
        });
    }
    void createaccount()
    {
        String Name = name.getText().toString();
        String Email = edt1.getText().toString().trim();
        String Password = edt2.getText().toString();

        int rid = rg.getCheckedRadioButtonId();

        rb = findViewById(rid);

        String gender = rb.getText().toString();



        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                   User user = new User(Name, Email, Password, gender);

                    String userId = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
                    myRef.child(userId).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Data is inserted in real time database", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            }


                        }
                    });

                    Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
