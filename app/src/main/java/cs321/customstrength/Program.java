package cs321.customstrength;

import java.util.ArrayList;

class Program {
    String name;
    //number of differing weeks in the program, if program does not differ by week, this value will be 1
    int numWeeks=0;
    //use ArrayList to make editing easier
    //when each week is added, incriment numWeeks
    ArrayList<Week> weeks=new ArrayList<Week>();

    public Program(String name) {
        this.name=name;
    }

    public void addWeek(Week week) {
        weeks.add(week);
    }

    public String toString() {
      return name;
  }

    public String toStringExpanded() {
        String repr=name+":\n";
        for (int i=0; i<weeks.size(); i++) {
            repr+=weeks.get(i).toString();
        }
        return repr;
    }
}