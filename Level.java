import greenfoot.*;

public class Level extends Game
{
    public Level()
    {
        addObject(new Head(1, 25), 12, 12);
        addObject(new Food(25), Greenfoot.getRandomNumber(25), Greenfoot.getRandomNumber(25));
        drawScore();
    }
}
