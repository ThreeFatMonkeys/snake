import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Game extends World
{
    boolean gameOver;
    int score;
    
    public Game()
    {    
        super(25, 25, 25);
        gameOver = false;
        setPaintOrder(GameOverText.class, Snake.class, ScoreText.class);
        addObject(new Head(1, 25), 12, 12);
        addObject(new Food(25), Greenfoot.getRandomNumber(25), Greenfoot.getRandomNumber(25));
        drawScore();
    }
    
    public void act()
    {
        if(getObjects(Food.class).isEmpty() && !gameOver)
        {
            addObject(new Food(25), Greenfoot.getRandomNumber(25), Greenfoot.getRandomNumber(25));
        }
        drawScore();
    }
    
    public void drawScore()
    {
        removeObjects(getObjects(ScoreText.class));
        addObject(new ScoreText(score), 1, 1);
    }
    
    public void fail(String why)
    {
        gameOver = true;
        //removeObjects(getObjects(GameObject.class));
        addObject(new GameOverText(why), getWidth()/2, getHeight()/2);
    }
}
