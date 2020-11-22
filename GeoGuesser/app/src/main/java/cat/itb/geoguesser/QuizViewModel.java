package cat.itb.geoguesser;

import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {
    private boolean op1, op2, op3, op4;
    private final cat.itb.geoguesser.QuestionModel[] questionBank = new cat.itb.geoguesser.QuestionModel[] {
            new cat.itb.geoguesser.QuestionModel(R.string.q1, true),
            new cat.itb.geoguesser.QuestionModel(R.string.q2, false),
            new cat.itb.geoguesser.QuestionModel(R.string.q3, false),
            new cat.itb.geoguesser.QuestionModel(R.string.q4, false),
            new cat.itb.geoguesser.QuestionModel(R.string.q5, false),
            new cat.itb.geoguesser.QuestionModel(R.string.q6, false),
            new cat.itb.geoguesser.QuestionModel(R.string.q7, true),
            new cat.itb.geoguesser.QuestionModel(R.string.q8, false),
            new cat.itb.geoguesser.QuestionModel(R.string.q9, true),
            new cat.itb.geoguesser.QuestionModel(R.string.q10, false),
    };
    int currentIndex = 0;
    private int progressBarUnit = (int) Math.floor((double) 100 / questionBank.length);

    public int getQuestion() {
        return questionBank[currentIndex].questionText;
    }
}
