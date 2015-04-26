import greenfoot.*;
import java.awt.*;

public class Settings extends Menu
{
    public static boolean p1LeftS, p1RightS, p2LeftS, p2RightS;
     
    public Settings()
    {
        p1LeftS = false;
        p1RightS = false;
        p2LeftS = false;
        p2RightS = false;
        
        this.numMenuPos = 6;
    }
    
    public void act()
    {
        if(!p1LeftS && !p1RightS && !p2LeftS && !p2RightS)
        {
            control();
            mouseControl();
        }
        else if(keyDown)
        {
            if(!Greenfoot.isKeyDown("enter"))
            {
                Greenfoot.getKey();
                keyDown = false;
            }
        }
        else if(p1LeftS)
        {
            Game.p1Left = getControl();
            redraw();
        }
        else if(p1RightS)
        {
            Game.p1Right = getControl();
            redraw();
        }
        else if(p2LeftS)
        {
            Game.p2Left = getControl();
            redraw();
        }
        else if(p2RightS)
        {
            Game.p2Right = getControl();
            redraw();
        }
        else
        {
            p1LeftS = false;
            p1RightS = false;
            p2LeftS = false;
            p2RightS = false;
            redraw();
        }
    }
    
    public void redraw()
    {
        background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(bgColor);
        background.fill();
        
        // TITLE
        background.setFont(titleFont.deriveFont(60f));
        
        background.setColor(Color.RED);
        background.drawString("Settings", 155, 100);
       
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
        case 0: 
            background.drawString("P1 Left", 95, 195);
            break;
        case 1:
            background.drawString("P1 Right", 95, 295);
            break;
        case 2:
            background.drawString("P2 Left", 95, 395);
            break;
        case 3:
            background.drawString("P2 Right", 95, 495);
            break;
        case 4:
            background.setFont(menuFont.deriveFont(60f));
            background.drawString("Defaults", 37, 577);
            break;
        case 5:
            background.setFont(menuFont.deriveFont(60f));
            background.drawString("Back", 397, 577);
            break;
        }
        
        background.setFont(menuFont);
        background.setColor(Color.YELLOW.darker());
        background.drawString("P1 Left", 100, 200);
        background.drawString("P1 Right", 100, 300);
        background.drawString("P2 Left", 100, 400);
        background.drawString("P2 Right", 100, 500);
        background.setFont(menuFont.deriveFont(60f));
        background.drawString("Defaults", 40, 580);
        background.drawString("Back", 400, 580);
        
        // DRAW THE CONTROLS A THAT ARE CURRENTLY SET
        background.drawImage(keyImage(Game.p1Left), 450, 130);
        background.drawImage(keyImage(Game.p1Right), 450, 230);
        background.drawImage(keyImage(Game.p2Left), 450, 330);
        background.drawImage(keyImage(Game.p2Right), 450, 430);
        
        setBackground(background);
    }
    
    public GreenfootImage keyImage(String key)
    {
        GreenfootImage image = new GreenfootImage(100, 80);
        image.setColor(Color.YELLOW.darker());
        image.setFont(menuFont);
        if(key == null)
        {
            return image;
        }
        else if(key.length() == 1)
        {
            image.drawString(key.toUpperCase(), 20, 70);
        }
        else
        {
            GreenfootImage arrow = new GreenfootImage(image);
            
            arrow.fillPolygon(new int[]{10, 50, 90}, new int[]{40, 5, 40}, 3);
            arrow.fillRect(30, 40, 40, 40);
            
            if(key.equals("up"))
            {
                return arrow;
            }
            else if (key.equals("down"))
            {
                arrow.mirrorVertically();
                return arrow;
            }
            else if (key.equals("left"))
            {
                arrow.rotate(-90);
                return arrow;
            }
            else if (key.equals("right"))
            {
                arrow.rotate(90);
                return arrow;
            }
            image.drawString(key.toUpperCase(), 0, 70);
        }
        return image;
    }
    
    public String getControl()
    {
       String key = Greenfoot.getKey();
       
       if(key == null)
       {
           return key;
       }
       
       key = key.toLowerCase();
       
       if(key.equals(p1Left) || key.equals(p1Right) || key.equals(p2Left) || key.equals(p2Right))
       {
           return null;
       }
       else if(key.equals("left") || key.equals("right") || key.equals("up") || key.equals("down"))
       {
           
       }
       else if(key.length() > 1)
       {
           return null;
       }
       else if(key.equals(""))
       {
           return null;
       }
       
       p1LeftS = false;
       p1RightS = false;
       p2LeftS = false;
       p2RightS = false;
       return key;
    }
    
    public void mouseControl()
    {
        mouse = Greenfoot.getMouseInfo();
        
        if(mouse != null)
        {
            if(Greenfoot.mousePressed(null))
            {
                Greenfoot.getKey();
                selection(menuPos);
            }
            if(mouseOld != null)
            {
                if(mouse.getY() != mouseOld.getY())
                {
                    if(mouse.getY() > 150 && mouse.getY() < 250)
                    {
                        menuPos = 0;
                        redraw();
                    }
                    else if(mouse.getY() > 250 && mouse.getY() < 350)
                    {
                        menuPos = 1;
                        redraw();
                    }
                    else if(mouse.getY() > 350 && mouse.getY() < 450)
                    {
                        menuPos = 2;
                        redraw();
                    }
                    else if(mouse.getY() > 450 && mouse.getY() < 520)
                    {
                        menuPos = 3;
                        redraw();
                    }
                    else if(mouse.getY() > 520 && mouse.getX() < 300)
                    {
                        menuPos = 4;
                        redraw();
                    }
                    else if(mouse.getY() > 520 && mouse.getX() > 300)
                    {
                        menuPos = 5;
                        redraw();
                    }
                }
            }
            mouseOld = mouse;
        }
    }
    
    public void selection(int menuPos)
    {
        switch(menuPos)
        {
        case 0:
            p1LeftS = true;
            break;
        case 1:
            p1RightS = true;
            break;
        case 2:
            p2LeftS = true;
            break;
        case 3:
            p2RightS = true;
            break;
        case 4:
            p1Left = "a";
            p1Right = "d";
            p2Left = "left";
            p2Right = "right";
            redraw();
            break;
        case 5:
            Greenfoot.setWorld(new Title(true));
            break;
        }
    }
}
