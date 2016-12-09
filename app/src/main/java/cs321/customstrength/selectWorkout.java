package cs321.customstrength;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class selectWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_workout);
        final LinearLayout mainLayout=(LinearLayout) findViewById(R.id.mainLayout);
        for (int i=0; i<MyPrograms.programs.size(); i++) {
            Button button=new Button(this);
            button.setText(MyPrograms.programs.get(i).toString());
            button.setTag(i);
            mainLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Button innerbutton=(Button) view;
                    int index=(int)innerbutton.getTag();
                    mainLayout.removeAllViews();
                    for (int i=0; i<MyPrograms.programs.get(index).weeks.size(); i++) {
                        Button button=new Button(view.getContext());
                        button.setText(MyPrograms.programs.get(index).weeks.get(i).name);
                        int[] tag={index, i};
                        button.setTag(tag);
                        mainLayout.addView(button);
                        button.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Button innerbutton=(Button) view;
                                int[] index=(int[])innerbutton.getTag();
                                Week week=MyPrograms.programs.get(index[0]).weeks.get(index[1]);
                                mainLayout.removeAllViews();
                                for (int i=0; i<week.days.size(); i++) {
                                    Button button=new Button(view.getContext());
                                    button.setText(week.days.get(i).name);
                                    int[] tag={index[0], index[1], i};
                                    button.setTag(tag);
                                    mainLayout.addView(button);
                                    button.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View view) {
                                            int[] results=(int[])view.getTag();
                                            Intent output=new Intent();
                                            output.putExtra("PROGRAM", results[0]);
                                            output.putExtra("WEEK", results[1]);
                                            output.putExtra("DAY", results[2]);
                                            setResult(RESULT_OK, output);
                                            finish();
                                        }
                                    });
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}
