import greenfoot.*;
import java.awt.*;

public class Title extends Menu
{    
    Color bgColor;
    
    int lightMax, lightMin, lightRate;
    boolean lightDirection;
   
    int tick;
    
    public Title()
    {
        super(true);
        tick = 0;
        
        lightMax = 150;
        lightMin = 50;
        lightRate = 10;
        lightDirection = true;
        
        bgColor = Color.GRAY;
        
        numMenuPos = 3;
        
        redraw();
    }
    
    public Title(boolean dontReset)
    {
        tick = 0;
        
        lightMax = 150;
        lightMin = 50;
        lightRate = 10;
        lightDirection = true;
        
        bgColor = Color.GRAY;
        
        numMenuPos = 3;
        
        redraw();
    }
    
    public void behavior()
    {
        if(!Game.titleMusic.isPlaying())
        {
            Game.titleMusic.play();
        }
        
        addObject(new Drop(), Greenfoot.getRandomNumber(getWidth()), 0);
        
        tick++;
        if(tick > 10)
        {
            repaint();
            redraw();
            tick = 0;
        }
    }
    
    public void selection(int menuPos)
    {
        
        switch(menuPos)
        {
        case 0:
            Greenfoot.setWorld(new Level1());
            break;
        case 1:
            Greenfoot.setWorld(new Settings());
            break;
        case 2:
            Greenfoot.setWorld(new Credits());
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
    
    public void repaint()
    {
        if(bgColor.getRed() > lightMax)
        {
            lightDirection = false;
        }
        else if(bgColor.getRed() < lightMin)
        {
            lightDirection = true;
        }
        
        if(lightDirection)
        {
            bgColor = new Color(bgColor.getRed() + lightRate, bgColor.getGreen() + lightRate, bgColor.getBlue() + lightRate);
        }
        else
        {
            bgColor = new Color(bgColor.getRed() - lightRate, bgColor.getGreen() - lightRate, bgColor.getBlue() - lightRate);
        }
    }
    
    public void redraw()
    {
        background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(bgColor);
        background.fill();
        
        
        // TITLE
        background.setFont(titleFont);
        
        background.setColor(Color.RED);
        background.drawString("PONG", 25, 190);
        
        background.setColor(Color.BLACK);
        background.drawString("PONG", 30, 180);
        
        
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
            background.drawString("Play", 215, 305);
            break;
            case 1 :
            background.drawString("Settings", 145, 405);
            break;
            case 2 :
            background.drawString("Credits", 165, 505);
            break;
        }
        
        background.setColor(Color.YELLOW.darker());
        background.drawString("Play", 220, 300);
        background.drawString("Settings", 150, 400);
        background.drawString("Credits", 170, 500);
        
        
        setBackground(background);
    }
}
