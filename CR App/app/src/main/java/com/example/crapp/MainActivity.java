package com.example.crapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword, txtConfirmPassword, txtName;
    Button btnSignUp;
    RadioButton radioCR, radioStudent;
    Boolean isCr = false;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String name;
    String email;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
        radioCR = (RadioButton) findViewById(R.id.rbCR);
        radioStudent = (RadioButton) findViewById(R.id.rbStudent);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);


        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = txtName.getText().toString().trim();
                email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String confirmPassword = txtConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(name)){
                    Toast.makeText(MainActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(MainActivity.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6){
                    Toast.makeText(MainActivity.this, "Please Enter password of 6 or more characters",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!email.matches(emailPattern)){
                    Toast.makeText(MainActivity.this, "Email Address is not Valid",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!password.equals(confirmPassword)){
                    Toast.makeText(MainActivity.this, "Password and Confirm Password don't Match",
                           Toast.LENGTH_SHORT).show();
                }

                if (password.equals(confirmPassword)){
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        boolean isCr = ((RadioButton) findViewById(R.id.rbCR)).isChecked();
                                        User user = new User(name,  email,  isCr);
                                        FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance()
                                                .getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(getApplicationContext(), SideBar.class));
                                                }
                                                else {
                                                    Toast.makeText(MainActivity.this, "Registration Failed",
                                                            Toast.LENGTH_SHORT).show();
                                                }

                                            }
                                        });
                                    } else {
                                        Toast.makeText(MainActivity.this, "Registration Failed",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }
            }
        });
    }

    public void crChecked(View view) {
        RadioButton student = findViewById( R.id.rbStudent);
        student.setChecked(false);
    }

    public void studentChecked(View view) {
        RadioButton cr = findViewById( R.id.rbCR);
        cr.setChecked(false);
    }

    public void signInNaviagate(View view){
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

}
