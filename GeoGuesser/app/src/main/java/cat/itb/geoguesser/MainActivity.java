package cat.itb.geoguesser;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView question_text, progress_text;
    Button option1, option2,option3, option4;
    ProgressBar progressBar;
    int number = 0;

    QuestionModel[] questionBank = {
            new QuestionModel(R.string.q1, true),
            new QuestionModel(R.string.q2, false),
            new QuestionModel(R.string.q3, false),
            new QuestionModel(R.string.q4, false),
            new QuestionModel(R.string.q5, false),
            new QuestionModel(R.string.q6, false),
            new QuestionModel(R.string.q7, true),
            new QuestionModel(R.string.q8, false),
            new QuestionModel(R.string.q9, true),
            new QuestionModel(R.string.q10, false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question_text = findViewById(R.id.question_text);
        progress_text = findViewById(R.id.progress_text);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        progressBar = findViewById(R.id.progressBar);
        progress_text.setText("Question " + (number+1) + " of " + questionBank.length);
        progressBar.setProgress((number+1)*10);
        question_text.setText("A ConstraintLayout is an example of a Layout");

        option1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if(number+1<questionBank.length) {
                    comprovarResposta(false);
                    refresh();
                }
                else{
                    restartQuiz().show();
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if(number+1<questionBank.length) {
                    comprovarResposta(true);
                    refresh();
                }else{
                    restartQuiz().show();

                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if(number+1<questionBank.length) {
                    comprovarResposta(false);
                    refresh();
                }
                else{
                    restartQuiz().show();
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if(number+1<questionBank.length) {
                    comprovarResposta(false);
                    refresh();
                }
                else{
                    restartQuiz().show();
                }
            }
        });
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public void refresh () {
        number++;
        question_text.setText(questionBank[number].getQuestionText());
        progress_text.setText("Question " + (number+1) + " of " + questionBank.length);
        progressBar.setProgress((number+1)*10, true);
    }

    public Dialog restartQuiz(){
        AlertDialog.Builder restart = new AlertDialog.Builder(this);
        restart.setTitle("Congratulations, you finished the quiz!");
        restart.setMessage("What do you want to do next?");
        restart.setPositiveButton(R.string.EXIT, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        restart.setNegativeButton(R.string.RESTART, new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                number = 0;
                question_text.setText(questionBank[number].getQuestionText());
                progress_text.setText("Question " + (number+1) + " of " + questionBank.length);
                progressBar.setProgress((number+1)*10, true);
            }
        });
        return restart.create();
    }

    public void comprovarResposta(boolean resposta){
        if (resposta == questionBank[number].isAnswer()) {
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "INCORRECT", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("number", number);
    }
}
