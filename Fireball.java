import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    private int speed;
    public Fireball(int speed)
    {
        this.speed=speed;
        getImage().scale(getImage().getWidth()/16,getImage().getHeight()/16);
    }
    public void act()
    {
        move(speed);
        destroy();
    }
    public void destroy()
    {
        Alien alien=(Alien)getOneIntersectingObject(Alien.class);
        if(alien!=null)
        {
            /*removal current alien*/
            World world=getWorld();
            world.removeObject(alien);
            /*remove fireball*/
            world.removeObject(this);
            Greenfoot.playSound("Explosion.wav.wav");
            SpaceShip.score++;
        }
        else if(isAtEdge())
        {
            World world=getWorld();
            world.removeObject(this);
        }
    }
}
