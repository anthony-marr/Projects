// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Anthony Marraccini, amarraccini216

package towerofhanoi;

/**
 * 
 * @author Anthony Marraccini, amarraccini216
 * @version 10/12/2022
 *
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;
    
    /**
     * creates the stack of tower
     * @param position
     *              the position of the tower
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }
    
    /**
     * finds the position and returns it
     * @return the position of the tower
     * 
     */
    public Position position() {
        return this.position;
    }
    
    /**
     * adds the disk to the stack if it is valid
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        else if (isEmpty() || this.peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
