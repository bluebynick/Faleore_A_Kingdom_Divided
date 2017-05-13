import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class diceImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiceImage extends RemoveableImages
{
    /**
     * Act - do whatever the diceImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean rolling = false;
    public boolean rolled = false;
    public boolean turn = false;
    public int numberRolled =0;
    private ArrayList <String> a = new ArrayList();
    private int timer =0;
    
    public DiceImage(){
        a.add("dice1.png");
        a.add("dice2.png");
        a.add("dice3.png");
        a.add("dice4.png");
        a.add("dice5.png");
        a.add("dice6.png");
        
        
    }
    public void act() {
        if(rolling == true){
            if( turn == true) setImage(a.get(Greenfoot.getRandomNumber(5)));
                
            else setImage(a.get(Greenfoot.getRandomNumber(5)));
                
            if (timer  % 20==0){
                 turn = !turn;
              }
            timer++;  
            
            if(timer >100){
                int b = Greenfoot.getRandomNumber(5);
                numberRolled = b +1;
                setImage(a.get(b));
                rolling = false;
                rolled = true;
            }
        }
            
            // Add your action code here.
    }    
}
