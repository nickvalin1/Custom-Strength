package cs321.customstrength;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StartWorkout extends AppCompatActivity {

    private Program currentProgram;
    private int currentProgNumber;
    private int currentWeek;
    private int currentDay;
    private TextView showInfo;

    private ListView myListView;
    private ArrayAdapter<Exercise> myLayoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);

        Intent workoutIntent = getIntent();

        showInfo = (TextView) findViewById(R.id.workoutInfoText);

        if (workoutIntent != null) {
            currentProgNumber = workoutIntent.getIntExtra("CURRENT_PROGRAM_NUMBER", 0);
            currentWeek = workoutIntent.getIntExtra("CURRENT_WEEK", 0);
            currentDay = workoutIntent.getIntExtra("CURRENT_DAY", 0);

            // Track which program is currently selected
            currentProgram = MyPrograms.programs.get(currentProgNumber);
        }

        //////////////////////////////////
        // Set up the list view layout. //
        //////////////////////////////////

        myLayoutAdapter = new ArrayAdapter<Exercise>(this,
                R.layout.workout_item, currentProgram.weeks.get(currentWeek).days.get(currentDay).exercises);

        myListView = (ListView) findViewById(R.id.currentProgramWeeksList);
        myListView.setAdapter(myLayoutAdapter);

        myListView.setOnItemClickListener(listItemClickedHandler);
    }

    /**
     * Define the private functions:
     * listItemClickedHandler - handles the expandable view item clicks.
     */


    //
    private AdapterView.OnItemClickListener listItemClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            // Do something in response to the click
            Toast.makeText(StartWorkout.this, currentProgram.weeks.get(position).toString(), Toast.LENGTH_LONG).show();
        }
    };
}
