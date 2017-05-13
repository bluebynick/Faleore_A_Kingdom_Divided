import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**This is a class that creates a button based on a specific length and width.
 * 
 * Nicholas Paul
 * @version 22
 */
public class Button extends Actor
{
    GreenfootImage g;
    /**This is a costructor for the class that takes in a legnth and width parameter. 
     * The greenfootimage is created with the recieved length and width. The color is 
     * assigned to blue because it goes along with the scheme.
     */
    
    public Button(int l, int w){
        g = new GreenfootImage(l,w);
        
        g.setColor(java.awt.Color.BLUE);
        g.fill();
        setImage(g);
        
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
