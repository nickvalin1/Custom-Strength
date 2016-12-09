package cs321.customstrength;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;
import android.content.Context; // Use only when using Android

class LoadExerciseData {

  protected static final HashMap<String,ExerciseData> PRELOADED_EXERCISES = LoadExerciseData.loadPreloadedData();
  protected static HashMap<String,ExerciseData> CUSTOM_EXERCISES = LoadExerciseData.loadCustomData();

  static HashMap<String,ExerciseData> loadPreloadedData() {
    InputStream inputStream;
//    File f;
    Scanner sc;
    HashMap<String,ExerciseData> preloadedExercises = new HashMap<String,ExerciseData>();

    try {
      inputStream = MainActivity.getContext().getAssets().open("ExerciseDataFinal.txt"); // use this on Android SDK

//      f=new File("ExerciseDataFinal.txt"); // use this on normal Java IDE

      sc=new Scanner(inputStream); // separated this line because it leads to a memory leak
      sc.useDelimiter("\t|\n"); // since you can't properly close everything if it's one line
      sc.nextLine(); // this gets rid of the first header line

      while (sc.hasNext()) {
        // read all of the values, there should be 8 items
        String name = sc.next(); // adds the exercise name as upper case only because of search
        name = name.toUpperCase(); // I don't know how to make search not case sensitive
        String type = sc.next();
        String primaryMuscle = sc.next();
        String secondaryMuscles = sc.next();
        String equipmentUsed = sc.next();
        String mechanics = sc.next();
        String level = sc.next();
        String force = sc.next();
        ExerciseData ed = new ExerciseData(name, type, primaryMuscle, 
                       secondaryMuscles, equipmentUsed, mechanics, level, force);
        preloadedExercises.put(name, ed); // add to HashMap, key = name, data = value
      }
     sc.close();
    }
    catch (IOException e) {
      System.out.println("loadPreloadedExercises: Could not find ExerciseDataFinal.txt file");
    }
   return preloadedExercises; 
  }
    static HashMap<String,ExerciseData> loadCustomData() {
//    InputStream inputStream;
    File f;
    Scanner sc;
    HashMap<String,ExerciseData> customExercises = new HashMap<String,ExerciseData>();
    try {
      f = new File(MainActivity.getContext().getFilesDir(),"CustomExerciseData.txt"); // use on Android SDK
//      f=new File("CustomExerciseData.txt"); // use this on normal Java IDE
      sc=new Scanner(f); // separated this line because it leads to a memory leak
      sc.useDelimiter("\t|\n"); // since you can't properly close everything if it's one line
      sc.nextLine(); // this gets rid of the first header line
      while (sc.hasNext()) {
        // read all of the values, there should be 8 items
        String name = sc.next(); // adds the exercise name as upper case only because of search
        name = name.toUpperCase(); // I don't know how to make search not case sensitive
        String type = sc.next();
        String primaryMuscle = sc.next();
        String secondaryMuscles = sc.next();
        String equipmentUsed = sc.next();
        String mechanics = sc.next();
        String level = sc.next();
        String force = sc.next();
        ExerciseData ed = new ExerciseData(name, type, primaryMuscle,
                       secondaryMuscles, equipmentUsed, mechanics, level, force);
        customExercises.put(name, ed); // add to HashMap, key = name, data = value
      }
     sc.close();
    }
    catch (IOException e) {
      System.out.println("loadCustomData: Could not find CustomExerciseData.txt file");
    }
   return customExercises;
  }

  // this will be used to search through Custom Exercises and preloaded
  // returns a sorted list of the names
  static ArrayList<String> searchExercises(String s){
    s = s.toUpperCase();
    ArrayList<String> exerciseLoad = new ArrayList<String>(); // could use a different data structure here
    Set<String> exerciseSet = LoadExerciseData.PRELOADED_EXERCISES.keySet();
    String exerciseArray[] = exerciseSet.toArray(new String[0]);
    // searches for name of each exercise
    for(int i = 0; i < exerciseArray.length; i++){
      if(exerciseArray[i].contains(s)){
        exerciseLoad.add(exerciseArray[i]);
      }
    }
    exerciseSet = LoadExerciseData.CUSTOM_EXERCISES.keySet();
    exerciseArray = exerciseSet.toArray(new String[0]);
    // searches for name of each exercise
    for(int i = 0; i < exerciseArray.length; i++){
      if(exerciseArray[i].contains(s)){
        exerciseLoad.add(exerciseArray[i]);
      }
    }
    Collections.sort(exerciseLoad);
    return exerciseLoad;
  }
  
