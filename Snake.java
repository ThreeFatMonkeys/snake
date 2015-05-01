import greenfoot.*;
import java.awt.*;

public class Snake extends GridBasedMovement
{
    int size, moveTimer, length;
    
    int i = 0;
    
    static Snake lastBump;
    
    Snake parent;
    
    // TODO ; ADD TO CONSTRUCTOR ALLOWING FOR "SNAKE" TO FORM
    
    public Snake(int cellSize)
    {
        size = cellSize;
    }
    
    public Snake(Snake parent)
    {
        this.parent = parent;
        this.x = parent.oldX;
        this.y = parent.oldY;
        this.size = parent.size;
    }
    
    public void addedToWorld(World currentWorld)
    {
       lastBump = this;
       setup();
    }
    
    public void setup()
    {
        moveTimer = 0;
        this.x = getX();
        this.y = getY();
        oldX = x;
        oldY = y;
        GreenfootImage snake = new GreenfootImage(size, size);
        snake.setColor(Color.BLUE);
        snake.fill();
        setImage(snake);
    }
    
    public void keyListener()
    {
        if(moveTimer > 10)
        {
            if(Greenfoot.isKeyDown("up"))
            {
              Move(true, -1);
            }
            if(Greenfoot.isKeyDown("down"))
            {
                Move(true, 1);
            }
            if(Greenfoot.isKeyDown("right"))
            {
                Move(false, 1);
            }
            if(Greenfoot.isKeyDown("left"))
            {
               Move(false, -1);
            }
            moveTimer = 0;
        }
        
    }
    
    public void getBigger()
    {
        getWorld().addObject(new Snake(this), Snake.lastBump.getX(), Snake.lastBump.getY());
    }
    // dir = boolean for direction
    // True = y axis
    // false = x axis
    public void Move(boolean dir, int amount)
    {
        if(dir)
        {
            oldY = getY();
            setLocation(x, y+amount);
        }
        else
        {
            oldX = getX();
            setLocation(x+amount, y);
        }
    }
}
