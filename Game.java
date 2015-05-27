import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class Game extends World
{
    static Font scratchFont, vgaFont;
    
    int score;
    
    boolean gameOver;
    
    public Game()
    {    
        super(25, 25, 25);
        gameOver = false;
        setPaintOrder(GameOverText.class, Snake.class, ScoreText.class);
    }
    
    public Game(int x, int y, int z, boolean load)
    {    
        super(x, y, z);
        gameOver = false;
        setPaintOrder(GameOverText.class, Snake.class, ScoreText.class);
        
        if(load)
        {
            try
            {
                scratchFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/scratch.ttf")).deriveFont(50f);
                vgaFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/vga.ttf")).deriveFont(50f);
            }
            catch(IOException e)
            {
                scratchFont = new Font(Font.SERIF, Font.PLAIN, 50);
                vgaFont = new Font(Font.SERIF, Font.PLAIN, 50);
            }
            catch(FontFormatException e)
            {
                scratchFont = new Font(Font.SERIF, Font.PLAIN, 50);
                vgaFont = new Font(Font.SERIF, Font.PLAIN, 50);
            }
        }
    }
    
    public void act()
    {
        if(getObjects(Food.class).isEmpty() && !gameOver)
        {
            addObject(new Food(25), Greenfoot.getRandomNumber(25), Greenfoot.getRandomNumber(25));
        }
        drawScore();
    }
    
    public void drawScore()
    {
        removeObjects(getObjects(ScoreText.class));
        addObject(new ScoreText(score), 1, 1);
    }
    
    public void fail(String why)
    {
        gameOver = true;
        //removeObjects(getObjects(GameObject.class));
        addObject(new GameOverText(why), getWidth()/2, getHeight()/2);
    }
}
