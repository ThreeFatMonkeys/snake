import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreText extends Text
{
    public ScoreText(int score)
    {
        image = new GreenfootImage(""+score, 50, java.awt.Color.RED, null);
        setImage(image);
    } 
}
