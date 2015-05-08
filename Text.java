import greenfoot.*;

public class Text extends Actor
{
    GreenfootImage image;
    
    public Text(String text)
    {
        image = new GreenfootImage(text, 50, java.awt.Color.RED, null);
        
        setImage(image);
    }
}
