import greenfoot.*;

public class Level extends Game
{
    public Level()
    {
        addObject(new Head(1, gridSize), 12, 12);
        addObject(new Food(gridSize), Greenfoot.getRandomNumber(gridWidth), Greenfoot.getRandomNumber(gridHeight));
        drawScore();
    }
}
