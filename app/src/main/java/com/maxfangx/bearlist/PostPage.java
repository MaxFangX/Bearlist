package com.maxfangx.bearlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseUser;

import org.w3c.dom.Text;

import static com.parse.ParseUser.getCurrentUser;


public class PostPage extends Activity implements View.OnClickListener {

    Button publishbutton;
    TextView title;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_page);
        publishbutton = (Button)findViewById(R.id.publishbutton);
        publishbutton.setOnClickListener(this);
        title = (TextView)findViewById(R.id.title);
        description = (TextView)findViewById(R.id.description);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.post_page, menu);
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
        ParseObject post = new ParseObject("post");
        post.put("title", title.getText().toString());
        post.put("description", description.getText().toString());
        post.put("author", getCurrentUser().getEmail().toString());
        post.saveInBackground();

        Intent catalog = new Intent(getApplicationContext(), catalog.class);
        startActivity(catalog);
    }
}
