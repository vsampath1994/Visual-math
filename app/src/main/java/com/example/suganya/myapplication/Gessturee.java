package com.example.suganya.myapplication;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


public class Gessturee extends ActionBarActivity implements TextToSpeech.OnInitListener,GestureOverlayView.OnGesturePerformedListener{

    private GestureLibrary gesLib;
    TextView NextLetter;
    TextView Name;
    TextToSpeech tts;
    int i=0,j=0,k=0,l=0;
    Prediction prediction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        tts = new TextToSpeech(this,this);
        tts.setLanguage(Locale.UK);
        NextLetter  = (TextView)findViewById(R.id.textView1);
        Name = (TextView)findViewById(R.id.textView2);
        gesLib = GestureLibraries.fromRawResource(this, R.raw.expressions);
        if (!gesLib.load()) {
            finish();
        }

        GestureOverlayView overlay = (GestureOverlayView) findViewById(R.id.gesture_area);
        GestureOverlayView overlay1 = (GestureOverlayView) findViewById(R.id.gesture_area1);
        overlay.addOnGesturePerformedListener(this);
        overlay1.addOnGesturePerformedListener(this);

    }

    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture)
    {
        ArrayList<Prediction> predictions = gesLib.recognize(gesture);
        prediction = predictions.get(0);
        NextLetter.setText(prediction.name);
        Name.append(prediction.name);
        j=Integer.parseInt(prediction.name);
        //tts.speak("zero", TextToSpeech.QUEUE_FLUSH,null);
        if(overlay.getId()==R.id.gesture_area1)
        {
            switch (j) {
                case 0:
                    if (k == 0) {
                        overlay.setBackgroundResource(R.drawable.one);
                        tts.speak("one", TextToSpeech.QUEUE_FLUSH,null);
                        k = 1;
                    } else {
                        Toast.makeText(this, "Draw properly", Toast.LENGTH_SHORT).show();
                        tts.speak("Please draw properly", TextToSpeech.QUEUE_FLUSH, null);
                    }
                    break;
                case 1:
                    if (k == 1) {
                        overlay.setBackgroundResource(R.drawable.two);
                        tts.speak("two", TextToSpeech.QUEUE_FLUSH, null);
                        k = 2;
                    } else {
                        Toast.makeText(this, "Draw properly", Toast.LENGTH_SHORT).show();
                        tts.speak("Please draw properly", TextToSpeech.QUEUE_FLUSH, null);
                    }
                    break;
                case 2:
                    if (k == 2) {
                        overlay.setBackgroundResource(R.drawable.three);
                        tts.speak("three", TextToSpeech.QUEUE_FLUSH, null);
                        k = 3;
                    } else {
                        Toast.makeText(this, "Draw properly", Toast.LENGTH_SHORT).show();
                        tts.speak("Please draw properly", TextToSpeech.QUEUE_FLUSH, null);
                    }
                    break;
                case 3:
                    if (k == 3) {
                        overlay.setBackgroundResource(R.drawable.four);
                        tts.speak("four", TextToSpeech.QUEUE_FLUSH, null);
                        k = 4;
                    } else {
                        Toast.makeText(this, "Draw properly", Toast.LENGTH_SHORT).show();
                        tts.speak("Please draw properly", TextToSpeech.QUEUE_FLUSH, null);
                    }
                    break;
                case 4:
                    if (k == 4) {
                        overlay.setBackgroundResource(R.drawable.five);
                        tts.speak("five", TextToSpeech.QUEUE_FLUSH, null);
                        k = 5;
                    } else {
                        Toast.makeText(this, "Draw properly", Toast.LENGTH_SHORT).show();
                        tts.speak("Please draw properly", TextToSpeech.QUEUE_FLUSH, null);
                    }
                    break;
                case 5:
                    if (k == 5) {
                        overlay.setBackgroundResource(R.drawable.six);
                        tts.speak("six", TextToSpeech.QUEUE_FLUSH, null);
                        k = 6;
                    } else {
                        Toast.makeText(this, "Draw properly", Toast.LENGTH_SHORT).show();
                        tts.speak("Please draw properly", TextToSpeech.QUEUE_FLUSH, null);
                    }
                    break;
                case 6:
                    if (k == 6) {
                        overlay.setBackgroundResource(R.drawable.seven);
                        tts.speak("seven", TextToSpeech.QUEUE_FLUSH, null);
                        k = 7;
                    } else {
                        Toast.makeText(this, "Draw properly", Toast.LENGTH_SHORT).show();
                        tts.speak("Please draw properly", TextToSpeech.QUEUE_FLUSH, null);
                    }
                    break;
                case 7:
                    if (k == 7) {
                        overlay.setBackgroundResource(R.drawable.eight);
                        tts.speak("eight", TextToSpeech.QUEUE_FLUSH, null);
                        k = 8;
                    } else {
                        Toast.makeText(this, "Draw properly", Toast.LENGTH_SHORT).show();
                        tts.speak("Please draw properly", TextToSpeech.QUEUE_FLUSH, null);
                    }
                    break;
                case 8:
                    if (k == 8) {
                        overlay.setBackgroundResource(R.drawable.nine);
                        tts.speak("nine", TextToSpeech.QUEUE_FLUSH, null);
                        k = 9;
                    } else {
                        Toast.makeText(this, "Draw properly", Toast.LENGTH_SHORT).show();
                        tts.speak("Please draw properly", TextToSpeech.QUEUE_FLUSH, null);
                    }
                    break;
                case 9:
                    if (k == 9) {
                        overlay.setBackgroundResource(R.drawable.zero);

                        k = 0;
                        GestureOverlayView overlayy = (GestureOverlayView) findViewById(R.id.gesture_area);
                        i = i + 1;
                        switch (i) {
                            case 1:
                                if (l == 0) {
                                    overlayy.setBackgroundResource(R.drawable.one);
                                    l = 1;
                                } else {
                                    Toast.makeText(this, "Draw properly", Toast.LENGTH_SHORT).show();
                                    tts.speak("Please draw properly", TextToSpeech.QUEUE_FLUSH, null);
                                }
                                break;
                            case 2:
                                if (l == 1) {
                                    overlayy.setBackgroundResource(R.drawable.two);
                                    l = 2;
                                } else
                                    Toast.makeText(this, "Draw properly :P", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                if (l == 2) {
                                    overlayy.setBackgroundResource(R.drawable.three);
                                } else
                                    Toast.makeText(this, "Draw properly :P", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    } else
                        Toast.makeText(this, "Draw properly :P", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        else
        {
            if(l==1 && l==j)
            {

            }
            else if(l==2 && l==j)
            {

            }
            else
            {
                Toast.makeText(this, "Draw properly :P", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onInit(int status) {

    }
}
