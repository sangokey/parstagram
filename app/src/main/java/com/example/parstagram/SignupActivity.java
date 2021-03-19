package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivity";

    private EditText etUsernames;
    private EditText etPasswords;
    private Button btnSignups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsernames = findViewById(R.id.etUsernames);
        etPasswords = findViewById(R.id.etPasswords);
        btnSignups = findViewById(R.id.btnSignup);

        // Create the ParseUser
        ParseUser user = new ParseUser();

        btnSignups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set core properties
                user.setUsername(etUsernames.getText().toString());
                user.setPassword(etPasswords.getText().toString());

                // Invoke signUpInBackground
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            goLoginActivity();
                            Toast.makeText(SignupActivity.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e(TAG, "Issue with sign up", e);
                            Toast.makeText(SignupActivity.this, "Issue with sign up!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
            }
        });
    }

    private void goLoginActivity() {
        ParseUser.logOut();
        ParseUser currentUser = ParseUser.getCurrentUser();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}