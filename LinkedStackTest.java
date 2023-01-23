// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Anthony Marraccini, amarraccini216

package towerofhanoi;

import java.util.EmptyStackException;

/**
 * 
 * @author Anthony Marraccini, amarraccini216
 * @version 10/16/2022
 *
 */
public class LinkedStackTest extends student.TestCase {
    
    private LinkedStack<String> linkedStack;
    
    /**
     * initializes objects to test 
     */
    public void setUp() {
        linkedStack = new LinkedStack<String>();
    }
    
    /**
     * tests to make sure the size method is return correct value
     */
    public void testSize() {
        assertEquals(0, linkedStack.size());
        linkedStack.push("1");
        assertEquals(1, linkedStack.size());
    }
    
    /**
     * tests to make sure the Empty method is working
     */
    public void testIsEmpty() {
        assertTrue(linkedStack.isEmpty());
        linkedStack.push("1");
        assertFalse(linkedStack.isEmpty());
    }
    
    /**
     * tests to make sure the clear method is working
     */
    public void testClear() {
        linkedStack.push("1");
        linkedStack.push("2");
        assertEquals(2, linkedStack.size());
        linkedStack.clear();
        assertEquals(0, linkedStack.size());
    }
    
    /**
     * tests to make sure the toString method is working
     */
    public void testToString() {
        assertEquals("[]", linkedStack.toString());
        linkedStack.push("1");
        linkedStack.push("2");
        assertEquals("[2, 1]", linkedStack.toString());
    }
    
    /**
     * tests to make sure the peek method is working
     */
    public void testPeek() {
        Exception thrown = null;
        try {
            assertNull(linkedStack.peek());
        }
        catch (EmptyStackException exception) {
            thrown = exception;
        }
        linkedStack.push("1");
        linkedStack.push("2");
        assertEquals("2", linkedStack.peek());
    }
    
    /**
     * tests to make sure the pop method is working
     */
    public void testPop() {
        Exception thrown = null;
        try {
            assertNull(linkedStack.pop());
        }
        catch (EmptyStackException exception) {
            thrown = exception;
        }
        linkedStack.push("1");
        linkedStack.push("2");
        assertEquals(2, linkedStack.size());
        assertEquals("2", linkedStack.pop());
        assertEquals(1, linkedStack.size());
    }
}
