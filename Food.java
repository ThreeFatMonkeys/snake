import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Food extends GameObject
{
    public Food(int size)
    {
        image = new GreenfootImage("apple1.png");
        image.scale(size, size);
        setImage(image);
    }
    
    public boolean checkSpawn()
    {
        Snake snake = (Snake) getOneObjectAtOffset(0, 0, Snake.class);
        
        if(snake != null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
