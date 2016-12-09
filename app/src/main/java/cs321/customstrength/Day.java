package cs321.customstrength;

import java.util.ArrayList;

class Day {
  //optional
  String name;
  int numExercises=0;
  ArrayList<Exercise> exercises;
  //if there is no name, name them by number (i.e. "Day 3")
  //when each exercise is added, incriment numExercises
  Day (String name) {
      this.name=name;
      exercises=new ArrayList<Exercise>();
  }

  @Override
  public String toString() {
    String repr=name+":\n";
    for (int i=0; i<exercises.size(); i++) {
        repr+=(i+1)+". ";
        repr+=exercises.get(i).toString();
        repr+="\n";
    }
    return repr;
  }
}