// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Anthony Marraccini, amarraccini216

package towerofhanoi;

import java.util.Observable;

/**
 * 
 * @author Anthony Marraccini, amarraccini216
 * @version 10/16/2022
 *
 */
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    
    /**
     * sets up the hanoisolver class
     * @param numDisks
     *              the number of disks
     */
    public HanoiSolver(int numDisks) {
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
        this.numDisks = numDisks;
    }
    
    /**
     * returns the number of disks
     * @return the number of disks in the solver
     */
    public int disks() {
        return numDisks;
    }
    
    /**
     * finds the tower based of of its position
     * @param pos
     *          position of tower
     * @return whatever tower corresponds with position
     */
    public Tower getTower(Position pos) {
        switch(pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;    
        }
    }
    
    /**
     * returns the towers in string sequence
     * @return towers in sequence of string
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(left.toString());
        s.append(middle.toString());
        s.append(right.toString());
        return s.toString();
    }
    
    /**
     * moves the disks
     * @param source
     *          tower where disk has come from
     * @param destination
     *          tower where the disk lands
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        this.setChanged();
        this.notifyObservers(destination.position());
    }
    
    /**
     * solves the towers
     * @param currentDisks
     *              the number of disks 
     * @param startPole
     *              where the disk stars
     * @param tempPole
     *              temporary placeholder
     * @param endPole
     *              where the disk ends up
     */
    private void solveTowers(int currentDisks, Tower startPole,
        Tower tempPole, Tower endPole) {
        if (currentDisks < 1) {
            throw new IllegalStateException();
        }
        else if (currentDisks == 1) {
            this.move(startPole, endPole);
        }
        
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }
    
    /**
     * calls solvetowers with all specified parameters
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }
}
