package cs321.customstrength;

import java.util.ArrayList;

class Stretch extends Exercise {

  //boolean dynamic; //true=dynamic false=static // don't really need this
  int sets;
  int[] volume; //if dynamic==true, measure in reps, else measure in time(seconds)
  Intensity[] intensity;

  //fixedVolume==true && fixedIntensity==true
  Stretch(String name, String primaryMuscle, ArrayList<String> secondaryMuscles, ArrayList<String> equipmentUsed,
          String mechanics, String level, String force,
          int sets, int[] volume, Intensity[] intensity) {

    super(name, primaryMuscle, secondaryMuscles, equipmentUsed, mechanics, level, force);

    // basically exactly like strength
    // this.dynamic=dynamic; // don't really need this actually
    this.volume=volume; // get this on the same page you are getting fixedVolume

    // PSEUDO-CODE FOR THE CODE TO GET REPS INFORMATION
    /* START CODE:
     * int[] volume = new int[sets];
     * if(fixedVolume == true){
     *   // int userInput = GET USER INPUT HERE
     *   for(int i = 0; i < sets; i++){
     *      volume[i] = userInput;
     *   }
     * }
     * else{
     *   for(int i = 0; i < sets; i++){
     *     int userInput = GET USER INPUT HERE
     *     volume[i] = userInput;
     *   }
     * }
     * END CODE
    */

    this.intensity=intensity; // get this on the same page you are getting fixedIntensity
    // PSEUDO-CODE FOR THE CODE TO GET WEIGHTS INFORMATION
    /* START CODE:
     * int[] intensity = new int[sets];
     * if(fixedIntensity == true){
     *   // int userInput = GET USER INPUT HERE
     *   for(int i = 0; i < sets; i++){
     *      intensity[i] = userInput;
     *   }
     * }
     * else{
     *   for(int i = 0; i < sets; i++){
     *     int userInput = GET USER INPUT HERE
     *     intensity[i] = userInput;
     *   }
     * }
     * END CODE
    */
  }

//  unneeded constructors
//  //fixedVolume==true && fixedIntensity==false
//  Stretch(String name, String primaryMuscle, ArrayList<String> secondaryMuscles, ArrayList<String> equipmentUsed, String level, boolean fixedVolume, boolean fixedIntensity, boolean dynamic, int volume) {
//    super(name, primaryMuscle, secondaryMuscles, equipmentUsed, level, fixedVolume, fixedIntensity);
//    this.dynamic=dynamic;
//    this.volume=volume;
//  }
//  //fixedVolume==false && fixedIntensity==true
//  Stretch(String name, String primaryMuscle, ArrayList<String> secondaryMuscles, ArrayList<String> equipmentUsed, String level, boolean fixedVolume, boolean fixedIntensity, boolean dynamic, Intensity intensity) {
//    super(name, primaryMuscle, secondaryMuscles, equipmentUsed, level, fixedVolume, fixedIntensity);
//    this.dynamic=dynamic;
//    this.intensity=intensity;
//  }
//  //fixedVolume==false && fixedIntensity==false
//  Stretch(String name, String primaryMuscle, ArrayList<String> secondaryMuscles, ArrayList<String> equipmentUsed, String level, boolean fixedVolume, boolean fixedIntensity, boolean dynamic) {
//    super(name, primaryMuscle, secondaryMuscles, equipmentUsed, level, fixedVolume, fixedIntensity);
//  }
}