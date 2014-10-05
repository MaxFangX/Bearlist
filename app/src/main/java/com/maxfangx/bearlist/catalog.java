package com.maxfangx.bearlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.text.ParseException;
import java.util.List;


public class catalog extends Activity implements View.OnClickListener {

    //TextView catalogname;
    TextView catalogemail;
    TextView catalogpass;
    Button postbutton;
    ListView postlist;
    ParseQueryAdapter<ParseObject> mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        ParseQueryAdapter<ParseObject> mainAdapter = new ParseQueryAdapter<ParseObject>(this, "Todo");
//        mainAdapter.setTextKey("title");
//        mainAdapter.setImageKey("image");

// Set the ListActivity's adapter to be the PQA
//        setListAdapter(mainAdapter);
//        Parse.initialize(this, "0DjH3hlL03Nf8neV0qBuG8LfgzrGx6xZBOSN8zwi", "QkfdyELcub7wzIBHkzxCv6tKrUFAjmx5Rl63iZiP");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        //catalogname = (TextView)findViewById(R.id.catalogname);
        catalogemail = (TextView)findViewById(R.id.catalogemail);
        catalogpass = (TextView)findViewById(R.id.catalogpassword);
        postbutton = (Button)findViewById(R.id.postbutton);
        postbutton.setOnClickListener(this);
        postlist = (ListView)findViewById(R.id.postlist);

//        ParseQuery<ParseObject> query = ParseQuery.getQuery("post");
//        System.out.println("PARSE QUERY THROUGH");
//        query.findInBackground(new FindCallback<ParseObject>() {
//            public void done(List<ParseObject> postlist, ParseException e) {
//                if (e == null) {
//                    Log.d("posts", "retrieved" + postlist.size() + "scores");
//                    System.out.println(postlist);
//                    System.out.println("TALK TO ME GOOSE");
//                } else {
//                    Log.d("score", "Error: " + e.getMessage());
//                    System.out.println(postlist + "     " + e.getMessage());
//                }
//            }
//
//            @Override
//            public void done(List<ParseObject> parseObjects, com.parse.ParseException e) {
//
//            }
//        });
        // Instantiate a QueryFactory to define the ParseQuery to be used for fetching items in this
        // Adapter.
        ParseQueryAdapter.QueryFactory<ParseObject> factory =
                new ParseQueryAdapter.QueryFactory<ParseObject>() {
                    public ParseQuery create() {
                        ParseQuery query = new ParseQuery("post");
                        return query;
                    }
                };

        // Pass the factory into the ParseQueryAdapter's constructor.
        ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<ParseObject>(this, factory);
        adapter.setTextKey("name");

        // Perhaps set a callback to be fired upon successful loading of a new set of ParseObjects.
        adapter.addOnQueryLoadListener(new ParseQueryAdapter.OnQueryLoadListener<ParseObject>() {
            public void onLoading() {
                // Trigger any "loading" UI
            }

            @Override
            public void onLoaded(List<ParseObject> parseObjects, Exception e) {

            }

            public void onLoaded(List<ParseObject> objects, ParseException e) {
                // Execute any post-loading logic, hide "loading" UI
            }
        });

        // Attach it to your ListView, as in the example above
        ParseQueryAdapter adap = new ParseQueryAdapter(this, "post");
        adapter.setTextKey("name");
        postlist.setAdapter(adap);

        Intent i = getIntent();
        //String name = i.getStringExtra("name");
        String email = i.getStringExtra("email");
        String pass = i.getStringExtra("pass");

        //catalogname.setText(name);
        catalogemail.setText(email);
        catalogpass.setText(pass);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.catalog, menu);
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
        Intent post = new Intent(getApplicationContext(), PostPage.class);
        startActivity(post);
    }
}
