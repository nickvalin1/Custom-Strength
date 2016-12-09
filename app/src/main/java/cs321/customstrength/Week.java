package cs321.customstrength;

import java.util.ArrayList;

class Week {
    //optional
    String name;
    int numDays=0;
    //use an ArrayList to help with editing
    ArrayList<Day> days=new ArrayList<Day>();
    //if there is no name, feed the week number into name (i.e. "Week 2")
    //when each day is added, incriment dumDays

    Week () {
        this.name="Week";
    }

    Week (String name) {
        this.name=name;
    }

    public void addDay(Day day) {
        days.add(day);
    }

    @Override
    public String toString() {
        String repr=name+":\n";
        for (int i=0; i<days.size(); i++) {
            repr+=days.get(i).toString();
            repr+="\n";
        }
        return repr;
    }
}