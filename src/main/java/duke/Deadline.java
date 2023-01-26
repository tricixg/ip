package duke;
import java.util.ArrayList;

import util.DukeException;

public class Deadline extends Task {

    protected String by;
    static String divider = "    ═══*.·:·.☽✧    ✦    ✧☾.·:·.*═══";

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public static void createDeadlineTask(ArrayList<Task> array, String[] splitInput) {
        if (splitInput.length == 1 || splitInput[1].equals("")){
            try {
                throw new DukeException("deadline");
            } catch (Exception e) {
                System.out.println(divider);
                System.out.println(e.toString());
                System.out.println(divider);
            }
        } else {
            for(int j=1; j< splitInput.length; j++){
                if(splitInput[j].equals("/by")){
                    for (int k=1; k< j-1; k++){
                        splitInput[1] = splitInput[1] + " " + splitInput[k+1];
                    }
                    for (int l=splitInput.length-1; l > j +1; l--){
                        splitInput[splitInput.length-1] = splitInput[l-1]+" "+splitInput[splitInput.length-1];
                    }
                } else {
                    splitInput[j] = splitInput[j];
                }
            }
               
            String date = splitInput[splitInput.length-1];
            String desc = splitInput[1];
            Deadline d = new Deadline(desc, date);
            array.add(d);
            System.out.println(divider);
            System.out.println("     Got it. I've added this task:");
            System.out.println("     " + d.toString());
            System.out.println("     Now you have " + array.size() + " tasks in the list.");
            System.out.println(divider);
           
        }
        
    }
}