import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
/**PopUp is a class that handles the funcitonality of the details of the game
     * 
     * PopUp has 4 seperate constructors that all provide different functionality
     * to the game. The first constructor is a constructor that takes in the 
     * information about a specific city and creates a pop-up informational 
     * dialogue displaying important information. The second constructor takes
     * in information then creates the decision dialogue. The third constructor 
     * deals with the combat mechanics. The fourth constructor deals with the 
     * faction choosing at the beggining of the game. This is a very intensive
     * class that holds references to objects and references to references 
     * that are being passed by multiple constructors. I'm very proud of this class.
     * 
     *
 * @author Nicholas Paul
 * @version Jan 23rd 2017
 */
public class PopUp extends World
{

    
    
    /*These ones are the general variables needed for all versions of this
     *class
     */
    public World world;
    public Label back, sure,timerLabel,controller, type, troops, attack;
    public SimpleTimer timer;
    public static int minutes,hours;
    public String cOv = "", referToReferToType;
    public boolean starter = false;
    
    public static String userController = "";
    
    /*These ones are the variables to tell which type of class it is
     */
    public boolean isPopUp = false;
    public boolean isCombat = false;
    public boolean isTeamChooser = false;
    public boolean isDecision = false;
    
    /*These ones are the variables needed for combat
     */
    public boolean turn;
    int defenseTroops, attackingTroops, timersss = 0;
    DiceImage dice,dice2;
    Label roll;
    Cities city;
    
    /*These ones are the variables needed for TeamChoosing
     */
    AxelaImage a;
    DannickaImage d;
    Label axela, dannicka;
    
    /*These ones are the variables needed for Decisions
     */
    Cities referToObject;
    
    /**
     * This is the constructor that makes the popup window and deals with 
     * the bubble and stuff
     */
    public PopUp(World gameWorld, SimpleTimer referToTimer, String castleOrVillage, String referToController, String referToType,int defendingTroops, Cities referenceToObject, int bubbleX, int bubbleY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000,600,1);
        int bubbleLocationX =0, bubbleLocationY =0, buttonX =0,buttonY =0, imageX=0, imageY=0;
        int label1X =0, label1Y = 0, controllerX = 0, controllerY = 0, typeX =0, typeY =0;
        int troopsX = 0, troopsY  = 0, sureX =0, sureY= 0;
        world = gameWorld;
        timer = referToTimer;
        referToObject = referenceToObject;
        cOv = castleOrVillage;
        controller = new Label("Controller: "+ referToController, 20);
        type = new Label(referToType,20);
        defenseTroops = defendingTroops;
        troops = new Label("Defending Troops: " + defendingTroops,18);
        //each one's gonna have a controlled by and then what it does for you
        
        Bubble b = new Bubble();
        
