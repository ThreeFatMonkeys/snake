import greenfoot.*;
import java.awt.*;

public class BouncingWord extends Ball
{
    public BouncingWord(String text, int x, int y)
    {
        image = new GreenfootImage(x, y);
        image.setFont(Game.kremlinFont);
        image.setColor(Color.RED);
        image.drawString(text, 0, y);
        setImage(image);
    }
    
    public void checkEdge()
    {
         if(getX() > getWorld().getWidth() - (getImage().getWidth()/2))
         {
             dx *= -1;
             setLocation(getWorld().getWidth() - (getImage().getWidth()/2 + 1), getY());
         }
         else if(getX() < (getImage().getWidth()/2))
         {
             dx *= -1;
             setLocation((getImage().getWidth()/2) + 1, getY());
         }
         else if(getY() < (getImage().getHeight()/2))
         {
             dy *= -1;
             setLocation(getX(), (getImage().getHeight()/2) + 1);
         }
         else if(getY() > getWorld().getHeight() - (getImage().getHeight()/2))
         {
             dy *= -1;
             setLocation(getX(), getWorld().getHeight() - (getImage().getHeight()/2 + 1));
         }
    }
}
