package com.example.suganya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Image extends ActionBarActivity implements View.OnClickListener {


    private final int ADD_OPERATOR = 0, SUBTRACT_OPERATOR = 1, MULTIPLY_OPERATOR = 2,
            DIVIDE_OPERATOR = 3;
    //operator text
    public String[] operators = {"+", "-", "x", "/"};
    private int level = 0, answer = 0, operator = 0, operand1 = 0, operand2 = 0;
    private Random random=new Random();
    private String[] questions=new String[9];
    int counter=0;
    int img=1;
    private int[] answers=new int[9];
    private int[][] levelMin = {
            {1, 11, 21},
            {1, 5, 10},
            {2, 5, 10},
            {2, 3, 5}};
    private int[][] levelMax = {
            {10, 25, 50},
            {10, 20, 30},
            {5, 10, 15},
            {10, 50, 100}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        chooseQuestion();
        TextView t1=(TextView)findViewById(R.id.num);
        t1.setText(questions[0]+"= ?");
        setAnswer(answers);
    }

    private void setAnswer(int[] answers) {

        Random rand = new Random();
        int a=rand.nextInt(9);



        Button img1=(Button)findViewById(R.id.b1);
        Button img2=(Button)findViewById(R.id.b2);
        Button img3=(Button)findViewById(R.id.b3);
        Button img4=(Button)findViewById(R.id.b4);
        Button img5=(Button)findViewById(R.id.b5);
        Button img6=(Button)findViewById(R.id.b6);
        Button img7=(Button)findViewById(R.id.b7);
        Button img8=(Button)findViewById(R.id.b8);
        Button img9=(Button)findViewById(R.id.b9);

            img1.setText(answers[(10+a)%9]+"");

            img2.setText(answers[(15+a)%9]+"");
            img3.setText(answers[(14+a)%9]+"");
            img4.setText(answers[(16+a)%9]+"");
            img5.setText(answers[(12+a)%9]+"");
            img6.setText(answers[(17+a)%9]+"");
            img7.setText(answers[(18+a)%9]+"");
            img8.setText(answers[(11+a)%9]+"");
            img9.setText(answers[(13 + a) % 9] + "");
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);
        img9.setOnClickListener(this);



    }

    private void chooseQuestion() {


            //reset answer text

            //choose operator
        for(int i=0;i<9;i++) {
            operator=random.nextInt(4);
            //choose operands
            operand1 = getOperand();
            operand2 = getOperand();

            //checks for operators
            if (operator == SUBTRACT_OPERATOR) {
                //no negative answers
                while (operand2 > operand1) {
                    operand1 = getOperand();
                    operand2 = getOperand();
                }
            } else if (operator == DIVIDE_OPERATOR) {
                //whole numbers only
                while ((((double) operand1 / (double) operand2) % 1 > 0)
                        || (operand1 == operand2)) {
                    operand1 = getOperand();
                    operand2 = getOperand();
                }
            }

            //calculate answer
            switch (operator) {
                case ADD_OPERATOR:
                    answer = operand1 + operand2;
                    break;
                case SUBTRACT_OPERATOR:
                    answer = operand1 - operand2;
                    break;
                case MULTIPLY_OPERATOR:
                    answer = operand1 * operand2;
                    break;
                case DIVIDE_OPERATOR:
                    answer = operand1 / operand2;
                    break;
                default:
                    break;
            }
            Log.d("HAIIIIIII",operand1+" "+operators[operator]+" "+operand2);
            questions[i]=operand1+" "+operators[operator]+" "+operand2;
            answers[i]=answer;
           // questions[i].question=" "+answer;
            //questions[i].answer=answer;
        }   //show question


        }

        //method generates operands





    private int getOperand(){
        return random.nextInt(levelMax[operator][level] - levelMin[operator][level] + 1)
                + levelMin[operator][level];
    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        TextView tv=(TextView)findViewById(R.id.wrong);
        String number = b.getText().toString();
        Random r=new Random();
        if(counter==0)
        img=r.nextInt(2);
        int DrawImgId = 0;
        int id= b.getId();


            switch(img)
            {
                    case 1:
                        switch(id) {
                            case R.id.b1:
                                DrawImgId = R.drawable.cb1;
                                tv.setText("");
                                break;
                            case R.id.b2:
                                DrawImgId = R.drawable.cb2;
                                tv.setText("");
                                break;
                            case R.id.b3:
                                DrawImgId = R.drawable.cb3;
                                tv.setText("");
                                break;
                            case R.id.b4:
                                DrawImgId = R.drawable.cb4;
                                tv.setText("");
                                break;
                            case R.id.b5:
                                DrawImgId = R.drawable.cb5;
                                tv.setText("");
                                break;
                            case R.id.b6:
                                DrawImgId = R.drawable.cb6;
                                tv.setText("");
                                break;
                            case R.id.b7:
                                DrawImgId = R.drawable.cb7;
                                tv.setText("");
                                break;
                            case R.id.b8:
                                DrawImgId = R.drawable.cb8;
                                tv.setText("");
                                break;
                            case R.id.b9:
                                DrawImgId = R.drawable.cb9;
                                tv.setText("");
                                break;
                        }
                    case 2:
                        switch(id) {

                            case R.id.b1:
                                DrawImgId = R.drawable.db1;
                                tv.setText("");
                                break;
                            case R.id.b2:
                                DrawImgId = R.drawable.db2;
                                tv.setText("");
                                break;
                            case R.id.b3:
                                DrawImgId = R.drawable.db3;
                                tv.setText("");
                                break;
                            case R.id.b4:
                                DrawImgId = R.drawable.db4;
                                tv.setText("");
                                break;
                            case R.id.b5:
                                DrawImgId = R.drawable.db5;
                                tv.setText("");
                                break;
                            case R.id.b6:
                                DrawImgId = R.drawable.db6;
                                tv.setText("");
                                break;
                            case R.id.b7:
                                DrawImgId = R.drawable.db7;
                                tv.setText("");
                                break;
                            case R.id.b8:
                                DrawImgId = R.drawable.db8;
                                tv.setText("");
                                break;
                            case R.id.b9:
                                DrawImgId = R.drawable.db9;
                                tv.setText("");
                                break;
                        }
            }

        if(Integer.parseInt(number)==answers[counter])
        {

            b.setBackgroundResource(DrawImgId);




        }
        else{
            //TextView tv=(TextView)findViewById(R.id.wrong);
            tv.setText("Wrong , The Answer is " + answers[counter]);
            b.setBackgroundResource(DrawImgId);
       //wrong scenario

       }

        counter++;
        if(counter<9) {
            TextView t1 = (TextView) findViewById(R.id.num);
            t1.setText(questions[counter] + "= ?");
        }
        else if(counter==9)
        {
            Intent i=new Intent(this,AnimationActivity.class);
            startActivity(i);
        }
        else
        {
            //wrong scenario

        }
    }
}



