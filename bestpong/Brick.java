import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class Brick extends Actor
{
    String left, right;
    GreenfootImage image;
    
    Brick(String left, String right, Color color)
    {
        this.left = left;
        this.right = right;
        
        image = new GreenfootImage(150, 10);
        image.setColor(color);
        image.fill();
        setImage(image);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown(left))
        {
            setLocation(getX()-10, getY());
        }
        if(Greenfoot.isKeyDown(right))
        {
            setLocation(getX()+10, getY());
        }
    }
  
    
    
}
