import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Game extends World
{
    public Game()
    {    
        super(25, 25, 25);
        addObject(new Snake(), 12, 12);
        addObject(new Food(), Greenfoot.getRandomNumber(25), Greenfoot.getRandomNumber(25));
    }
}
