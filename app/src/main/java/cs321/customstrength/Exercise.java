package cs321.customstrength;

import java.util.ArrayList;

abstract class Exercise {
  String name;
  String primaryMuscle;
  ArrayList<String> secondaryMuscles;
  ArrayList<String> equipmentUsed;
  String mechanics;
  String force;
  //beginner, intermediate, expert
  String level;
  //  boolean fixedVolume; don't need this
  //  boolean fixedIntensity; don't need this
  Exercise (String name, String primaryMuscle, ArrayList<String> secondaryMuscles, ArrayList<String> equipmentUsed,
            String mechanics, String level, String force) {
    this.name=name;
    this.primaryMuscle=primaryMuscle;
    this.secondaryMuscles=secondaryMuscles;
    this.equipmentUsed=equipmentUsed;
    this.mechanics=mechanics;
    this.level=level;
    this.force=force;
  }
  public String toString() {
    StringBuilder sb=new StringBuilder(name);
    //sb.append("\nPrimary Muscle Worked: ");
    //sb.append(primaryMuscle);
    //sb.append("\nSecondary Muscles Worked: ");
    //sb.append(secondaryMuscles);
    //sb.append("\nEquipment Used: ");
    //sb.append(equipmentUsed);
    //sb.append("\nDifficulty: ");
    //sb.append(level);
    return sb.toString();
  }
}