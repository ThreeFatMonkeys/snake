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
        image = new GreenfootImage(Game.gridSize, Game.gridSize);
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
            moveTimer++;
            if(moveTimer > 100)
            {
                Greenfoot.setWorld(new Title(false));
            }
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
        if(moveTimer > 101 - Game.speed)
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
                        world.fail("GAME OVER\nYou hit the right wall");
                    }
                    break;
                 case 90 : 
                    if(getY() > world.getHeight() - 2)
                    {
                        world.fail("GAME OVER\nYou hit the bottom wall");
                    }
                    break;
                 case 180 : 
                    if(getX() < 1)
                    {
                        world.fail("GAME OVER\nYou hit the left wall");
                    }
                    break;
                 case 270 : 
                    if(getY() < 1)
                    {
                        world.fail("GAME OVER\nYou hit the top wall");
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
                     world = (Game) getWorld();
                     world.removeObject(apple);
                     world.score++;
                     
                     for(Object i : getWorld().getObjects(Snake.class))
                     {
                         Snake j = (Snake) i;
                         j.grow(Game.increase);
                     }
                 }
                 
                 for(Object i : getWorld().getObjects(Snake.class))
                 {
                     Snake j = (Snake) i;
                     j.reduce();
                 }
                 
                 // BODY COLLISION
                 if(getOneObjectAtOffset(0, 0, Snake.class) != null)
                 {
                     world.fail("GAME OVER\nYou ate your own body");
                 }
            }
        }
    }
    
    public void reduce() {}
}