import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Food extends GameObject
{
    public Food(int size)
    {
        image = new GreenfootImage("apple1.png");
        image.scale(size, size);
        setImage(image);
    }
}
