package com.dola.incubatorpro;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private SharedPreferenceConfg preferenceConfg;

    EditText editTextPhone, editTextCode;
    public String Admin = "01065155977";

    FirebaseAuth mAuth;

    String codeSent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        editTextCode = findViewById(R.id.editTextCode);
        editTextPhone = findViewById(R.id.editTextPhone);

        preferenceConfg = new SharedPreferenceConfg(getApplicationContext());

        if(preferenceConfg.readLoginStatus()){
            if (editTextPhone.getText().toString().equals(Admin)) {
                Intent intent = new Intent(MainActivity.this, AdminIncubatorView.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Admin Mode", Toast.LENGTH_LONG).show();
                finish();
            }
            else {
                Intent intent = new Intent(MainActivity.this, UserIncubatorView.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "User Mode", Toast.LENGTH_LONG).show();
                finish();
            }

        }

        findViewById(R.id.buttonGetVerificationCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendVerficationCode();


            }
        });

        findViewById(R.id.buttonSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifySignInCode();
            }
        });
    }


    private void verifySignInCode() {
        String code = editTextCode.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signInWithPhoneAuthCredential(credential);
    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            //you can open a new activity here
                            if (editTextPhone.getText().toString().equals(Admin)) {
                                Intent intent = new Intent(MainActivity.this, AdminIncubatorView.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "Admin Mode", Toast.LENGTH_LONG).show();
                                preferenceConfg.writeLoginStatus(true);
                                finish();
                            } else  {
                                Intent intent = new Intent(MainActivity.this, UserIncubatorView.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "User Mode", Toast.LENGTH_LONG).show();
                                preferenceConfg.writeLoginStatus(true);
                                finish();
                            }
                        }
                        else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(getApplicationContext(), "Incorrect Verification code", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                });
    }

    private void sendVerficationCode() {
        String phone = editTextPhone.getText().toString();
        if (phone.isEmpty()) //
        {
            editTextPhone.setError("phone number is required");
            editTextPhone.requestFocus();
            return;
        }
        if (phone.length() < 10) {
            editTextPhone.setError("please enter a valid phone");
            editTextPhone.requestFocus();
            return;
        }


        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,                       // Phone number to verify
                60,                      // Timeout duration
                TimeUnit.SECONDS,          // Unit of timeout
                this,              // Activity (for callback binding)
                mCallbacks);              // OnVerificationStateChangedCallbacks
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {


        }

        @Override
        public void onVerificationFailed(FirebaseException e) {


        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeSent = s;
        }
    };
}


