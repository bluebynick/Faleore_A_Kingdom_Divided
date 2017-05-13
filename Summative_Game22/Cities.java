import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Cities is an abstract class that provides the bluprints for Village and Castle
 * 
 * Cities uses the concepts of abstraction very well and objects references
 * are created around the program (specifically in pop-up) that require a 
 * the general cities class to be referenced, it's abstract methods and 
 * variables being soon after used. I used the concepts of inheritance and 
 * abstractoin pretty thorougly with this guy and look at the end of the
 * act method in PopUp to see where/how it's used.
 * 
 * @author Nicholas Paul
 * @version Jan 23rd 2017
 */
public abstract class Cities extends Actor
{
    /**
     * Act - do whatever the Cities wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int strikes =0;
    int timer =0;
    String tempController;
    public void strikeChecker(){
        if(strikes ==2){
            this.setImage(originalImage());
            tempController = this.getController();
            this.setController("Neutral"); //i forgot how useful getters and setters were!!!
        }
        if(this.getController() == "Neutral"){
             timer++;
             if(timer >100){
                 if(MyWorld.typey.equals("Axela")){
                     this.setImage(dannickaImageItself());
                     this.setController("Dannicka");
                 }
                 else{
                     this.setImage(axelaImageItself());
                     this.setController("Axela");
                 }
             }
        }
    }
    public abstract String setController(String s);
    public abstract String getController();
    public abstract void axelaImage();
    public abstract void dannickaImage();
    public abstract void decision();
    public abstract String originalImage(); 
    public abstract String dannickaImageItself();
    public abstract String axelaImageItself();

    
}
