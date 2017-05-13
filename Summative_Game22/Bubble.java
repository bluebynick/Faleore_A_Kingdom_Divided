import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubble extends RemoveableImages
{
    /**
     * Act - do whatever the Bubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void flip(){
        this.setImage("bubbleFlip.png");
    }
    
    public void leftSide(){
        this.setImage("bubbleLeft.png");
    }
    public void topLeft(){
        this.setImage("bubbleRight.png");
    }
    public void bubbleD(){
        this.setImage("bubbleD.png");
    }
}
