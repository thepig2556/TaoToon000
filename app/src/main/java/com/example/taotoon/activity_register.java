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

public class activity_register extends AppCompatActivity {
    private EditText useredit, passedit;
    private Button btncreate, btnThoat, btnLogin;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        useredit = findViewById(R.id.dangnhap);
        passedit = findViewById(R.id.matkhau);
        btnThoat=findViewById(R.id.btnThoat);
        btnLogin=findViewById(R.id.btnLogin);
        btncreate = findViewById(R.id.btncreate);
        mAuth = FirebaseAuth.getInstance();

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }


        });
    }


    private void register() {
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
        mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Register Correct",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_register.this,activity_login.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Register Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void thoat(View view){
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_register.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Login(View view){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_register.this, activity_login.class);
                startActivity(intent);
            }
        });
    }
    }

