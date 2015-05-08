import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Game extends World
{
    boolean gameOver;
    
    public Game()
    {    
        super(25, 25, 25);
        gameOver = false;
        setPaintOrder(Head.class);
        addObject(new Head(1, 25), 12, 12);
        addObject(new Food(25), Greenfoot.getRandomNumber(25), Greenfoot.getRandomNumber(25));
    }
    
    public void act()
    {
        if(getObjects(Food.class).isEmpty())
        {
            addObject(new Food(25), Greenfoot.getRandomNumber(25), Greenfoot.getRandomNumber(25));
        }
        
        if(gameOver)
        {
            Greenfoot.stop();
        }
    }
}
