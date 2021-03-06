package com.example.suganya.myapplication;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class findnum extends ActionBarActivity implements View.OnClickListener{

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;


    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findnum);


        // tv.setText("HAI");
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        b10=(Button)findViewById(R.id.b10);
        changeNum();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_findnum, menu);
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

    @Override
    public void onClick(View v) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.applause);
        Button b = (Button)v;
        String number = b.getText().toString();
        if(Integer.parseInt(number)==num)
        {
            TextView tv4=(TextView)findViewById(R.id.ans);
            tv4.setText("CORRECT");
            tv4.setTextColor(Color.GREEN);
            mp.start();
            changeNum();

        }
        else{
            TextView tv4=(TextView)findViewById(R.id.ans);
            tv4.setText("WRONG");
            tv4.setTextColor(Color.RED);

            changeNum();
        }

    }
    public void changeNum()
    {
        Random r=new Random();
        TextView tv=(TextView)findViewById(R.id.num);
        TextView t=(TextView)findViewById(R.id.ans);


        int choice=r.nextInt(10);
        switch(choice)
        {            case 1:tv.setText("ONE");
            num=1;
            break;
            case 2:tv.setText("TWO");
                num=2;
                break;
            case 3:tv.setText("THREE");
                num=3;
                break;
            case 4:tv.setText("FOUR");
                num=4;
                break;
            case 5:tv.setText("FIVE");
                num=5;
                break;
            case 6:tv.setText("SIX");
                num=6;
                break;

            case 7:tv.setText("SEVEN");
                num=7;
                break;
            case 8:tv.setText("EIGHT");
                num=8;
                break;
            case 9:tv.setText("NINE");
                num=9;
                break;
            case 0:tv.setText("ZERO");
                num=0;
                break;
        }
        int a=r.nextInt(10);
        b1.setText(String.valueOf((10+a)%10));
        b2.setText(String.valueOf((14+a)%10));
        b3.setText(String.valueOf((11+a)%10));
        b4.setText(String.valueOf((16+a)%10));
        b5.setText(String.valueOf((18+a)%10));
        b6.setText(String.valueOf((17+a)%10));
        b7.setText(String.valueOf((13+a)%10));
        b8.setText(String.valueOf((12+a)%10));
        b9.setText(String.valueOf((19+a)%10));
        b10.setText(String.valueOf((15+a)%10));
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);

    }
}