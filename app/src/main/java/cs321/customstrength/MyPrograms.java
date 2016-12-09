package cs321.customstrength;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyPrograms extends Activity {

    LinearLayout programLayout;
    static ArrayList<Program> programs = new ArrayList<Program>();
    static ArrayList<Boolean> expanded = new ArrayList<Boolean>();
    boolean delete=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_programs);
        Intent programsIntent = getIntent();
        init();
    }
    public void init() {
        //the LinearLayout to add programs to
        programLayout=(LinearLayout) findViewById(R.id.programLayout);
        //create the buttons that display the programs
        for (int i = 0; i < programs.size(); i++) {
            //create the button to display the program
            Button button = new Button(this);
            //set the text
            button.setText(programs.get(i).toString());
            button.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            button.setTextColor(Color.BLACK);
            button.setTag(i);
            //add button to row
            programLayout.addView(button);
            //onClick
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Button innerbutton = (Button) view;
                    //find which program it is
                    int position = (int) innerbutton.getTag();
                    if (delete) {
                        programLayout.removeViewAt(position+1);
                        programs.remove(position);
                        delete=false;
                        for (int i=1; i<programLayout.getChildCount(); i++) {
                            Button button=(Button)programLayout.getChildAt(i);
                            button.setTag(i-1);
                        }
                    } else {
                        //if it is collapsed, expand it
                        if (!MyPrograms.expanded.get(position)) {
                            innerbutton.setText(programs.get(position).toStringExpanded());
                            MyPrograms.expanded.set(position, true);
                        }
                        //if it is expanded, collapse it
                        else {
                            innerbutton.setText(programs.get(position).toString());
                            MyPrograms.expanded.set(position, false);
                        }
                    }
                }
            });
        }
        if (programs.size() == 0) {
            TextView emptyMessage=new TextView(this);
            emptyMessage.setText("Nothing here... try adding a program");
            programLayout.addView(emptyMessage);
        }
    }
    //onClick for add new program
    public void addProgram(View view) {
        Intent createIntent = new Intent(this, addProgram.class);
        startActivity(createIntent);
        finish();
    }
    public void deleteProgram(View view) {
        if (programs.size()>0) {
            Toast.makeText(this, "Choose a program to delete.", Toast.LENGTH_LONG).show();
            delete = true;
        }
        else {
            Toast.makeText(this, "No program exists to delete", Toast.LENGTH_LONG).show();
        }
    }
}