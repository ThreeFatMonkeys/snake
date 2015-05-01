import greenfoot.*;

public class Game extends World
{
    public Game()
    {    
        super(25, 25, 25); 
        addObject(new Snake(getCellSize()), getWidth()/2, getHeight()/2);
    }
}
