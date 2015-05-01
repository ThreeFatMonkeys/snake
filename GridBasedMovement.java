import greenfoot.*;

public class GridBasedMovement extends Actor
{
    World world;
    
    public GridBasedMovement()
    {
        this.world = getWorld();
    }
    
    public int cellSize()
    {
        return world.getCellSize();
    }
}
