import greenfoot.*;

public class Head extends Snake
{
    int moveTimer, oldDirection;
    
    public Head(int length, int size)
    {
        super(length, size);
        moveTimer = 0;
        image = new GreenfootImage(25, 25);
        image.setColor(java.awt.Color.RED);
        image.fill();
        setImage(image);
        
        oldDirection = 0;
    }
    
    public void act() 
    {
        control();
        movement();
    }
    
    public void control()
    {
        if(Greenfoot.isKeyDown("up") && oldDirection != 90)
        {
            setRotation(270);
        }
        if(Greenfoot.isKeyDown("down") && oldDirection != 270)
        {
            setRotation(90);
        }
        if(Greenfoot.isKeyDown("right") && oldDirection != 180)
        {
            setRotation(0);
        }
        if(Greenfoot.isKeyDown("left") && oldDirection != 0)
        {
            setRotation(180);
        }
    }
    
    public void movement()
    {
        Game world = (Game) getWorld();
        moveTimer++;
        if(moveTimer > 10)
        {
             // GROWING
             
             getWorld().addObject(new Snake(length, size), getX(), getY());
            
             // WALL COLLISION
             
             // MOVING
             move(1);
             oldDirection = getRotation();
             moveTimer = 0;
             
             // EATING
             
             Food apple = (Food) getOneObjectAtOffset(0, 0, Food.class);
             
             if(apple != null)
             {
                 getWorld().removeObject(apple);
                 length++;
             }
             else
             {
                 // REDUCE
                 
                 for(Object i : getWorld().getObjects(Snake.class))
                 {
                     Snake j = (Snake) i;
                     j.reduce();
                 }
             }
             
             // BODY COLLISION
             if(getOneObjectAtOffset(0, 0, Snake.class) != null)
             {
                 world.gameOver = true;
             }
        }
    }
    
    public void reduce() {}
}