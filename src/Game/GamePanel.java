package Game;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel{

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private float xDir = 1 , yDir = 1;

    private int frames = 0;
    private long lastCheck = 0;
    private Color color = new Color(132, 9, 184);
    private Random rand ;
    public GamePanel(){
        rand = new Random();
        mouseInputs = new MouseInputs(this);

        addKeyListener(new KeyboardInputs(this));//key pressed
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }


    //changing values for WASD
    public void changeXDelta(int value){
        this.xDelta += value;
    }

    public void changeYDelta(int value){
        this.yDelta += value;
    }


    //changing values for mouse motion
    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateRecatangle();
        g.setColor(color);
        g.fillRect((int) xDelta, (int)yDelta, 200, 50);
    }

    private void updateRecatangle(){
        xDelta +=xDir;
        if(xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = getRndColor();
        }

        yDelta +=yDir;
        if(yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            color = getRndColor();
        }
    }

//    public void spawnCircle(int x, int y){
//        rects
//
//    }

    private Color getRndColor(){
        int r = rand.nextInt(255);
        int b = rand.nextInt(255);
        int g = rand.nextInt(255);

        return new Color(r, g, b);
    }
}
