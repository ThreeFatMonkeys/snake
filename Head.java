import greenfoot.*;

public class Head extends Snake
{
    int moveTimer, oldDirection;
    
    Game world;
    
    GreenfootImage deadImage;
    
    public Head(int length, int size)
    {
        super(length, size);
        moveTimer = 0;
        image = new GreenfootImage(25, 25);
        image.setColor(java.awt.Color.RED);
        image.fill();
        setImage(image);
        
        deadImage = new GreenfootImage(image);
        deadImage.setColor(java.awt.Color.RED.darker().darker());
        deadImage.fill();
        
        oldDirection = 0;
    }
    
    public void act() 
    {
        world = (Game) getWorld();
        if(!world.gameOver)
        {
            control();
            movement();
        }
        else
        {
            setImage(deadImage);
        }
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
        moveTimer++;
        if(moveTimer > 10)
        {
             // GROWING
             
             getWorld().addObject(new Snake(length, size), getX(), getY());
             
             // SETTING OLD DIRECTION
             oldDirection = getRotation();
             
             // WALL COLLISION
             switch(oldDirection)
             {
                 case 0 : 
                    if(getX() > world.getWidth() - 2)
                    {
                        world.fail("Went off Right Side");
                    }
                    break;
                 case 90 : 
                    if(getY() > world.getHeight() - 2)
                    {
                        world.fail("Went out the bottom");
                    }
                    break;
                 case 180 : 
                    if(getX() < 1)
                    {
                        world.fail("Went off Left Side");
                    }
                    break;
                 case 270 : 
                    if(getY() < 1)
                    {
                        world.fail("Went too high");
                    }
                    break;
             }
             
             if(!world.gameOver)
             {
             
                 // MOVING
                 move(1);
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
                     world.fail("Hit your own body.");
                 }
            }
        }
    }
    
    public void reduce() {}
}