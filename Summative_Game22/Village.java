import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class villageImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Village extends Cities

{
    /**
     * Act - do whatever the villageImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * Villages and castles have they're type of benefit, as well as a 
     * population that adds to your army cap dependant on how big the pop
     * is
     */
    
    public String type, controller;
    public int population, x,y;
    public int armyBoost,culturalBoost;
    public double goldBoost;
    public static boolean worldSwitcher = false;
    public World gameWorld;
    public SimpleTimer referToTimer;
    public boolean isChosen= false;
    
    private String referToTypey;
    
    public Village(SimpleTimer timer, String typey){
        int randomNum = Greenfoot.getRandomNumber(2); //getting a random number to associate to the type 
        referToTimer = timer;
        if(randomNum ==0){
            type = "Cultural Boost";
            population = 10000; 
            armyBoost = 100;
            culturalBoost = 10;
        }
        else if(randomNum ==1){
            type = "Gold Production Boost";
            population = 5000; 
            armyBoost = 100;
            goldBoost = 0.1;
        }
        else if(randomNum ==2){
            type = "Military Boost";
            population = 1000; 
            armyBoost = 500;
            //dannickaImage();
        }
            
            
        
        referToTypey = typey;
    }
    
    public String setController(String s){
        this.controller = s;
        return this.controller;
    }
    public String getController(){
        return this.controller;
    }
    public void axelaImage(){
        this.setImage("axela.png");
        controller = "Axela";
    }
    
    public void dannickaImage(){
         this.setImage("dannicka.png");
         controller = "Dannicka";
    }
    
    public String dannickaImageItself(){
        return "dannicka.png";
    }
    
    public String axelaImageItself(){
        return "axela.png";
    }
    public String originalImage(){
        return "village.png";
    }
    
    public void remove(){
        getWorld().removeObject(this);
    }
    
    public void decision(){
        x = this.getX();
        y = this.getY();
        gameWorld = this.getWorld();
        PopUp.minutes = MyWorld.minutes;
        PopUp.hours = MyWorld.hours;
        PopUp p = new PopUp(gameWorld, referToTimer, "Village", type, this,x, y);
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
                       PopUp p = new PopUp(gameWorld,referToTimer, "Village", controller, type,armyBoost,this, x,y);
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
