import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Food extends Actor
{
    public void act() 
    {
        if(getOneIntersectingObject(Snake.class) != null)
        {
            getWorld().addObject(new Food(), Greenfoot.getRandomNumber(25), Greenfoot.getRandomNumber(25));
            getWorld().removeObject(this);
        }
    }    
}
