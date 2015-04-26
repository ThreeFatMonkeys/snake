import greenfoot.*;

public class Snake extends Actor
{
    int moveTimer;
    
    public Snake()
    {
        moveTimer = 0;
    }
    
    public void act() 
    {
        movement();
        moveTimer++;
    }
    
    public void movement()
    {
        if(moveTimer > 10)
        {
            if(Greenfoot.isKeyDown("up"))
            {
                setRotation(270);
                move(1);
            }
            if(Greenfoot.isKeyDown("down"))
            {
                setRotation(90);
                move(1);
            }
            if(Greenfoot.isKeyDown("right"))
            {
                setRotation(0);
                move(1);
            }
            if(Greenfoot.isKeyDown("left"))
            {
                setRotation(180);
                move(1);
            }
            moveTimer = 0;
        }
    }
}
