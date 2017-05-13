import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class castleImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Castle extends Cities
{
    /**
     * Act - do whatever the castleImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * Villages and castles have they're type of benefit, as well as a 
     * population that adds to your army cap dependant on how big the pop
     * is
     */
    
    
    
    public String type, controller;
    public int population, x,y;
    public int armyBoost =0,culturalBoost;
    public double goldBoost;
    public static boolean worldSwitcher = false;
    public World gameWorld;
    public SimpleTimer referToTimer;
    public boolean isChosen = false;
    
    public Castle(SimpleTimer timer, String typey){
        int randomNum = Greenfoot.getRandomNumber(3); //getting a random number to associate to the type 
        referToTimer = timer;
        if(randomNum ==0){
            type = "Cultural Boost";
            population = 10000; 
            armyBoost = 100;
            culturalBoost = 10;
        }
        else if(randomNum ==1){
            type = "Gold Production Boost";
            population = 10000; 
            armyBoost = 100;
            goldBoost = 0.1;
        }
        else if(randomNum ==2){
            type = "Military Boost";
            population = 10000; 
            armyBoost = 500;
            //dannickaImage();
        }
        
    }
    public void axelaImage(){
        setImage("axelaCastle.png");
        controller = "Axela";
    }
    
    public void dannickaImage(){
         setImage("dannickaCastle.png");
         controller = "Dannicka";
    } 
    public String originalImage(){
        return "castle.png";
    }
    
    public String dannickaImageItself(){
        return "dannickaCastle.png";
    }
    
    public String axelaImageItself(){
        return "axelaCastle.png";
    }
     
    public String setController(String s){
        this.controller = s;
        return this.controller;
    }
    public String getController(){
        return this.controller;
    }
    
    public void decision(){
        x = this.getX();
        y = this.getY();
        gameWorld = this.getWorld();
        PopUp.minutes = MyWorld.minutes;
        PopUp.hours = MyWorld.hours;
        PopUp p = new PopUp(gameWorld, referToTimer, "Castle", type, this,x, y);
        Greenfoot.setWorld(p);
    }
    
    public void act(){//act needs to be here or the actor will disapear
        greenfoot.MouseInfo i;
        i = Greenfoot.getMouseInfo(); //this gets the mouse info 
        if(MyWorld.choosingStage == false){ //if it's not the choosing stage
            if(i != null){ //if the mouse doesn't go of the screen
                    if(Greenfoot.mouseClicked(this)){
                       x = this.getX();
                       y = this.getY();
                       gameWorld = this.getWorld();
                       PopUp.minutes = MyWorld.minutes;
                       PopUp.hours = MyWorld.hours;
                       PopUp p = new PopUp(gameWorld,referToTimer, "Castle", controller, type,armyBoost, this,x,y);
                       Greenfoot.setWorld(p);
                    }
                    
            }
        }
        
        else{ //if it is the choosing stage
           if(i != null){ //if the mouse doesn't go of the screen
                    if(Greenfoot.mouseClicked(this)){
                        if(MyWorld.typey.equals("Axela")){
                            this.axelaImage();
                        }
                        if(MyWorld.typey.equals("Dannicka")){
                            this.dannickaImage();
                        }
                       isChosen = true;
                    }
                    
            } 
        }
        
       
        super.strikeChecker();
    }
}
