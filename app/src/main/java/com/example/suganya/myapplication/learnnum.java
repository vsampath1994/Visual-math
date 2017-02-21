package com.example.suganya.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;



public class learnnum extends ActionBarActivity implements TextToSpeech.OnInitListener {

    //final com.github.siyamed.shapeimageview.CircularImageView photo = (com.github.siyamed.shapeimageview.CircularImageView) convertView.findViewById(R.id.photo);

    //photo.setImageResource(R.drawable.female);

    int count = 1, lang;
    static String TranslatedText;
    private String[] language = {"Hindi", "English"};
    private static final String[] specialNames = {
            "",
            " thousand",
            " million",
            " billion",
            " trillion",
            " quadrillion",
            " quintillion"
    };

    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };


    TextToSpeech ttobj;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */



    private String convertLessThanOneThousand(int number) {
        String current;

        if (number % 100 < 20) {
            current = numNames[number % 100];
            number /= 100;
        } else {
            current = numNames[number % 10];
            number /= 10;

            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numNames[number] + " hundred" + current;
    }

    public String convert(int number) {

        if (number == 0) {
            return "zero";
        }

        String prefix = "";

        if (number < 0) {
            number = -number;
            prefix = "negative";
        }

        String current = "";
        int place = 0;

        do {
            int n = number % 1000;
            if (n != 0) {
                String s = convertLessThanOneThousand(n);
                current = s + specialNames[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        count = 1;
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_learnnum);

        TextView tv = (TextView) findViewById(R.id.text1);
        tv.setText(String.valueOf(count));
        TextView tv1 = (TextView) findViewById(R.id.text2);
        tv1.setText(convert(count));



        ttobj = new TextToSpeech(this, this);
        ttobj.setLanguage(Locale.UK);
        ttobj.speak("Text to say aloud", TextToSpeech.QUEUE_FLUSH, null);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learnnum, menu);
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

    public void prev(View v) {
        count -= 1;
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        TextView tv = (TextView) findViewById(R.id.text1);
        tv.setText(String.valueOf(count));
        tv.setTextColor(color);
        TextView tv1 = (TextView) findViewById(R.id.text2);
        tv1.setText(convert(count));
        tv1.setTextColor(color);
        ttobj.speak(String.valueOf(count), TextToSpeech.QUEUE_FLUSH, null);

    }

    public void next(View v) {
        count += 1;
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        TextView tv = (TextView) findViewById(R.id.text1);
        tv.setText(String.valueOf(count));
        tv.setTextColor(color);
        TextView tv1 = (TextView) findViewById(R.id.text2);
        tv1.setText(convert(count));
        tv1.setTextColor(color);
        ttobj.speak(String.valueOf(count), TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {

    }

    public void repeatNum(View v) {
      //  com.example.prashant.mathl.Translate.setHttpReferrer("http://android-er.blogspot.com/");

       //String OutputString = com.example.prashant.mathl.Translate.execute("one",
        //        Language.ENGLISH, Language.FRENCH);



      ttobj.speak(String.valueOf(count), TextToSpeech.QUEUE_FLUSH, null);
    }

    public void hindiVoice(View v){
        String languageToLoad = "hi";
        Locale locale = new Locale(languageToLoad);
        Configuration config = new Configuration();
        try {
            TextView tv3 = (TextView) findViewById(R.id.text2);
            String Hinditext = tv3.getText().toString();
            new TranslateTask().execute(Hinditext);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
            if (learnnum.TranslatedText != null) {
                tv3.setText(learnnum.TranslatedText);
            }
            else
            {
                tv3.setText(convert(count));
            }
            ttobj.speak(learnnum.TranslatedText, TextToSpeech.QUEUE_FLUSH, null);
            //  Log.d("sdsadds", r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
class TranslateTask extends AsyncTask<String,String,String> {

    private Exception exception;

    protected String doInBackground(String... text) {
        Log.d("IIIIIIIIIIIIIIIIIII",text[0]);
        String TranslatedText;
        try {
            Translate.setClientId("mathl-collegeproject");
            Translate.setClientSecret("T61ah5N3UGnWxKsRaIKWJKpWtvvdZGK/XTJBdPxTHgk="); //change
            TranslatedText = Translate.execute(text[0],Language.HINDI);
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
        return TranslatedText;
    }

    protected void onPostExecute(String t) {
        learnnum.TranslatedText=t;
    }


}
