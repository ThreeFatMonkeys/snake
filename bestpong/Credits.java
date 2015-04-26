import greenfoot.*;
import java.awt.*;

public class Credits extends Menu
{
    int movement;
    int color;
    int backcolor;
    boolean colordir;
    
    public Credits()
    {
        redraw();
        color = 255;
        numMenuPos = 1;
    }
    
    public void behavior()
    {
        redraw();
    }
    
    public void control()
    {
        if(Greenfoot.isKeyDown("enter") && !keyDown)
        {
           keyDown = true;
           Greenfoot.setWorld(new Title(false));
        }
        else if(!Greenfoot.isKeyDown("enter") && keyDown)
        {
            keyDown = false;
        }
    }
    
    public void redraw()
    {
        background = new GreenfootImage(getWidth(), getHeight());
        background.setFont(kremlinFont);
        
        if(color % 10 == 0)
        {
            backcolor = color;
            background.setColor(new Color(backcolor, 255, 255));
            background.fill();
        }
        else
        {
            background.setColor(new Color(backcolor,255,255));
            background.fill();
        }
        
        background.setColor(new Color(color, 255, color));
        background.drawString("Creator : Liam", getWidth()/2-200, getHeight()/2);
        background.scale(Greenfoot.getRandomNumber(100)+getWidth(),Greenfoot.getRandomNumber(100)+getHeight());
       
        if(colordir)
        {
            color--;
        }
        else if(!colordir)
        {
            color++;
        }
            
        if(color < 1)
        {
            colordir = false;
            color = 1;
        }
        else if(color > 255)
        {
            colordir = true;
            color = 255;
        }
        setBackground(background);
    }
}
