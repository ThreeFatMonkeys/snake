import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Snake extends GameObject
{
    int length;
    
    public Snake(int length, int size)
    {
        this.length = length;
        this.size = size;
        
        image = new GreenfootImage(size, size);
        image.setColor(java.awt.Color.BLACK);
        image.fill();
        setImage(image);
    }
    
    public void reduce()
    {
        length--;
        if(length < 1)
        {
            getWorld().removeObject(this);
        }
    }
    
    public void grow(int x)
    {
        length += x;
    }
}
