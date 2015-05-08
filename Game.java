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
    }
    
    public void fail(String why)
    {
        gameOver = true;
        addObject(new Text(why), getWidth()/2, getHeight()/2);
    }
}
