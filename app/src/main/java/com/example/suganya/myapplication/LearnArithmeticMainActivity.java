package com.example.suganya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LearnArithmeticMainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Choose language
        setContentView(R.layout.activity_learnarithmeticmain);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void add(View v)

    {
        Intent i=new Intent(getApplicationContext(),Addvideo.class);
        startActivity(i);
    }
    public void sub(View v){
        Intent i=new Intent(getApplicationContext(),Subvideo.class);
        startActivity(i);
    }
     public void mul(View v)

    {
        Intent i=new Intent(getApplicationContext(),Mulvideo.class);
        startActivity(i);
    }
    public void div(View v){
        Intent i=new Intent(getApplicationContext(),Divvideo.class);
        startActivity(i);
    }
    

}
