package com.myplan.planner.gugudan;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private ProgressBar timeProgressBar;
    private TextView problemTextView, answerTextView, numberOfAnswersTextView;
    private Button number0, number1, number2, number3, number4, number5, number6, number7, number8, number9, enterButton, cancelButton;
    private Boolean flag = true;
    private int timeCounter = 0;
    private TimeThread thread;

    Random generator = new Random();
    int num1 = generator.nextInt(9) + 1;
    int num2 = generator.nextInt(9) + 1;
    int answer = num1 * num2;
    int numberOfAnswers = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeProgressBar = (ProgressBar) findViewById(R.id.timeProgressBar);
        timeProgressBar.setMax(60);

        problemTextView = (TextView) findViewById(R.id.problemTextView);
        problemTextView.setText(num1 + " X " + num2);
        numberOfAnswersTextView = (TextView) findViewById(R.id.numberOfAnswersTextView);
        answerTextView = (TextView) findViewById(R.id.answerTextView);

        number0 = (Button) findViewById(R.id.number0);
        number1 = (Button) findViewById(R.id.number1);
        number2 = (Button) findViewById(R.id.number2);
        number3 = (Button) findViewById(R.id.number3);
        number4 = (Button) findViewById(R.id.number4);
        number5 = (Button) findViewById(R.id.number5);
        number6 = (Button) findViewById(R.id.number6);
        number7 = (Button) findViewById(R.id.number7);
        number8 = (Button) findViewById(R.id.number8);
        number9 = (Button) findViewById(R.id.number9);
        enterButton = (Button) findViewById(R.id.enterButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });

        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTextView.setText(answerTextView.getText() + "" + number0.getText());
            }
        });
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTextView.setText(answerTextView.getText() + "" + number1.getText());
            }
        });
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTextView.setText(answerTextView.getText() + "" + number2.getText());
            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTextView.setText(answerTextView.getText() + "" + number3.getText());
            }
        });

        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTextView.setText(answerTextView.getText() + "" + number4.getText());
            }
        });
        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTextView.setText(answerTextView.getText() + "" + number5.getText());
            }
        });
        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTextView.setText(answerTextView.getText() + "" + number6.getText());
            }
        });
        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTextView.setText(answerTextView.getText() + "" + number7.getText());
            }
        });
        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTextView.setText(answerTextView.getText() + "" + number8.getText());
            }
        });
        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTextView.setText(answerTextView.getText() + "" + number9.getText());
            }
        });

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(answerTextView.getText().toString()) == answer) {
                    answerTextView.setText("");
                    numberOfAnswers++;
                    numberOfAnswersTextView.setText(numberOfAnswers + "");
                    num1 = generator.nextInt(9) + 1;
                    num2 = generator.nextInt(9) + 1;
                    answer = num1 * num2;
                    problemTextView.setText(num1 + "X" + num2);
                } else {
                    answerTextView.setText("");
                    return;
                }
            }
        });

        thread = new TimeThread();
        thread.setDaemon(true);
        thread.start();
    }

    class TimeThread extends Thread {
        @Override
        public void run() {
            while(flag) {
                timeCounter++;
                handler.sendEmptyMessage(0);

                try {
                    Thread.sleep(1000);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ProblemThread extends Thread {
        @Override
        public void run() {




        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0) {
                timeProgressBar.incrementProgressBy(5);
                if(timeProgressBar.getMax() == timeProgressBar.getProgress() || timeCounter > 60) {
                    flag = false;
                    Intent intent = new Intent(MainActivity.this, TestActivity.class);
                    intent.putExtra("numberOfAnswers", numberOfAnswers);
                    startActivity(intent);

                }
            }
        }
    };

    Handler answerHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

        }
    };







}
