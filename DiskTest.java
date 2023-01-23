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
public class DiskTest extends student.TestCase {
    
    private Disk disk;
    private Disk bigDisk;
    private Disk sameDisk;
    
    /**
     * sets up objects to test Disk class
     */
    public void setUp() {
        disk = new Disk(500);
        bigDisk = new Disk(1000);
        sameDisk = new Disk(500);
    }
    
    /**
     * tests to make sure the compare to method is working
     */
    public void testCompareTo() {
        Exception thrown = null;
        try {
            assertNull(disk.compareTo(null));
        }
        catch (IllegalArgumentException exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof Exception);
        assertNotNull(disk.compareTo(bigDisk));
        assertEquals(-500, disk.compareTo(bigDisk));
    }
    
    /**
     * tests to make sure the toString to method is working
     */
    public void testToString() {
        assertNotNull(disk.toString());
        assertEquals("500", disk.toString());
    }
    
    /**
     * tests to make sure the equals to method is working
     */
    public void testEquals() {
        assertFalse(disk.equals(""));
        assertFalse((disk).equals(null));
        assertTrue((disk).equals(sameDisk));
        assertFalse((disk).equals(bigDisk));
    }
}
