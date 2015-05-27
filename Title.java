import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

public class Title extends Menu
{
    public Title()
    {
        super(true);
        setup();
        redraw();
    }
    
    public Title(boolean load)
    {
        super(load);
        setup();
        redraw();
    }
    
    public void setup()
    {
        numMenuPos = 3;
        titleFont = scratchFont.deriveFont(200f);
        menuFont = vgaFont.deriveFont(50f);
    }
    
    public void selection(int menuPos)
    {
        
        switch(menuPos)
        {
        case 0:
            Greenfoot.setWorld(new Level());
            break;
        case 1:
            // SETTINGS
            break;
        case 2:
            // CREDITS
            break;
        }
    }
    
    public void mouseControl()
    {
        mouse = Greenfoot.getMouseInfo();
        
        if(mouse != null)
        {
            if(Greenfoot.mousePressed(null))
            {
                selection(menuPos);
            }
            if(mouseOld != null)
            {
                if(mouse.getY() != mouseOld.getY())
                {
                    if(mouse.getY() > 230 && mouse.getY() < 320 && mouse.getX() > 200 && mouse.getX() < 380)
                    {
                        menuPos = 0;
                        redraw();
                    }
                    else if(mouse.getY() > 330 && mouse.getY() < 420 && mouse.getX() > 130 && mouse.getX() < 430)
                    {
                        menuPos = 1;
                        redraw();
                    }
                    else if(mouse.getY() > 430 && mouse.getY() < 520 && mouse.getX() > 130 && mouse.getX() < 430)
                    {
                        menuPos = 2;
                        redraw();
                    }
                }
            }
            mouseOld = mouse;
        }
    }
    
    public void redraw()
    {
        background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(Color.WHITE);
        background.fill();
        
        
        // TITLE
        
        background.setFont(titleFont);
        
        background.setColor(Color.RED);
        background.drawString("SNAKE", 25, 190);
        
        background.setColor(Color.BLACK);
        background.drawString("SNAKE", 30, 180);
        
        
        // MENU OPTIONS
        background.setFont(menuFont);
        
        if(menuPos > numMenuPos - 1)
        {
            menuPos -= numMenuPos;
        }
        else if(menuPos < 0)
        {
            menuPos += numMenuPos;
        }
        
        background.setColor(Color.RED);
        
        switch(menuPos)
        {
            case 0 : 
            background.drawString("Play", 217, 303);
            break;
            case 1 :
            background.drawString("Settings", 147, 383);
            break;
            case 2 :
            background.drawString("Credits", 167, 463);
            break;
        }
        
        background.setColor(Color.YELLOW.darker());
        background.drawString("Play", 220, 300);
        background.drawString("Settings", 150, 380);
        background.drawString("Credits", 170, 460);
        
        
        setBackground(background);
    }
    
}
