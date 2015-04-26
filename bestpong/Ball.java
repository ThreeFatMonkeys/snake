import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class Ball extends Actor
{
    Level1 currentlevel;
    double dx, dy;
    
    GreenfootImage image;
    
    public Ball()
    {
        dy = (Math.random()*3) + 10;
        dx = (Math.random()*3) + 2;
        
        image = new GreenfootImage(50, 50);
        image.setColor(Color.BLUE);
        image.fillOval(0, 0, 50, 50);
        setImage(image);
    }
    
    public void act() 
    {
        for(int i = 0; i<dy; i++)
        {
            checkEdge();
            checkTouch();
            setLocation(getX(), getY() + 1);
        }
        for(int i = 0; i>dy; i--)
        {
            checkEdge();
            checkTouch();
            setLocation(getX(), getY() - 1);
        }
        for(int i= 0; i<dx; i++)
        {
            checkEdge();
            checkTouch();
            setLocation(getX() + 1, getY());
        }
        for(int i= 0; i>dx; i--)
        {
            checkEdge();
            checkTouch();
            setLocation(getX() - 1, getY());
        }
    }
    
    public void checkEdge()
    {
         if(getX() > getWorld().getWidth() - (getImage().getWidth()/2))
         {
             dx *= -1;
             setLocation(getWorld().getWidth() - ((getImage().getWidth()/2) + 1), getY());
         }
         else if(getX() < (getImage().getWidth()/2))
         {
             dx *= -1;
             setLocation((getImage().getWidth()/2) + 1, getY());
         }
         else if(isAtEdge())
         {
             Level1 current = (Level1) getWorld();
              if(getY()>50)
              {
                  current.p1score++;
                  setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
                  dy = Math.random()*5;
                  dx = Math.random()*5;
                  checkScore(current);
              }
              else
              {
                  current.p2score++;
                  setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
                  dy = Math.random()*5;
                  dx = Math.random()*5;
                  checkScore(current);
              }
         }
    }
    
    public void checkScore(Level1 current)
    {
        if(current.p1score > 10)
        {
            Greenfoot.setWorld(new EndGame(current.p1));
        }
        else if(current.p2score > 10)
        {
            Greenfoot.setWorld(new EndGame(current.p2));
        }
    }
    
    public void checkTouch()
    {
         if(isTouching(Brick.class))
         {
             dy += Math.random()*3 + 8;
             
             double random = Math.random();
             
             if(random < .5)
             {
                 dx = random*40;
             }
             else
             {
                dx = random*40;
                dx *= -1;
             }
             
             dy *= -1;
             
             while(isTouching(Brick.class))
             {
                for(int i= 0; i<dy; i++)
                {
                    checkEdge();
                    setLocation(getX(), getY()+1);
                }
                for(int i= 0; i>dy; i--)
                {
                    checkEdge();
                    setLocation(getX(), getY()-1);
                }
                for(int i= 0; i<dx; i++)
                {
                    checkEdge();
                    setLocation(getX()+1, getY());
                }
                for(int i= 0; i>dx; i--)
                {
                    checkEdge();
                    setLocation(getX()-1, getY());
                }
             }
         }
    }
}
