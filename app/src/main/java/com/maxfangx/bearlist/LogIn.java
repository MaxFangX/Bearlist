package com.maxfangx.bearlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;


public class LogIn extends Activity implements View.OnClickListener {

    Button loginButton;
    Button newuser;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Parse.initialize(this, "5mjHRFGROrSdvWPcmoQTh5bQtclikW02ZESfPfgh", "AtfQuYeDHeWnfUQNnmCbB8IBCC5FtlD8NoROVIe0");
        Parse.initialize(this,"0DjH3hlL03Nf8neV0qBuG8LfgzrGx6xZBOSN8zwi", "QkfdyELcub7wzIBHkzxCv6tKrUFAjmx5Rl63iZiP");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        loginButton = (Button)findViewById(R.id.button);
        loginButton.setOnClickListener(this);
        newuser = (Button)findViewById(R.id.signup);
        newuser.setOnClickListener(this);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.pass);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                ParseUser.logInInBackground(email.getText().toString(), password.getText().toString(), new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            // Hooray! The user is logged in.
                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                        }
                    }

                    @Override
                    public void done(ParseUser parseUser, com.parse.ParseException e) {

                    }
                });
                Intent catalog = new Intent(getApplicationContext(), catalog.class);
                catalog.putExtra("email", email.getText().toString());
                catalog.putExtra("pass", password.getText().toString());
                startActivity(catalog);
            break;
            case R.id.signup:
                Intent sign = new Intent(getApplicationContext(), SignUp.class);
                startActivity(sign);
            break;
        }
    }
}
