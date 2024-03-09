package com.example.taotoon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class activity_login extends AppCompatActivity {
    private EditText useredit, passedit;
    private Button btnlogin, btnregister, btnThoat;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        useredit = findViewById(R.id.dangnhap);
        passedit = findViewById(R.id.matkhau);
        btnlogin = findViewById(R.id.btnlogin);
        btnThoat=findViewById(R.id.btnthoat);
        btnregister = findViewById(R.id.btnregister);
        mAuth = FirebaseAuth.getInstance();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }

        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_login.this,activity_register.class);
                startActivity(intent);
            }


        });
    }


    private void login() {
        String user, pass;
        user = useredit.getText().toString();
        pass = passedit.getText().toString();
        if(TextUtils.isEmpty(user)){
            Toast.makeText(this,"Insert User",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Insert Password",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Login Correct",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_login.this,MainActivity.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Login Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void Thoat(View view) {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
