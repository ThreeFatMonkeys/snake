import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class Game extends World
{
    static Font scratchFont, vgaFont;
    
    static int speed;
    static int gridSize;
    static int gridWidth, gridHeight;
    
    int score;
    
    boolean gameOver;
    
    public Game()
    {    
        super(gridWidth, gridHeight, gridSize);
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
            
            speed = 94;
            gridSize = 25;
            gridWidth = 25;
            gridHeight = 25;
        }
    }
    
    public void act()
    {
        if(getObjects(Food.class).isEmpty() && !gameOver)
        {
            addObject(new Food(gridSize), Greenfoot.getRandomNumber(gridWidth), Greenfoot.getRandomNumber(gridHeight));
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
