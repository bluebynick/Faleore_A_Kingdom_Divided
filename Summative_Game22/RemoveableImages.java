import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**This is a class that creates images in the game and then reomves them.
 * Nicholas Paul
 * @version 22
 */
public abstract class RemoveableImages extends Actor
{
    protected int timer =0;
    protected boolean existing = false;
    //List <Enemies> b;
    /**This is a method that gets the x location of the closest enemy
     */
      public int enemyX(){
          int i =0;
       /* b = this.getObjectsInRange(80,Enemies.class); //get all enemies in range 
        int i =0;
        if(b.size() >=1){//if there's something for it to shoot
            Enemies t =  b.get(0);  //get the first added enemies to target
            i = t.getX();
       }*/
        return i;
    }
    
    /**This is a method that gets the y location of the closest enemy
     */
    public int enemyY(){
        int i =0;
       /* b = this.getObjectsInRange(80,Enemies.class); //get all enemies in range
        int i =0;
        if(b.size() >=1){//if there's something for it to shoot
            Enemies t = b.get(0); //get the first added enemies to target
            i = t.getY();
       }*/
        return i;
    }
    
    public void act(){
        
        if((timer ==20) && (existing == false)){
            getWorld().removeObject(this);
            timer = 0;
            existing = true;
        }
        timer++;
    }
}
