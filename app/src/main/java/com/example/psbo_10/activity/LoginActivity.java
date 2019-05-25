/**
 * Author: Ravi Tamada
 * URL: www.androidhive.info
 * twitter: http://twitter.com/ravitamada
 */
package com.example.psbo_10.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.psbo_10.R;
import com.example.psbo_10.Model.User;
import com.example.psbo_10.Helper.PasswordUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends Activity {
    private static final String TAG = RegisterActivity.class.getSimpleName();
    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText inputPhone, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputPhone = (EditText) findViewById(R.id.phone);
        inputPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        // Session manager
        User.setCurrentUser(User.getCurrentUser());

        // Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        // Check if user is already logged in or not
        if( User.isLoggedIn() ) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
                mDialog.setMessage("Harap tunggu...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener(){

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot){

                        // Check whether or not user exists in db
                        if(dataSnapshot.child(inputPhone.getText().toString()).exists()) {

                            // Get user information
                            mDialog.dismiss();
                            User user = dataSnapshot.child(inputPhone.getText().toString()).getValue(User.class);
                            user.setPhone(inputPhone.getText().toString());

                            if (PasswordUtils.verifyPassword(inputPassword.getText().toString(), user.getPassword(), user.getSalt())) {
                                Toast.makeText(LoginActivity.this, "Login berhasil!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                                User.setCurrentUser(user);
                                finish();

                            } else {
                                Toast.makeText(LoginActivity.this, "Password Anda salah.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            mDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "Data Anda tidak ditemukan.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError){

                    }
                });

            }

        });

        // Link to Register Screen
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}