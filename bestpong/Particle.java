import greenfoot.*;
import java.awt.*;

public class Particle extends Actor
{
    int width, height;
    
    int speed, direction, rotation, spin, gravity, dx;
    
    boolean splatter, falling;
    
    GreenfootImage image;
    
    public Particle()
    {
        width = Greenfoot.getRandomNumber(11) + 5;
        height = Greenfoot.getRandomNumber(11) + 5;
        
        gravity = Greenfoot.getRandomNumber(5) + 1;
        
        rotation = Greenfoot.getRandomNumber(360);
        
        do
        {
            spin = Greenfoot.getRandomNumber(11) - 5;
        }while(spin == 0);
        
        splatter = true;
        falling = true;
        
        direction = 90;
        
        dx = 0;
        
        image = new GreenfootImage(width, height);
        image.setColor(Color.RED);
        image.fillOval(0, 0, width, height);
        
        setImage(image);
    }
    
    
    public void act() 
    {
        movement();
        death();
    } 
    
    public void movement()
    {
        setRotation(direction);
        move(speed);
        
        if(falling)
        {
            speed += gravity;
        }
        
        setLocation(getX() + dx, getY());
        
        rotation += spin;
        setRotation(rotation);
    }
    
    public void death()
    {
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
