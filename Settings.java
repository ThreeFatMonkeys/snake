import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Settings extends Menu
{
    public Settings()
    {
        super(false);
        setup(9);
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
        background.drawString("SETTINGS PAGE INCOMPLRETE", 0, 100);
        
        setBackground(background);
    }
}
