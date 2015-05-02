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
        switch(getRotation())
        {
        case 270:
            prevX = getX();
            prevY = getY() + 1;
            break;
        case 90:
            prevX = getX();
            prevY = getY() - 1;
            break;
        case 0:
            prevX = getX() - 1;
            prevY = getY();
            break;
        case 180:
            prevX = getX() + 1;
            prevY = getY();
            break;
        default:
            break;
        }
        movement();
        if(isHead)
        {
            eat();
            moveTimer++;
        }
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
        else
        {
            setLocation(ahead.prevX, ahead.prevY);
        }
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