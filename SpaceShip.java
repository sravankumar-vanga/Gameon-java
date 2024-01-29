import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceShip extends Actor
{
    private int speed;
    private int timeCounter=0;
    private static final int reloadTime=80;
    private int rotation;
    public static int score=0;
    public SpaceShip(int speed,int rotation)
    {
        this.speed=speed;
        this.rotation=rotation;
    }

    public void act()
    {
        timeCounter++;
        move(speed);
        WrapAround();
        upSideDownSide();
        rotateCW();
        rotateACW();
        fire();
    }
    public void move(int distance)
    {
        setImage("withoutbooster.png");
        if(Greenfoot.isKeyDown("right"))
        {
            setImage("rocket.png");
            setLocation(getX()+distance,getY());
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-distance,getY());
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-distance);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+distance);
        }
        
    }
    public void WrapAround()
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
    public void upSideDownSide()
    {
        if(getY()==0)
        {
            setLocation(getY(),499);
        }
        else if(getY()==499)
        {
            setLocation(getX(),0);
        }
    }
    public void rotateCW()
    {
        if(Greenfoot.isKeyDown("q"))
        {
            turn(rotation);
        }
    }
    public void rotateACW()
    {
        if(Greenfoot.isKeyDown("p"))
        {
            turn(-rotation);
        }
    }
    /*fireball code*/
    public void fire()
    {
        if(timeCounter>=reloadTime)
        {
          if(Greenfoot.isKeyDown("space"))
          {
            releaseFireball();
            timeCounter=0;
          }
        }
    }
    public void releaseFireball()
    {
        Greenfoot.playSound("shottingsound.wav");
        World world=getWorld();
        Fireball fireball=new Fireball(10);
        world.addObject(fireball,getX(),getY());
        fireball.setRotation(getRotation());
    }
}

