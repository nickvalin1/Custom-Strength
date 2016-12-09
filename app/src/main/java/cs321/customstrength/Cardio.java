package cs321.customstrength;

import java.util.ArrayList;

class Cardio extends Exercise {
  int time; //in minutes
  Intensity intensity;

  Cardio(String name, String primaryMuscle, ArrayList<String> secondaryMuscles, ArrayList<String> equipmentUsed,
         String mechanics, String level, String force,
         int time, Intensity intensity) {
    super(name, primaryMuscle, secondaryMuscles, equipmentUsed, mechanics, level, force);
    this.time = time;
    this.intensity = intensity;
  }
}