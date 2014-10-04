package com.maxfangx.bearlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;


public class SignUp extends Activity implements View.OnClickListener {

    Button sendButton;
    EditText name;
    EditText email;
    EditText password;
    EditText passwordagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sendButton = (Button)findViewById(R.id.button);
        sendButton.setOnClickListener(this);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.pass);
        passwordagain = (EditText)findViewById(R.id.passagain);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sign_up, menu);
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
<<<<<<< HEAD
        if (password.equals(passwordagain)) {
=======
        if (password.getText().toString().equals(passwordagain.getText().toString())) {
>>>>>>> Activity-Switching
            ParseUser user = new ParseUser();
            user.setUsername(name.getText().toString());
            user.setPassword(password.getText().toString());
            user.setEmail(email.getText().toString());

// other fields can be set just like with ParseObject
            //user.put("phone", "650-555-0000");

            user.signUpInBackground(new SignUpCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        // Hooray! Let them use the app now.
                    } else {
                        // Sign up didn't succeed. Look at the ParseException
                        // to figure out what went wrong
                    }
                }

                @Override
                public void done(com.parse.ParseException e) {

                }
            });
            Intent catalog = new Intent(getApplicationContext(), catalog.class);
            catalog.putExtra("name", name.getText().toString());
            catalog.putExtra("email", email.getText().toString());
            catalog.putExtra("pass", password.getText().toString());
            startActivity(catalog);
        }
        else    {
            Toast.makeText(this, "Sorry, your password doesn't match.", Toast.LENGTH_SHORT).show();
        }
    }
}
