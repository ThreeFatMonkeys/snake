import greenfoot.*;
import java.awt.*;

public class Menu extends Game
{
    static boolean keyDown;
    
    static greenfoot.MouseInfo mouse, mouseOld;
    
    int menuPos, numMenuPos;
    
    Font titleFont, menuFont;
    
    GreenfootImage background;
    
    Color bgColor;
    
    public Menu(boolean load)
    {
        super(500, 500, 1, load);
        menuPos = 0;
        mouseOld = Greenfoot.getMouseInfo();
        
        redraw();
    }
    
    public void act()
    {
        behavior();
        control();
        mouseControl();
    }
    
    public void control()
    {
        if(Greenfoot.isKeyDown("down") && !keyDown)
        {
            keyDown = true;
            menuPos++;
            redraw();
        }
        else if(Greenfoot.isKeyDown("up")  && !keyDown)
        {
            keyDown = true;
            menuPos--;
            redraw();
        }
        else if(Greenfoot.isKeyDown("enter") && !keyDown)
        {
           keyDown = true;
           selection(menuPos);
        }
        else if(!Greenfoot.isKeyDown("down") && !Greenfoot.isKeyDown("up") && !Greenfoot.isKeyDown("enter"))
        {
            keyDown = false;
        }
    }
    
    public void mouseControl()
    {
        if(Greenfoot.mousePressed(null))
        {
           Greenfoot.setWorld(new Title(false));
        }
    }
    
    public void redraw() {}
    
    public void selection(int menuPos)
    {
        Greenfoot.setWorld(new Title(false));
    }
    
    public void behavior() {}
}

