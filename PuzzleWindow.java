// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Anthony Marraccini, amarraccini216

package towerofhanoi;

import java.util.Observable;
import java.util.Observer;
import cs2.Shape;
import cs2.Window;
import java.awt.Color;
import cs2.Button;
import cs2.WindowSide;

/**
 * 
 * @author Anthony Marraccini, amarraccini216
 * @version 10/17/2022
 *
 */
public class PuzzleWindow implements Observer {
    private HanoiSolver game;
    private Shape left;
    private Shape leftBase;
    private Shape right;
    private Shape rightBase;
    private Shape middle;
    private Shape middleBase;
    private Window window;
    private Button buttonSolve;
    public static final int WIDTH_FACTOR = 8;
    public static final int DISK_GAP = (int)0.75;
    public static final int DISK_HEIGHT = 10;
    
    /**
     * sleep pauses between disks
     */
    private void sleep() {
        try {
            Thread.sleep(83 * this.game.disks());
        }
        catch (Exception e) {
        }
    }
    
    /**
     * if solve is clicked, it calls the program to solve the towers
     * @param button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
    
    /**
     * Moves disk from one pole to next
     * @param position
     *              shows which pole it is currently on
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole = null;
        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            case RIGHT:
                currentPole = right;
                break;
            case DEFAULT:
                currentPole = left;
                break;
        }
        int x = currentPole.getX() + currentPole.getWidth() / 2
            - currentDisk.getWidth() / 2;
        int y = currentPole.getY() + currentPole.getHeight()
        - (game.getTower(position).size() * (currentDisk.getHeight()
            + DISK_GAP));
        currentDisk.moveTo(x, y);         
    }
    
    /**
     * Sets up puzzle window class
     * @param game
     *          the HanoiSolver 
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        int dynamicPole = (DISK_HEIGHT + DISK_GAP + 1) * game.disks();
        left = new Shape(200, 100 + (100 - dynamicPole), 5, dynamicPole,
            new Color(0, 0, 0));
        middle = new Shape(300, 100 + (100 - dynamicPole), 5, dynamicPole,
            new Color(0, 0, 0));
        right = new Shape(400, 100 + (100 - dynamicPole), 5, dynamicPole, 
            new Color(0, 0, 0));
        leftBase = new Shape(165, 200, 75, 5, new Color(0, 0, 0));
        middleBase = new Shape(265, 200, 75, 5, new Color(0, 0, 0));
        rightBase = new Shape(365, 200, 75, 5, new Color(0, 0, 0));      
        
        for (int i = game.disks(); i > 0; i--) {
            Disk disk = new Disk(leftBase.getWidth() - (WIDTH_FACTOR * 
                (game.disks() - (i - 1))));
            game.getTower(Position.LEFT).push(disk);
            window.addShape(game.getTower(Position.LEFT).peek());
            moveDisk(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        window.addShape(leftBase);
        window.addShape(middleBase);
        window.addShape(rightBase);
        buttonSolve = new Button("Solve");
        buttonSolve.onClick(this, "clickedSolve");
        window.addButton(buttonSolve, WindowSide.NORTH);
    }
    
    /**
     * updates the disk position after it is moved
     */
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position pos = (Position)arg;
            moveDisk(pos);
            sleep();
        }
    }
}
