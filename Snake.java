import greenfoot.*;

public class Snake extends Actor
{
    int moveTimer;
    GreenfootImage image;
    
    boolean isHead, hasChild;
    Snake parent, child;
    int prevX, prevY;
    
    public Snake()
    {
        moveTimer = 0;
        image = new GreenfootImage(25, 25);
        image.setColor(java.awt.Color.RED);
        image.fill();
        setImage(image);
        isHead = true;
        hasChild = false;
        prevX = 0;
        prevY = 0;
    }
    
    public Snake(Snake follow)
    {
        moveTimer = 0;
        image = new GreenfootImage(25, 25);
        image.fill();
        setImage(image);
        isHead = false;
        parent = follow;
        hasChild = false;
        prevX = 0;
        prevY = 0;
    }
    
    public void act() 
    {
        /*switch(getRotation())
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
        }*/
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
                prevX = getX();
                prevY = getY();
                move(1);
                moveTimer = 0;
            }
        }
        else
        {
            prevX = getX();
            prevY = getY();
            setLocation(parent.prevX, parent.prevY);
        }

    }
    
    public void eat()
    {
        if(getOneIntersectingObject(Food.class) != null)
        {
            if(hasChild)
            {
                child.grow();
            }
            else
            {
                grow();
            }
        }
    }
    
    public void grow()
    {
        child = new Snake(this);
        getWorld().addObject(child, prevX, prevY);
        hasChild = true;
    }
}