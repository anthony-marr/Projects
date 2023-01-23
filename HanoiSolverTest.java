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
 * @version 10/17/2022
 *
 */
public class HanoiSolverTest extends student.TestCase {
    private HanoiSolver solver;
    private Disk largeDisk;
    private Disk mediumDisk;
    private Disk smallDisk;
    
    /**
     * sets up objects to test HanoiSolver
     */
    public void setUp() {
        solver = new HanoiSolver(3);
        largeDisk = new Disk(500);
        mediumDisk = new Disk(300);
        smallDisk = new Disk(100);
    }
    
    /**
     * tests to make sure the disks method is returning correct value
     */
    public void testDisks() {
        assertEquals(3, solver.disks());
    }
    
    /**
     * tests to make sure the getTower method is returning correct value
     */
    public void testGetTower() {
        assertTrue(solver.getTower(Position.LEFT).position(
            ).equals(Position.LEFT));
        assertTrue(solver.getTower(Position.RIGHT).position(
            ).equals(Position.RIGHT));
        assertTrue(solver.getTower(Position.MIDDLE).position(
            ).equals(Position.MIDDLE));
        assertTrue(solver.getTower(Position.DEFAULT).position(
            ).equals(Position.MIDDLE));
    }
    
    /**
     * tests to make sure the ToString method is returning correct value
     */
    public void testToString() {
        solver.getTower(Position.LEFT).push(smallDisk);
        assertEquals("[100][][]", solver.toString());
        solver.getTower(Position.MIDDLE).push(mediumDisk);
        assertEquals("[100][300][]", solver.toString());
        solver.getTower(Position.RIGHT).push(largeDisk);
        assertEquals("[100][300][500]", solver.toString());
    }
    
    /**
     * tests to make sure the solve method is working
     */
    public void testSolve() {
        HanoiSolver nullSolver = new HanoiSolver(0);
        Exception thrown = null;
        try {
            nullSolver.solve();
        }
        catch (IllegalStateException exception) {
            thrown = exception;
        }
        
        HanoiSolver singleSolver = new HanoiSolver(1);
        singleSolver.getTower(Position.LEFT).push(smallDisk);
        assertEquals("[100][][]", singleSolver.toString());
        singleSolver.solve();
        assertEquals("[][][100]", singleSolver.toString());
        
        solver.getTower(Position.LEFT).push(largeDisk);
        solver.getTower(Position.LEFT).push(mediumDisk);
        solver.getTower(Position.LEFT).push(smallDisk);
        solver.solve();
        assertEquals("[][][100, 300, 500]", solver.toString());
    }
}
