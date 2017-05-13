import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**Brick is an abstract class that is used only for the graphic of the map
 * generation. 
 * Nicholas Paul
 * @version 22
 */
public class  Brick extends Actor
{
    GreenfootImage g;
    /**Basic constructor for the class Brick.
     */

    public Brick(int l, int w, Color colour){
        g = new GreenfootImage(l,w);
        g.setColor(colour);
        g.fill();
        setImage(g);
    }
   
    
}
