import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MenuScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreen extends World
{
    Brick instr, credits; 
    Brick play;
    
    Label l,e,t,p,startLevel,one,two,three,four,five;
    MyWorld world;
    //Instructions ins;
    //Credits cr;
    
    /**This is a general constructor for the MenuScreen class.
     * It creates the butotns and starts the songs
     * 
     */
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
       if(MyWorld.music == false){ //only run the first time or when it's told
            Sounds s = new Sounds(); 
            MyWorld.ss.add(s);
            s.playCelticMusicKing(); //commented out for sanity's sake
            MyWorld.music =true;
        }   
        
        startLevel = new Label("Start at level:",40);
        one = new Label("1",40);
        two = new Label("2",40); //fix the locations and the locations they're added to 
        three = new Label("3",40);
        four = new Label("4",40);
        five = new Label("5",40);
        
        
        play = new Brick(100,50, java.awt.Color.BLUE); //button accepts a length and a width
        addObject(play,getWidth()/2,getHeight()/2);
        
        l = new Label("Play",50);
        addObject(l,play.getX(),play.getY());
        
        
        instr = new Brick(250,50,java.awt.Color.BLUE);
        addObject(instr,(getWidth()/2)/2,300);
        
        e = new Label("Instructions",50);
        addObject(e,(getWidth()/2)/2,300);
        
        credits = new Brick(250,50, java.awt.Color.BLUE);
        addObject(credits,(getWidth()*3/4),300);
        
        t = new Label("Credits",50);
        addObject(t,(getWidth()*3/4),300);
        
        //instr = new button();
        //addObject(instr,(getWidth()/2)/2,300);
        
        p = new Label("Faleore",75);
        addObject(p,getWidth()/2,100);
        
        Label o = new Label("A Kingdom Divided",25);
        addObject(o,p.getX(), p.getY() +50);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(l)){   
            for(int i =0; i <=MyWorld.ss.size()-1;i++){
                Sounds m = MyWorld.ss.get(i);
                m.stopCelticMusicKing(); //greenfoot's finicky so the music needs to be changed before the world
            }
            Sounds m = new Sounds();
            MyWorld.ss.add(m);
              
              m.playCelticMusicProphecy();
              MyWorld.gold =500;
              MyWorld.productionRate = 0.01;
              MyWorld.culture = 0;
              MyWorld.troops = 500;
              MyWorld.troopsCap =1000;
            world = new MyWorld();
            PopUp p = new PopUp(world,"TeamChooser");  //make a new world with the new level
            Greenfoot.setWorld(p);
        }
        if(Greenfoot.mouseClicked(e)){
            Instructions ins= new Instructions();
            Greenfoot.setWorld(ins);
            
        }
         if(Greenfoot.mouseClicked(t)){
            Credits cr= new Credits();
            Greenfoot.setWorld(cr);
        }
        
    }
}