package com.jalilasif.mc_jalilasif_192021.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.jalilasif.mc_jalilasif_192021.DashboardActivity;
import com.jalilasif.mc_jalilasif_192021.R;


public class SignIn extends AppCompatActivity {

    Button signIn,signUp;
    EditText edt1,edt2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signIn = findViewById(R.id.btnSignIn);
        signUp = findViewById(R.id.btnSignUp);
        edt1=findViewById(R.id.SI_edt_email);
        edt2=findViewById(R.id.SI_edt_pass);


        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                loginAccount();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignIn.this, SignUp.class);
                startActivity(i);
            }
        });


    }

    void loginAccount()
    {
        String Email;
        String password;
        Email = edt1.getText().toString().trim();
        password = edt2.getText().toString();
        mAuth.signInWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignIn.this, DashboardActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}