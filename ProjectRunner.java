// Virginia Tech Honor Code Pledge;
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Anthony Marraccini (amarraccini216)

package towerofhanoi;

/**
 * 
 * @author Anthony Marraccini, amarraccini216
 * @version 10/16/2022
 *
 */
public class ProjectRunner {
    
    /**
     * sets up the project constructor
     */
    public ProjectRunner() {
        //hello
    }
    
    /**
     * main method sets up window for game
     * @param args
     */
    public static void main(String[] args) {
        int disks = 6;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver solver = new HanoiSolver(disks);
        PuzzleWindow window = new PuzzleWindow(solver);
        
    }
}
