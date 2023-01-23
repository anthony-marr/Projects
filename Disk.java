// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Anthony Marraccini, amarraccini216

package towerofhanoi;

import java.awt.Color;
import student.TestableRandom;
import cs2.Shape;

/**
 * 
 * @author Anthony Marraccini, amarraccini216
 * @version 10/16/2022
 *
 */
public class Disk extends Shape implements Comparable<Disk> {
    
    /**
     * sets up the public class Disk, calls super 
     * @param width
     *              the width of disk to be created
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom rand = new TestableRandom();
        Color col = new Color(rand.nextInt(255), rand.nextInt(255), 
            rand.nextInt(255));
        this.setBackgroundColor(col);
    }
    
    /**
     * compares the disk parameter to the disk is is called on
     * @param otherDisk
     *                  disk to be compared
     * @return positive or negative integer depending on which is bigger
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        return (this.getWidth() - otherDisk.getWidth());
    }
    
    /**
     * converts the disk to string sequence
     * @return the string sequence of the stack
     */
    public String toString() {
        Integer disk1 = this.getWidth();
        return disk1.toString();
    }
    
    /**
     * sees if the parameter disk is equal to the one it was called on
     * @param obj
     *            disk to be compared
     * @return boolean that shows if the disks are equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            return (this.getWidth() == ((Disk)obj).getWidth());
        }
        return false;
    }
}
