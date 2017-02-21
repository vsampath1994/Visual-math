package com.example.suganya.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Select video source activity.
 *
 *
 */
public class Subvideo extends Activity implements OnClickListener {


    private Button playOnYouTubeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_subvideo);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/watch?v=Rnw5ixvU074"));
        this.startActivity(i);


    }

    @Override
    public void onClick(View v) {


    }
}
