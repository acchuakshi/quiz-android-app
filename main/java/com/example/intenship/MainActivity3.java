package com.example.intenship;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;


    int score = 0;
    int totalQuestion = Question.questions.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);


        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : " + totalQuestion);
        loadNewQuestion();
    }
    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);


        Button clickedButton = (Button) view;

        if (clickedButton.getId()==R.id.submit_btn);
        {
            if (selectedAnswer.equals(Question.correctAnswer[currentQuestionIndex])) {
                score++;
                currentQuestionIndex++;
                loadNewQuestion();

            } else {
                selectedAnswer = clickedButton.getText().toString();
                clickedButton.setBackgroundColor(Color.BLUE);

            }
        }
       loadNewQuestion();
    {
           if(currentQuestionIndex==totalQuestion){
               finishQuiz();
               return;
           }

            questionTextView.setText(Question.questions[currentQuestionIndex]);
            ansA.setText(Question.choices[currentQuestionIndex][0]);
            ansB.setText(Question.choices[currentQuestionIndex][1]);
            ansC.setText(Question.choices[currentQuestionIndex][2]);
            ansD.setText(Question.choices[currentQuestionIndex][3]);

        }
    }

    private void loadNewQuestion() {
    }


    void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is" + score + "out of" + totalQuestion)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz(){
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }




}

   