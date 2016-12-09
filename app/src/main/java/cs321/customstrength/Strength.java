package cs321.customstrength;

import java.util.ArrayList;

class Strength extends Exercise {
  String mechanics; //Compound, isolation, N/A
  String force; //push, pull, static, N/A

  ArrayList<String> equipment;

  int sets;
  //use int arrys to cover the case where sets are different, if differentSets is false, the array length will be 1
  int[] reps;
  int[] weight;
  //use when fixedIntensity==false || fixedVolume==false
  int[] repsOrWeight;
  //fixedIntensity==true && fixedVolume==true
  Strength (String name, String primaryMuscle, ArrayList<String> secondaryMuscles, ArrayList<String> equipmentUsed,
            String mechanics, String level, String force, int sets, int[] reps, int[] weight) {
    super(name, primaryMuscle, secondaryMuscles, equipmentUsed, mechanics, level, force);
    this.sets=sets;
    this.reps=reps; // get this on the same page you are getting fixedVolume
    // PSEUDO-CODE FOR THE CODE TO GET REPS INFORMATION
    /* START CODE:
     * int[] reps = new int[sets];
     * if(fixedVolume == true){
     *   // int userInput = GET USER INPUT HERE
     *   for(int i = 0; i < sets; i++){
     *      reps[i] = userInput;
     *   }
     * }
     * else{
     *   for(int i = 0; i < sets; i++){
     *     int userInput = GET USER INPUT HERE
     *     reps[i] = userInput;
     *   }
     * }
     * END CODE
    */
    this.weight=weight; // get this on the same page you are getting fixedIntensity
    // PSEUDO-CODE FOR THE CODE TO GET WEIGHTS INFORMATION
    /* START CODE:
     * int[] weights = new int[sets];
     * if(fixedIntensity == true){
     *   // int userInput = GET USER INPUT HERE
     *   for(int i = 0; i < sets; i++){
     *      weights[i] = userInput;
     *   }
     * }
     * else{
     *   for(int i = 0; i < sets; i++){
     *     int userInput = GET USER INPUT HERE
     *     weights[i] = userInput;
     *   }
     * }
     * END CODE
    */
  }

//  unneeded constructors
//  //fixedIntensity==false || fixedVolume==false
//  Strength (String name, String primaryMuscle, ArrayList<String> secondaryMuscles, ArrayList<String> equipmentUsed, String level, boolean fixedVolume, boolean fixedIntensity, boolean differentSets, String mechanics, String force, int sets, int[] repsOrWeight) {
//    super(name, primaryMuscle, secondaryMuscles, equipmentUsed, level, fixedVolume, fixedIntensity);
//    this.mechanics=mechanics;
//    this.force=force;
//    this.differentSets=differentSets;
//    this.sets=sets;
//    if (this.fixedIntensity==true) {
//      this.repsOrWeight=weight;
//      reps=new int[sets];
//    }
//    else {
//      this.repsOrWeight=reps;
//      weight=new int[sets];
//    }
//  }
//  //fixedIntensity==false && fixedVolume==false
//  Strength (String name, String primaryMuscle, ArrayList<String> secondaryMuscles, ArrayList<String> equipmentUsed, String level, boolean fixedVolume, boolean fixedIntensity, boolean differentSets, String mechanics, String force, int sets) {
//    super(name, primaryMuscle, secondaryMuscles, equipmentUsed, level, fixedVolume, fixedIntensity);
//    this.mechanics=mechanics;
//    this.force=force;
//    this.differentSets=differentSets;
//    this.sets=sets;
//    this.reps=new int[sets];
//    this.weight=new int[sets];
//  }

  public static void main (String[] args) {
//    ArrayList<String> al=new ArrayList<String>();
//    al.add("Calves");
//    al.add("Glutes");
//    al.add("Lower Back");
//
//    ArrayList<String> equipment = new ArrayList<String>();
//    equipment.add("Barbell");
//
//    Strength st=new Strength("Barbell Deadlift", "Hamstrings", al, equipment, "Intermediate", false, false, false, "Compound", "Pull", 3);
//    System.out.println(st);
  }
}
