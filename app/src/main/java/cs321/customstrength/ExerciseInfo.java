package cs321.customstrength;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ExerciseInfo extends AppCompatActivity {
    private String exerciseDataStr;
    private ExerciseData exerciseData;
    private TextView exercise = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_info);

        RelativeLayout rView = (RelativeLayout) findViewById(R.id.activity_exercise_info);

        Intent intent = getIntent();
        String exerciseStr = intent.getExtras().getString("Exercise");

        System.out.print("EXERCISE"+exerciseStr);

        exerciseData = LoadExerciseData.PRELOADED_EXERCISES.get(exerciseStr);
        exerciseDataStr = exerciseData.toString();

        exercise= new TextView(this);
        exercise.setText(exerciseDataStr);
        rView.addView(exercise);
    }
}