        //this changes the locations of the stuff based on what bubble we need based on which city was clicked
        if(bubbleY <200){ //if it's too high for the normal bubble
            b.flip();
            bubbleLocationX = bubbleX+80;
            bubbleLocationY = bubbleY+120;
            sureX = bubbleLocationX + 40;
            sureY = bubbleLocationY;
            buttonX = bubbleLocationX + 40;
            buttonY = bubbleLocationY - 30;
            label1X = bubbleLocationX -40;
            label1Y = bubbleLocationY;
            imageX = bubbleLocationX -40;
            imageY = bubbleLocationY -30;
            controllerX = imageX +40;
            controllerY = imageY + 55;
            typeX = imageX +40;
            typeY = imageY + 80;
            troopsX = imageX +40;
            troopsY = imageY + 105;
        }
        else if(bubbleX > 800){ //too far to the left for the normal bubble
            b.leftSide();
            bubbleLocationX = bubbleX-60;
            bubbleLocationY = bubbleY-120;
            buttonX = bubbleLocationX + 40;
            buttonY = bubbleLocationY + 30;
           
            sureX = bubbleLocationX - 40;
            sureY = bubbleLocationY + 30;
            if(castleOrVillage.equals("Castle")){
                imageX = bubbleLocationX -30;
                imageY = bubbleLocationY -80;
                controllerX = imageX +30;
                controllerY = imageY + 40;
                typeX = imageX +30;
                typeY = imageY + 65;
                troopsX = imageX +30;
                troopsY = imageY + 90;
            }
            else{
                imageX = bubbleLocationX -40;
                imageY = bubbleLocationY -70;
                controllerX = imageX +40;
                controllerY = imageY + 35;
                typeX = imageX +40;
                typeY = imageY + 55;
                troopsX = imageX +40;
                troopsY = imageY + 75;
            }
            label1X = imageX +70;
            label1Y = imageY;
        }
        /*
        else if( (bubbleX > 800) && (bubbleX > 800)){ //too left and too high
            b.topLeft();
            bubbleLocationX = bubbleX-60;
            bubbleLocationY = bubbleY+120;
            buttonX = bubbleLocationX + 40;
            buttonY = bubbleLocationY - 30;
            label1X = bubbleLocationX -40; 
            label1Y = bubbleLocationY;
             if(castleOrVillage.equals("Castle")){
                imageX = bubbleLocationX -40;
                imageY = bubbleLocationY -30;
            }
            else{
                imageX = bubbleLocationX -40;
                imageY = bubbleLocationY -30;
            }
        }*///these numbers need to be reworked but for now it's not necessary
        
        else{
            bubbleLocationX = bubbleX+80;
            bubbleLocationY = bubbleY-120;
            buttonX = bubbleLocationX + 40;
            buttonY = bubbleLocationY + 30;
            sureX = bubbleLocationX - 40;
            sureY = bubbleLocationY + 30;
            if(castleOrVillage.equals("Castle")){
                imageX = bubbleLocationX -30;
                imageY = bubbleLocationY -80;
                controllerX = imageX +30;
                controllerY = imageY + 40;
                typeX = imageX +30;
                typeY = imageY + 65;
                troopsX = imageX +30;
                troopsY = imageY + 90;
            }
            else{
                imageX = bubbleLocationX -40;
                imageY = bubbleLocationY -70;
                controllerX = imageX +40;
                controllerY = imageY + 35;
                typeX = imageX +40;
                typeY = imageY + 55;
                troopsX = imageX +40;
                troopsY = imageY + 75;
            }
            label1X = imageX +70;
            label1Y = imageY;
        }
        
        addObject(b,bubbleLocationX,bubbleLocationY);
        addObject(controller, controllerX, controllerY);
        addObject(type, typeX, typeY);
        addObject(troops,troopsX,troopsY);
        if(castleOrVillage.equals("Castle")){
            CastleImage c = new CastleImage();
            addObject(c,imageX, imageY);
            Label l = new Label("Castle",20);
            addObject(l, label1X, label1Y);
        }
        else{
            VillageImage vi = new VillageImage();
            addObject(vi,imageX, imageY);
            Label l = new Label("Village",20);
            addObject(l, label1X, label1Y);
        }
        
        Brick backB = new Brick(60,20,java.awt.Color.BLUE);
        addObject(backB,buttonX, buttonY);
        
        back= new Label("back",20);
        addObject(back,buttonX,buttonY);
        
        if(referToController.equals(userController)){
            
        }
        else{
            Brick sureB = new Brick(60,20,java.awt.Color.BLUE);
            addObject(sureB,sureX, sureY);
            attack = new Label("Attack",20);
            addObject(attack,sureX,sureY);
        }
        
        
        
        if(timer.millisElapsed()/1000 >= 60){
            
            minutes = (timer.millisElapsed()/1000)/60;
            hours = minutes/60;
        }
        
        timerLabel = new Label(hours + " : " + minutes + " : " +timer.millisElapsed()/1000,25);
        addObject(timerLabel,100,550);
        
        Label troopsL =  new Label("Troops: " + MyWorld.troops, 25);
        addObject(troopsL,325,550);
        
