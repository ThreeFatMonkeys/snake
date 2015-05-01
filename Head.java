import greenfoot.*;

public class Head extends Snake
{
    public void act() 
    {
        if(parent == null)
        {
            if(Greenfoot.isKeyDown("f") && i == 0)
            {
                getBigger();
                i++;
            }
            keyListener();
            moveTimer++;
        }
        else
        {
            setLocation(parent.oldX, parent.oldY);
        }
        
    }
}
