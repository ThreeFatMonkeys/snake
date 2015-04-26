import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.io.*;

public class Game extends World
{
    static Font rofFont, proFont, kremlinFont;
    static String p1Left, p1Right, p2Left, p2Right;
    static GreenfootSound titleMusic = new GreenfootSound("spooky.wav");
    
    public Game()
    {
        super(600, 600, 1, false);
    }
    
    public Game(boolean reset)
    {
        super(600, 600, 1, false);
        
        try
        {
            rofFont = Font.createFont(Font.TRUETYPE_FONT, new File("rof.ttf")).deriveFont(50f);
            proFont = Font.createFont(Font.TRUETYPE_FONT, new File("pro.ttf")).deriveFont(50f);
            kremlinFont = Font.createFont(Font.TRUETYPE_FONT, new File("kremlin.ttf")).deriveFont(50f);
        }
        catch(IOException e)
        {
            rofFont = new Font(Font.SERIF, Font.PLAIN, 50);
            proFont = new Font(Font.SERIF, Font.PLAIN, 50);
            kremlinFont = new Font(Font.SERIF, Font.PLAIN, 50);
        }
        catch(FontFormatException e)
        {
            rofFont = new Font(Font.SERIF, Font.PLAIN, 50);
            proFont = new Font(Font.SERIF, Font.PLAIN, 50);
            kremlinFont = new Font(Font.SERIF, Font.PLAIN, 50);
        }
        
        p1Left = "a";
        p1Right = "d";
        p2Left = "left";
        p2Right = "right";
    }
}