        isPopUp = true;
    }
    
    /**
     * This is the constructor that deals with the decisions, same
     * background just different things in the parameters
     */
    
    public PopUp(World gameWorld, SimpleTimer referToTimer, String castleOrVillage, String referToType, Cities striker,int bubbleX, int bubbleY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000,600,1);
        int bubbleLocationX =0, bubbleLocationY =0, buttonX =0,buttonY =0, imageX=0, imageY=0;
        int label1X =0, label1Y = 0, controllerX = 0, controllerY = 0, typeX =0, typeY =0;
        int troopsX = 0, troopsY  = 0, sureX =0, sureY= 0;
        world = gameWorld;
        timer = referToTimer;
        referToReferToType = referToType;
        cOv = castleOrVillage;
        referToObject = striker;
        controller = new Label(chooseMessage(0),20);
        type = new Label(chooseMessage(1),20);
        troops = new Label(chooseMessage(2),20);
        
        /**If i have time I could do the whole random number generation thing 
         * leads to different messages per each type like i have in village 
         * and castle for their types, just an idea if you have time, also 
         * names for each place would be cool
         */
        
        
        //troops = new Label("Defending Troops: " + defendingTroops,18);
        //each one's gonna have a controlled by and then what it does for you
        
        Bubble b = new Bubble();
        
        //this changes the locations of the stuff based on what bubble we need based on which city was clicked
        if(bubbleY <200){ //if it's too high for the normal bubble
            b.flip();
            bubbleLocationX = bubbleX+80;
            bubbleLocationY = bubbleY+120;
            buttonX = bubbleLocationX + 40;
            buttonY = bubbleLocationY - 30;
            sureX = bubbleLocationX + 40;
            sureY = bubbleLocationY;
            label1X = bubbleLocationX -40;
            label1Y = bubbleLocationY;
            imageX = bubbleLocationX -40;
            imageY = bubbleLocationY -30;
            controllerX = imageX +40;
            controllerY = imageY + 55;
            typeX = imageX +40;
            typeY = imageY + 80;
            troopsX = imageX +40;
            troopsY = imageY + 105;
        }
        else if(bubbleX > 800){ //too far to the left for the normal bubble
            b.leftSide();
            bubbleLocationX = bubbleX-60;
            bubbleLocationY = bubbleY-120;
            buttonX = bubbleLocationX + 40;
            buttonY = bubbleLocationY + 30;
            sureX = bubbleLocationX - 40;
            sureY = bubbleLocationY + 30;
            if(castleOrVillage.equals("Castle")){
                imageX = bubbleLocationX -30;
                imageY = bubbleLocationY -80;
                controllerX = imageX +30;
                controllerY = imageY + 40;
                typeX = imageX +30;
                typeY = imageY + 65;
                troopsX = imageX +30;
                troopsY = imageY + 90;
            }
            else{
                imageX = bubbleLocationX -40;
                imageY = bubbleLocationY -70;
                controllerX = imageX +40;
                controllerY = imageY + 35;
                typeX = imageX +40;
                typeY = imageY + 55;
                troopsX = imageX +40;
                troopsY = imageY + 75;
            }
            label1X = imageX +70;
            label1Y = imageY;
        }
        /*
        else if( (bubbleX > 800) && (bubbleX > 800)){ //too left and too high
            b.topLeft();
            bubbleLocationX = bubbleX-60;
            bubbleLocationY = bubbleY+120;
            buttonX = bubbleLocationX + 40;
            buttonY = bubbleLocationY - 30;
            label1X = bubbleLocationX -40; 
            label1Y = bubbleLocationY;
             if(castleOrVillage.equals("Castle")){
                imageX = bubbleLocationX -40;
                imageY = bubbleLocationY -30;
            }
            else{
                imageX = bubbleLocationX -40;
                imageY = bubbleLocationY -30;
            }
        }*///these numbers need to be reworked but for now it's not necessary
        
        else{
            bubbleLocationX = bubbleX+80;
            bubbleLocationY = bubbleY-120;
            buttonX = bubbleLocationX + 40;
            buttonY = bubbleLocationY + 30;
            sureX = bubbleLocationX - 40;
            sureY = bubbleLocationY + 30;
            if(castleOrVillage.equals("Castle")){
                imageX = bubbleLocationX -30;
                imageY = bubbleLocationY -80;
                controllerX = imageX +30;
                controllerY = imageY + 40;
                typeX = imageX +30;
                typeY = imageY + 65;
                troopsX = imageX +30;
                troopsY = imageY + 90;
            }
            else{
                imageX = bubbleLocationX -40;
                imageY = bubbleLocationY -70;
                controllerX = imageX +40;
                controllerY = imageY + 35;
                typeX = imageX +40;
                typeY = imageY + 55;
                troopsX = imageX +40;
                troopsY = imageY + 75;
            }
            label1X = imageX +70;
            label1Y = imageY;
        }
        
        addObject(b,bubbleLocationX,bubbleLocationY);
        addObject(controller, controllerX, controllerY);
        addObject(type, typeX, typeY);
        addObject(troops,troopsX,troopsY);
        if(castleOrVillage.equals("Castle")){
            CastleImage c = new CastleImage();
            addObject(c,imageX, imageY);
            Label l = new Label("Castle",20);
            addObject(l, label1X, label1Y);
        }
        else{
            VillageImage vi = new VillageImage();
            addObject(vi,imageX, imageY);
            Label l = new Label("Village",20);
            addObject(l, label1X, label1Y);
        }
        
        Brick backB = new Brick(60,20,java.awt.Color.BLUE);
        addObject(backB,buttonX, buttonY);
        
        back= new Label("Pass",20);
        addObject(back,buttonX,buttonY);
        
        Brick sureB = new Brick(60,20,java.awt.Color.BLUE);
        addObject(sureB,sureX, sureY);
        
        sure= new Label("Accept",20);
        addObject(sure,sureX,sureY);
        
        
        
        if(timer.millisElapsed()/1000 >= 60){
            
            minutes = (timer.millisElapsed()/1000)/60;
            hours = minutes/60;
        }
        
        timerLabel = new Label(hours + " : " + minutes + " : " +timer.millisElapsed()/1000,25);
        addObject(timerLabel,100,550);
        
        
        
        isDecision = true;
    }
    
    /**
     * This is the constructor that deals with combat, same background just
     * different things in the parameters
     */
    
    public PopUp(World gameWorld, SimpleTimer referToTimer, String cOv,int troops, int defendingTroops, Cities refToObject){
        super(1000,600,1);
        
        world = gameWorld;
        timer = referToTimer;
        defenseTroops = defendingTroops;
        attackingTroops = troops;
        city = refToObject;
        
        
        if(timer.millisElapsed()/1000 >= 60){
            
            minutes = (timer.millisElapsed()/1000)/60;
            hours = minutes/60;
        }
        
        timerLabel = new Label(hours + " : " + minutes + " : " +timer.millisElapsed()/1000,25);
        addObject(timerLabel,100,550);
        
        
        
        isCombat = true;
        
        Brick b = new Brick(600,400, new Color(119,136,153));
        addObject(b,500,300);
        
        String inputValue = JOptionPane.showInputDialog("Please input the amount of troops you want to attack with.");
        
        while((isNumeric(inputValue) == false)){
            if(inputValue.length() >4){
                inputValue = JOptionPane.showInputDialog("Please input a vaild amount of troops.");
            }
            else{
                while((Integer.parseInt(inputValue) >MyWorld.troops)){
                    inputValue = JOptionPane.showInputDialog("Please input a vaild amount of troops.");
                }
            }
        }
        
        Label attackingTroops = new Label("Attacking Troops: " +inputValue,25);
        addObject(attackingTroops, 350,450);
        
        Label defenders = new Label("Defending Troops: " + defendingTroops,25);
        addObject(defenders, 650,450);
        
        dice = new DiceImage();
        addObject(dice,350,250);
        dice2 = new DiceImage();
        
        addObject(dice2,650,250);
        
        Brick bob = new Brick(100,25, java.awt.Color.BLUE); 
        roll = new Label("Roll",25);
        
        Label you = new Label(userController,25);
        addObject(you,350,150);
        
        Label enemy = new Label(cOv,25);
        addObject(enemy,650,150);
        
        Brick backB = new Brick(60,20,java.awt.Color.BLUE);
        addObject(backB,500,490);
        
        back= new Label("Cancel",20);
        addObject(back,500,490);
        
        //Label l = new Label("Input 
        addObject(bob,500,150);
        addObject(roll,500,150);
    }
    
    /**
     * This is the constructor that deals with the choosing of sides, same
     * background just different things in the parameters
     */
    
    public PopUp(World gameWorld,String p){
        super(1000,600,1);
        
        
        isTeamChooser = true;
        
        world = gameWorld;
        AxelaImage a = new AxelaImage();
        addObject(a,100+150,200); //150 for img mode center compensation
        Label axela = new Label("The People Of Axela",50);
        addObject(axela,250,396);//it's 246 so 446 - 50 high
        
        DannickaImage d = new DannickaImage();
        addObject(d,1000-250,200);    
        Label dannicka = new Label("The People Of Dannicka",50);
        addObject(dannicka,1000-250,396);//it's 246 so 446 - 50 high
            
            
    }
    
    public void clock(){
            if((timer.millisElapsed()/1000 % 60 ==0) && (timer.millisElapsed()/1000 != 0)){
                minutes++;
                timer.mark();
            }
            if(minutes >=60){
                hours ++;
                minutes =0;
            }
            
    }
    public int calcuate(){
        int i =0; 
        
        
        return i;
    }
    
    public boolean isNumeric(String s) {  
        return s.matches("[-+]?\\d*\\.?\\d+");  
    }  
    
    public String chooseMessage(int i){
        String s = "tyu";
        
            if(referToReferToType.equals("Cultural Boost")){
                if(i ==0){
                    s = cOv + " is putting on a";
                }
                else if(i ==1){
                    s = "play, would the monarch";
                }
                else if(i ==2){
                    s = "like to come watch? (-500)";
                }
            }
            else if(referToReferToType.equals("Gold Production Boost")){
                if(i ==0){
                     s = cOv + "'s mine has";
                }
                else if(i ==1){
                    s = "flooded, would you";
                }
                else if(i ==2){
                    s = "like to send aid? (-700)";
                }
            }
            else if(referToReferToType.equals("Military Boost")){
                if(i ==0){
                     s = cOv + " has had a break in";
                }
                else if(i ==1){
                    s = "at the armory, would you";
                }
                else if(i ==2){
                    s = "like to help investigte? (-1000)";
                }
                
            }
        
        return s;
    }
    
    public void act(){
        greenfoot.MouseInfo i;
        i = Greenfoot.getMouseInfo(); //this gets the mouse info 
        if(isTeamChooser == false){
            if(Greenfoot.mouseClicked(back)){
                MyWorld.minutes = minutes;
                MyWorld.hours = hours;
                Greenfoot.setWorld(world);
                if(isDecision == true){
                    referToObject.strikes +=1;
                    
                }
            }
            if(isDecision ==true){
               if(Greenfoot.mouseClicked(sure)){
                    MyWorld.minutes = minutes;
                    MyWorld.hours = hours;
                    if(referToReferToType.equals("Cultural Boost")){
                        if(MyWorld.gold >500){
                            MyWorld.gold-=500;
                        }
                    }
                    else if(referToReferToType.equals("Gold Production Boost")){
                        if(MyWorld.gold >700){
                            MyWorld.gold-=700;
                        }
                    }
                    else if(referToReferToType.equals("Military Boost")){
                        if(MyWorld.gold >1000){
                            MyWorld.gold-=1000;
                        }
                    }
                    Greenfoot.setWorld(world);
                }
            }
            clock();
            timerLabel.setValue(hours + " : " + minutes + " : " +timer.millisElapsed()/1000);
            if(isCombat == true){
                
            }
            else if(isPopUp == true){
                
            }
        }
        if(isTeamChooser == true){ //if it's the combat version of this window
            if(i != null){
                if((Greenfoot.mouseClicked(a)) || (Greenfoot.mouseClicked(axela)) || (Greenfoot.mouseClicked(d)) || Greenfoot.mouseClicked(dannicka)){
                    if(world == null){
                        world = new MyWorld();
                    }
                    MyWorld.choosingStage = true;
                    if(i.getX() <=500){
                        MyWorld.typey = "Axela";
                        userController = "Axela";
                    }
                    else{
                        MyWorld.typey = "Dannicka";
                        userController = "Dannicka";
                    }
                    Greenfoot.setWorld(world);
                    //Greenfoot.delay(1000);
                }
            }
        }
        if(isCombat == true){
            if((Greenfoot.mouseClicked(roll)) && (starter == false)){ //starter makes it only rolable once
                    dice.rolling = true;
                    dice2.rolling = true;
                    starter = true;
            }
            if(dice.numberRolled != 0){
                Label l = new Label("" + dice.numberRolled,30);
                addObject(l,350,350);
                timersss++;
            }
            if(dice2.numberRolled != 0){
                Label l = new Label("" + dice2.numberRolled,30);
                addObject(l,650,350);
                timersss++;
            }
            
            //these methods handle the troop advantage benefits
            if(dice.rolled == true){
                if(attackingTroops >defenseTroops){
                    if((dice.numberRolled >= dice2.numberRolled) &&(dice.numberRolled !=0)){
                         if(MyWorld.typey.equals("Axela")){ //this code is being reached
                            if((city instanceof Village) || (city instanceof Castle)){ //so it's definately not null and definately an instance of village
                                 ((Village)city).axelaImage();
                            }
                         }
                         else{
                             if((city instanceof Village) || (city instanceof Castle)){ //so it's definately not null and definately an instance of village
                                 ((Village)city).dannickaImage();
                            }
                         }
                    }
                    else{
                        MyWorld.troops -=100;
                        isCombat = false;
                        Greenfoot.delay(75);
                        Greenfoot.setWorld(world);
                    }
                }
                else if(attackingTroops ==defenseTroops){
                    if(dice.numberRolled > dice2.numberRolled){
                         if(MyWorld.typey.equals("Axela")){ //this code is being reached
                            if((city instanceof Village) || (city instanceof Castle)){ //so it's definately not null and definately an instance of village
                                 ((Village)city).axelaImage();
                            }
                         }
                         else{
                             if((city instanceof Village) || (city instanceof Castle)){ //so it's definately not null and definately an instance of village
                                 ((Village)city).dannickaImage();
                            }
                         }
                    }
                    else{
                        MyWorld.troops -=100;
                        isCombat = false;
                        Greenfoot.delay(75);
                        Greenfoot.setWorld(world);
                    }
                }
                else if(attackingTroops >=defenseTroops +100){
                    if(dice.numberRolled >= dice2.numberRolled-1){
                        if(MyWorld.typey.equals("Axela")){ //this code is being reached
                            if((city instanceof Village) || (city instanceof Castle)){ //so it's definately not null and definately an instance of village
                                 ((Village)city).axelaImage(); //this is so stupid and it works XDDDDD
                            }
                         }
                         else{
                             if((city instanceof Village) || (city instanceof Castle)){ //so it's definately not null and definately an instance of village
                                 ((Village)city).dannickaImage();
                            }
                         }
                    }
                    else{
                        MyWorld.troops -=100;
                        isCombat = false;
                        Greenfoot.delay(75);
                        Greenfoot.setWorld(world);
                    }
                }  
            }
            if((Greenfoot.mouseClicked(back) != true)){
                //Greenfoot.setWorld(this);
                if(timersss>200){    
                    Greenfoot.setWorld(world);
                }
            }
        }      
            
        if(isPopUp == true){
            if(MyWorld.troops >0){
                if(Greenfoot.mouseClicked(attack)){
                    PopUp combat = new PopUp(world,timer,cOv,MyWorld.troops,defenseTroops,referToObject); //the refernces are still valid 'casue i'm in the instance where they were assigned. wow!
                    Greenfoot.setWorld(combat);
                }
            }
        }
        
        
        
    }
}
