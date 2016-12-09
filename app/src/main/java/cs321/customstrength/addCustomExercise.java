package cs321.customstrength;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class addCustomExercise extends AppCompatActivity {
  TextView pageName;
  EditText customNameValue;
  EditText primaryValue;
  TextView exerciseType;
  EditText secondaryValue;
  EditText equipmentValue;
  EditText difficultyValue;
  Button createButton;
  
  ScrollView mainLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_custom); // should change
    //button stuff and just finding views, don't worry about this
    mainLayout = (ScrollView) findViewById(R.id.activity_create_custom);
    
    customNameValue = (EditText) findViewById(R.id.customNameValue);
    customNameValue.setImeOptions(EditorInfo.IME_ACTION_DONE);
    
    exerciseType = (TextView) findViewById(R.id.exerciseType);
    Spinner typeValue = (Spinner) findViewById(R.id.typeValue);
    String[] typeArray = new String[]{"Strength", "Cardio", "Stretching"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, typeArray);
    typeValue.setAdapter(adapter);
    
    primaryValue = (EditText) findViewById(R.id.primaryValue);
    primaryValue.setImeOptions(EditorInfo.IME_ACTION_DONE);
    primaryValue.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
    
    secondaryValue = (EditText) findViewById(R.id.secondaryValue);
    secondaryValue.setImeOptions(EditorInfo.IME_ACTION_DONE);
    
    equipmentValue = (EditText) findViewById(R.id.equipmentValue);
    equipmentValue.setImeOptions(EditorInfo.IME_ACTION_DONE);
    
    difficultyValue = (EditText) findViewById(R.id.difficultyValue);
    difficultyValue.setImeOptions(EditorInfo.IME_ACTION_DONE);
    
    addListenerOnButton();
  }
  
  
  public void addListenerOnButton(){
    createButton = (Button) findViewById(R.id.createButton);
    createButton.setText("Create");
    createButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view){
        addNewCustomExercise();
      }
    } );
  }
  
  
  
  
  
  private void addNewCustomExercise(){
    // collect String inputs, if the values haven't been changed, it is by default "N/A"
    String customNameString = customNameValue.getText().toString();
    
    // String typeString = need to find some way to get type
    
    String primaryValueString = primaryValue.getText().toString();
    if(primaryValueString.equals("Enter Primary Muscles Used Here")) primaryValueString = "N/A";
    
    String secondaryValueString = secondaryValue.getText().toString();
    if(secondaryValueString.equals("Enter Secondary Muscles Used Here")) secondaryValueString = "N/A";
    
    String equipmentValueString = equipmentValue.getText().toString();
    if(equipmentValueString.equals("Enter Equipment Used Here")) equipmentValueString = "N/A";
    
    String difficultyValueString = difficultyValue.getText().toString();
    if(difficultyValueString.equals("Enter Exercise Difficulty Here")) difficultyValueString = "N/A";
    
    ExerciseData ed = new ExerciseData(customNameString, "Strength", primaryValueString, secondaryValueString,
                                       equipmentValueString, "N/A", difficultyValueString, "N/A");
    LoadExerciseData.createCustomExercise(ed); // create the custom exercise
    Intent returnIntent = new Intent(this, AllExercises.class);
    startActivity(returnIntent);
    finish();
  }
  
  
}