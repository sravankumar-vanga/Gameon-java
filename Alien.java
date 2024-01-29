import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Actor
{
    private int speed;
    public Alien()
    {
        getImage().scale(getImage().getWidth()/24,getImage().getHeight()/24);
    }
    public Alien(int speed)
    {
        this();
        this.speed=speed;
    }
    public void act()
    {
        move(speed);
        wrapAround();
    }

    public void wrapAround()
    {
        if(getX()==999)
        {
            setLocation(0,getY());
        }
        else if(getX()==0)
        {
            setLocation(999,getY());
        }
    }

}
