import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Credits extends Menu
{
    public Credits()
    {
        super(false);
        setup(1);
        redraw();
    }
    
    public void redraw()
    {
        // SOMEONE MAKE THIS LOOK MORE FANCY
        
        background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(Color.GRAY.darker().darker());
        background.fill();
        
        background.setColor(Color.RED);
        background.setFont(menuFont);
        background.drawString("JACKSON AND LIAM\nAND CHINMAY", 0, 100);
        
        setBackground(background);
    }
}
