import greenfoot.*;

public class Drop extends Particle
{
    Drop() {}
    
    Drop(boolean splatter, int width, int height)
    {
        this.splatter = splatter;
        this.speed = (Greenfoot.getRandomNumber(10) + 5) * -1;
        
        this.dx = Greenfoot.getRandomNumber(21) - 10;
        
        this.width = width/2;
        this.height = height/2;
    }
    
    public void death()
    {
        if(getY() > getWorld().getHeight() && splatter)
        {
            setLocation(getX(), getWorld().getHeight());
            for(int x = 0; x < Greenfoot.getRandomNumber(10) + 3; x++)
            {
                getWorld().addObject(new Drop(false, width, height), getX(), getY());
            }
            getWorld().removeObject(this);
        }
        else if(getY() > getWorld().getHeight())
        {
            getWorld().removeObject(this);
        }
    }
}
