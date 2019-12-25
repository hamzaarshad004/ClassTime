package com.example.crapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText txtEmail, txtPassword;
    Button btnSignIn;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                firebaseAuth = FirebaseAuth.getInstance();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(LoginActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6){
                    Toast.makeText(LoginActivity.this, "Please Enter password of 6 or more characters",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!email.matches(emailPattern)){
                    Toast.makeText(LoginActivity.this, "Email Address is not Valid",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                  startActivity(new Intent(getApplicationContext(), SideBar.class));
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login Failed or User not exists", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });
    }

    public void signUpNaviagate(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
