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
 * @version 10/16/2022
 *
 */
public class TowerTest extends student.TestCase {
    private Tower tower;
    private Disk disk;
    
    /**
     * sets up objects to help test
     */
    public void setUp() {
        tower = new Tower(Position.LEFT);
        disk = new Disk(100);
    }
    
    /**
     * tests to make sure the position to method is working
     */
    public void testPosition() {
        assertEquals(Position.LEFT, tower.position());
    }
    
    /**
     * tests to make sure the push method is working
     */
    public void testPush() {
        Tower nullTower = new Tower(Position.LEFT);
        Exception thrown3 = null;
        try {
            nullTower.push(null);
        }
        catch (IllegalArgumentException exception) {
            thrown3 = exception;
        }
        
        assertTrue(tower.isEmpty());
        tower.push(disk);
        assertFalse(tower.isEmpty());
        
        Disk largeDisk = new Disk(1000);
        Exception thrown1 = null;
        try {
            tower.push(largeDisk);
        }
        catch (IllegalStateException exception) {
            thrown1 = exception;
        }
        
        tower.clear();
        assertTrue(tower.isEmpty());
        tower.push(largeDisk);
        tower.push(disk);
        assertEquals(disk, tower.peek());
        
    }
}
