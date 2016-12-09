package cs321.customstrength;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

// These tests check data integrity and consistency, as well as how the system interacts with the data.
@RunWith(AndroidJUnit4.class)
public class CSBackendTests {
  @Rule
  public ActivityTestRule<MainActivity> mActivityRule =
    new ActivityTestRule<>(MainActivity.class);
  
  // test to see if preloadedExercises successfully loaded
  @Test
  public void preloadedVerification(){
    final HashMap<String,ExerciseData> preloadedExercises = LoadExerciseData.PRELOADED_EXERCISES;
    assertTrue(preloadedExercises != null);
    // text file contains 1063 unique exercises
    String s = "Actual size:" + preloadedExercises.size();
    assertEquals(s, preloadedExercises.size(), 1063);
  }
  
  // test to see if method correctly displays exercises
  @Test
  public void displayExercisesTest(){
    ArrayList<String> al = LoadExerciseData.displayExercises(LoadExerciseData.PRELOADED_EXERCISES);
    String s = "Actual size:" + al.size();
    // check ArrayList size
    assertEquals(s, al.size(), 1063);
    // check for two known preloaded exercises in ArrayList
    assertTrue(al.contains("Alien Squat".toUpperCase()));
    assertTrue(al.contains("Dumbbell Rear Lunge".toUpperCase()));
  }
  
  //tests to see if the search method is working correctly
  @Test
  public void searchExercisesTest(){
    // search for "trap"
    ArrayList<String> al = LoadExerciseData.searchExercises("trap");
    assertTrue(al.contains("Inverted Row with Straps".toUpperCase()));
    assertTrue(al.contains("Trap Bar Deadlift".toUpperCase()));
    assertTrue(al.contains("Trap Bar Jump".toUpperCase()));
    
    // search for "windmill"
    al = LoadExerciseData.searchExercises("windmill");
    assertTrue(al.contains("Advanced Kettlebell Windmill".toUpperCase()));
    assertTrue(al.contains("Double Kettlebell Windmill".toUpperCase()));
    assertTrue(al.contains("Kettlebell Windmill".toUpperCase()));
    assertTrue(al.contains("Windmills".toUpperCase()));
  }
  
  @Test
  public void customExerciseTests1(){
    // sample ExerciseData
    ExerciseData ed = new ExerciseData("uniquecustomexercise9129fhiuhfasuiasdrandomletters10".toUpperCase(), "Cardio", "random string",
                                       "fqwfhiqwuhdiuw", "asoidhiu", "128y1982yr98", "aosidoaisjd", "1918f198");
    // add to CustomExercises
    LoadExerciseData.createCustomExercise(ed);
    // must have at least 1 item now
    assertTrue(LoadExerciseData.CUSTOM_EXERCISES.size() >= 1);
    // verify that ed has actually been added
    assertTrue(LoadExerciseData.CUSTOM_EXERCISES.get("uniquecustomexercise9129fhiuhfasuiasdrandomletters10".toUpperCase()) != null);
    assertEquals(LoadExerciseData.CUSTOM_EXERCISES.get("uniquecustomexercise9129fhiuhfasuiasdrandomletters10".toUpperCase()), ed);
    assertTrue(LoadExerciseData.searchExercises("uniquecustomexercise").size() >= 1);

    // add a repeat of the same custom exercise
    LoadExerciseData.createCustomExercise(ed);
    // test repeat names, should have an extra 1 at the end
    assertTrue(LoadExerciseData.CUSTOM_EXERCISES.get("uniquecustomexercise9129fhiuhfasuiasdrandomletters101".toUpperCase()) != null);
    assertTrue(LoadExerciseData.searchExercises("uniquecustomexercise").size() >= 2); // must have at least 2 items now

    LoadExerciseData.removeCustomExercise("uniquecustomexercise9129fhiuhfasuiasdrandomletters10".toUpperCase()); // remove
    // check to make sure it has been removed
    assertTrue(LoadExerciseData.CUSTOM_EXERCISES.get("uniquecustomexercise9129fhiuhfasuiasdrandomletters10".toUpperCase()) == null);
    assertTrue(!LoadExerciseData.displayExercises(LoadExerciseData.CUSTOM_EXERCISES).contains("uniquecustomexercise9129fhiuhfasuiasdrandomletters10".toUpperCase()));

    // check current size, should be at least 1
    assertTrue(LoadExerciseData.searchExercises("uniquecustomexercise").size() >= 1);
    // remove and check size
    LoadExerciseData.removeCustomExercise("uniquecustomexercise9129fhiuhfasuiasdrandomletters101".toUpperCase());
    assertTrue(LoadExerciseData.searchExercises("uniquecustomexercise").size() >= 0);
  }

  @Test
  public void customExerciseTests2(){
    // blank ExerciseData
    ExerciseData ed = new ExerciseData("", "", "", "", "", "", "", "");
    LoadExerciseData.createCustomExercise(ed);
    // must have at least 1 item now
    assertTrue(LoadExerciseData.CUSTOM_EXERCISES.size() >= 1);
    // verify that ed has actually been added
    assertTrue(LoadExerciseData.CUSTOM_EXERCISES.get("N/A".toUpperCase()) != null);
    assertEquals(LoadExerciseData.CUSTOM_EXERCISES.get("N/A".toUpperCase()), ed);
    assertTrue(LoadExerciseData.searchExercises("N/A").size() >= 1);

    // add a repeat of the same custom exercise
    LoadExerciseData.createCustomExercise(ed);
    // test repeat names, should have an extra 1 at the end
    assertTrue(LoadExerciseData.CUSTOM_EXERCISES.get("N/A1".toUpperCase()) != null);
    assertTrue(LoadExerciseData.searchExercises("N/A").size() >= 2); // must have at least 2 items now

    LoadExerciseData.removeCustomExercise("N/A".toUpperCase()); // remove
    // check to make sure it has been removed
    assertTrue(LoadExerciseData.CUSTOM_EXERCISES.get("N/A".toUpperCase()) == null);
    assertTrue(!LoadExerciseData.displayExercises(LoadExerciseData.CUSTOM_EXERCISES).contains("".toUpperCase()));

    // check current size, should be at least 1
    assertTrue(LoadExerciseData.searchExercises("N/A").size() >= 1);
    // remove and check size
    LoadExerciseData.removeCustomExercise("N/A1".toUpperCase());
    assertTrue(LoadExerciseData.searchExercises("N/A").size() >= 0);
  }
}