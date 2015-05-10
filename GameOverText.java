import greenfoot.*;

public class GameOverText extends Text
{
    public GameOverText(String text)
    {
        image = new GreenfootImage(text + "\n:(", 50, java.awt.Color.RED, null);
        
        setImage(image);
    }
}
