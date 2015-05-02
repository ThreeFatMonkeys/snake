import greenfoot.*;

public class Snake extends Actor
{
    int moveTimer;
    GreenfootImage image;
    
    boolean isHead;
    Snake ahead;
    int prevX, prevY;
    
    public Snake()
    {
        moveTimer = 0;
        image = new GreenfootImage(25, 25);
        image.fill();
        setImage(image);
        isHead = true;
    }
    
    public Snake(Snake follow)
    {
        moveTimer = 0;
        image = new GreenfootImage(25, 25);
        image.fill();
        setImage(image);
        isHead = false;
        ahead = follow;
    }
    
    public void act() 
    {
        movement();
        if(isHead)
        {
            eat();
            moveTimer++;
        }
        prevX = getX();
        prevY = getY();
    }
    
    public void movement()
    {
        if(isHead)
        {
            if(moveTimer > 10)
            {
                if(Greenfoot.isKeyDown("up"))
                {
                    setRotation(270);
                }
                if(Greenfoot.isKeyDown("down"))
                {
                    setRotation(90);
                }
                if(Greenfoot.isKeyDown("right"))
                {
                    setRotation(0);
                }
                if(Greenfoot.isKeyDown("left"))
                {
                    setRotation(180);
                }
                move(1);
                moveTimer = 0;
            }
        }
        /*else
        {
            setLocation(ahead.prevX, ahead.prevY);
        }*/
    }
    
    public void eat()
    {
        if(getOneIntersectingObject(Food.class) != null)
        {
            grow();
        }
    }
    
    public void grow()
    {
        getWorld().addObject(new Snake(this), prevX, prevY);
    }
}