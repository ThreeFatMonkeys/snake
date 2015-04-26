import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class Level1 extends Game
{
    GreenfootImage background;
    Font scoreFont;
    
    Brick p1, p2;
    
    int p1score;
    int p2score;
    
    public Level1()
    {
       setup();
       scoreFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
       redraw();
    }
    
    public void act()
    {
        redraw();
    }
    
    public void setup()
    {
        p1 = new Brick(Game.p1Left, Game.p1Right, Color.RED);
        addObject(p1, getWidth()/2, getHeight() - 10);
        p2 = new Brick(Game.p2Left, Game.p2Right, Color.GREEN);
        addObject(p2, getWidth()/2, 10);
        Ball ball = new Ball();
        addObject(ball, 300, 200);
        
        p1score = 0;
        p2score = 0;
    }
    
    public void redraw()
    {
       background = new GreenfootImage(600, 600);
       background.setColor(Color.WHITE);
       background.fill();
       background.setColor(Color.BLUE);
       background.setFont(scoreFont);
       background.drawString("Player 1: " + p1score, 25, 30);
       background.drawString("Player 2: " + p2score, 400, 30);
       setBackground(background);
    }
}
