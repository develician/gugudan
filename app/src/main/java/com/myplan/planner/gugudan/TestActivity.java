package com.myplan.planner.gugudan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    private Button calculateButton;
    private TextView answerNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        calculateButton = (Button) findViewById(R.id.calculateButton);
        answerNumberTextView = (TextView) findViewById(R.id.answerNumberTextView);

        Intent intent = getIntent();
        if(intent != null) {
            int number = intent.getIntExtra("numberOfAnswers", -1);
            Toast.makeText(this, "Number" + number + "", Toast.LENGTH_SHORT).show();

            answerNumberTextView.setText(answerNumberTextView.getText().toString() + number + "개");
        }

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