  // return a sorted list of the exercise's names
  static ArrayList<String> displayExercises(HashMap<String,ExerciseData> hm){
    Set<String> exerciseSet = hm.keySet();
    ArrayList<String> exerciseList = new ArrayList<String>(exerciseSet);
    Collections.sort(exerciseList);
    return exerciseList;
  }
  // this method belongs to a different class
  // need to talk about the constructors for each exercise here, probably best to keep the
  // constructors for each type the same (Strength only has one constructor); (Stretch only has one constructor) etc
  // and use if statements and set methods inside the constructor
  static Exercise addPreloadedExercise(ExerciseData ed, int[] volume, int[] intensity, int sets) throws IllegalArgumentException{
    //fix this later, just making it work now
    Exercise e;
    if(ed.getType().equals("Cardio")){
      e = new Cardio(ed.getName(), ed.getPrimaryMuscles(),
                             ed.getSecondaryMuscles(), ed.getEquipment(),
                             ed.getMechanics(), ed.getLevel(), ed.getForce(),
                             volume[0], Intensity.LOW); // USER INPUTS, NEED TO FIGURE THIS OUT time and intensity
    }
    else if(ed.getType().equals("Stretching")){
      e = new Stretch(ed.getName(), ed.getPrimaryMuscles(),
                             ed.getSecondaryMuscles(), ed.getEquipment(),
                             ed.getMechanics(), ed.getLevel(), ed.getForce(),
                             sets, volume, new Intensity[0]); // USER INPUTS, NEED TO FIGURE THIS OUT dynamic and volume
    }
    else if(ed.getType().equals("Strength") | ed.getType().equals("Powerlifting") |
       ed.getType().equals("Plyometrics") | ed.getType().equals("Strongman") |
       ed.getType().equals("OlympicWeightlifting")){
      e = new Strength(ed.getName(), ed.getPrimaryMuscles(),
                             ed.getSecondaryMuscles(), ed.getEquipment(),
                             ed.getMechanics(), ed.getLevel(), ed.getForce(),
                             sets, volume, intensity); // USER INPUTS, NEED TO FIGURE THIS OUT
                                                                          // differentSets and sets
    }
    else{
      throw new IllegalArgumentException("Wrong type of exercise");
    }
    return e;
  }
  // create a CustomExercise if the name does not already exist in the CustomExercise hashmap
  static void createCustomExercise(ExerciseData ed){
    // adds a 1 to the name if it already exists, until it no longer exists
    // gets rid of duplicate mappings
    while(LoadExerciseData.CUSTOM_EXERCISES.containsKey(ed.getName().toUpperCase())){
      ed.name = ed.name + "1";
    }
    try {
      // use if using Android SDK
      FileWriter fw = new FileWriter(new File(MainActivity.getContext().getFilesDir(), "CustomExerciseData.txt"), true);
//      // use if using Java IDE
//      FileWriter fw = new FileWriter("CustomExerciseData.txt",true);

      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);
      pw.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", ed.getName().toUpperCase(), ed.getType(), ed.getPrimaryMuscles(),
                arrayListToQuotes(ed.getSecondaryMuscles()), arrayListToQuotes(ed.getEquipment()),
                ed.getMechanics(), ed.getLevel(), ed.getForce());
      pw.close();
      updateCustomExercises();
    }
    catch (IOException e) {
      System.out.println("createCustomExercise: Could not find CustomExerciseData.txt file");
    }
  }

  static void removeCustomExercise(String customExerciseName){
    String s = customExerciseName.toUpperCase();
    if(!(LoadExerciseData.CUSTOM_EXERCISES.containsKey(s))){
      return;
    }
    LoadExerciseData.CUSTOM_EXERCISES.remove(s);
    ExerciseData[] eds = LoadExerciseData.CUSTOM_EXERCISES.values().toArray(new ExerciseData[0]);
    try{
      PrintWriter pw = new PrintWriter(new File(MainActivity.getContext().getFilesDir(), "CustomExerciseData.txt"));
      pw.printf("name\ttype\tprimary\tsecondary\tequipment\tmechanics\tlevel\tforce\n"); // add the header row
      for(int i = 0; i < eds.length; i++){
        ExerciseData ed = eds[i];
        pw.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", ed.getName(), ed.getType(), ed.getPrimaryMuscles(),
                  arrayListToQuotes(ed.getSecondaryMuscles()), arrayListToQuotes(ed.getEquipment()),
                  ed.getMechanics(), ed.getLevel(), ed.getForce());
      }
      pw.close();
      updateCustomExercises();
    }
    catch(IOException e){
      System.out.println("CustomExerciseData.txt file was not found");
    }
  }

  static void updateCustomExercises(){
    CUSTOM_EXERCISES =  LoadExerciseData.loadCustomData();
  }

  // used in onCreate() in MainActivity, writes the files for the exercises if it doesn't already exist
  static void writeFilesIntoStorage(){
    try {
      File f;
      f = new File(MainActivity.getContext().getFilesDir(), "ExerciseDataFinal.txt");
      f.createNewFile();
      PrintWriter preloadedWriter = new PrintWriter(f, "UTF-8");
      InputStream inputStream = MainActivity.getContext().getAssets().open("ExerciseDataFinal.txt");
      Scanner s = new Scanner(inputStream);
      while (s.hasNextLine()) {
        preloadedWriter.println(s.nextLine());
      }
      preloadedWriter.close();
      s.close();
    }
    catch(IOException e){
      System.out.println("writeFilesIntoStorage(): Could not find ExerciseDataFinal.txt");
    }
    try{
      File f;
      f = new File(MainActivity.getContext().getFilesDir(), "CustomExerciseData.txt");
      f.createNewFile();
      PrintWriter customWriter = new PrintWriter(f, "UTF-8");
      InputStream inputStream = MainActivity.getContext().getAssets().open("CustomExerciseData.txt");
      Scanner s = new Scanner(inputStream);
      while (s.hasNextLine()) {
        customWriter.println(s.nextLine());
      }
      customWriter.close();
      s.close();
    }
    catch(IOException e){
      System.out.println("writeFilesIntoStorage(): Could not find CustomDataFile.txt");
    }
  }

    // Helper method
    // Used in create and removeCustomExercise to put it in the original format
    public static String arrayListToQuotes(ArrayList<String> al){
        String s = "";
        for(int i = 0; i < al.size(); i++){
            s += al.get(i);
            if(i != al.size()-1){
                s += ",";
            }
        }
        return s;
    }
    public static void main(String[] args) {
    }
}