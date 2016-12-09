package cs321.customstrength;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ValidateWorkout extends AppCompatActivity {

    int currentDay;
    int currentWeek;
    int programNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_workout);
        Intent workoutIntent = getIntent();
        currentWeek = workoutIntent.getIntExtra("CURRENT_WEEK",0);
        currentDay = workoutIntent.getIntExtra("CURRENT_DAY",0);
        programNumber= workoutIntent.getIntExtra("CURRENT_PROGRAM",0);
        Program currentProgram=MyPrograms.programs.get(programNumber);
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.currentProgram);
        TextView text=new TextView(this);
        text.setText("Current Workout: "+currentProgram.name+", Week: "+currentProgram.weeks.get(currentWeek).name+", Day: "+currentProgram.weeks.get(currentWeek).days.get(currentDay).name);
        linearLayout.addView(text);
    }
    public void startWorkout(View view) {
        Intent startIntent=new Intent(this, StartWorkout.class);
        startIntent.putExtra("CURRENT_DAY", currentDay);
        startIntent.putExtra("CURRENT_WEEK", currentWeek);
        startIntent.putExtra("CURRENT_PROGRAM", programNumber);
        startActivity(startIntent);
    }
    public void selectWorkout(View view) {
        Intent selectIntent = new Intent(this, selectWorkout.class);
        startActivityForResult(selectIntent, 0);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        programNumber = data.getIntExtra("PROGRAM",0);
        currentWeek = data.getIntExtra("WEEK", 0);
        currentDay = data.getIntExtra("DAY",0);
    }
}
