import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;  //ArrayLists
import java.awt.*;
/**MyWorld is the princile world class where the game is created and run. 
 * 
 * This is a real-time strategy game with a lot of funtionality. It is highlighted 
 * in the attached word doc exactly what functionality is included. 
 * Enjoy!
 * 
 * @Nicholas Paul
 * @version 18
 * Jan 23rd 2017
 */
public class MyWorld extends World
{

    
    ArrayList <ArrayList> listOfArrayLists;
    ArrayList <Village> villages;
    ArrayList <Castle> castles;
    
    ArrayList <Cities> yourSelection;
    MenuScreen menu = new MenuScreen();
    Label back,timerLabel, selections, helper, army, goldL, cultureL, production,armyCap, cBenefits;
    static int hours, minutes,seconds;
    public static String typey = "Axela";
    static ArrayList <Sounds> ss = new ArrayList(); //an arrayist of sounds to find the right sounds when it's needed
    static boolean music = false; // a static boolean for the music
    public static boolean choosingStage = true; //a static boolean to determine whether or not it's choosing stage
   
    public SimpleTimer timer;
    public boolean doOnce = false, starter = false;
    int counter = 0, citiesLeft = 8;
    
    Brick troopB;
    Label troopsL;
    
    static public int gold =500;
    static public double productionRate = 0.01;
    static public int culture;
    static public int troops = 500;
    static public int troopsCap =1000;
    
    
     /**
     * Basic, no parameter constructer for MyWorld. 
     * This immediately sets the world to an instance of MenuScreen, whilst
     * generating a world by initializing the variables and calling create
     * world in the background. The world is then changed from MenuScreen 
     * back to the already created game world. 
     * 
     */
    
    public MyWorld() 
    {    
        
        super(1000, 600, 1); 
        
        Greenfoot.setWorld(menu);
        initialize();
        createWorld();
        
        Brick b = new Brick(150,50, java.awt.Color.BLUE);
        addObject(b,900,550);
       
        back = new Label("Restart", 50);
        addObject(back,900,550);
        
        timerLabel = new Label(hours + " : " + minutes + " : " +seconds,25);
        addObject(timerLabel,100,550);
        
        selections = new Label("Choose your 8 settlements by clicking them",25);
        addObject(selections,500,550);
        
        helper = new Label("Settlements Remaining: " + citiesLeft,25);
        addObject(helper,500,575);
        
        army = new Label("",25);
        goldL = new Label("",25);
        cultureL = new Label("",25);
        
        production = new Label("",20);
        armyCap = new Label("",20);
        cBenefits = new Label("",20);
        
        troopB = new Brick(195,22, java.awt.Color.BLUE);
        troopsL = new Label("Train troops (-600 Gold)",22);
        
    }
    /**
      * This is an initializer method that resets all the static variables.
      * It is used when the game uses it's restart feature. 
      */
    public void initialize(){
        hours =0;
        minutes =0;
        seconds =0;
        timer = new SimpleTimer();
        doOnce = false;
        starter = false;
        //choosingStage = true;
    }
    public void createWorld(){
        
        listOfArrayLists = new ArrayList<ArrayList>(); //this is a 2d ArrayList. his name is bob. he says hi. it's basically an arraylist of arraylists. holy crap it took a long time
        villages =  new ArrayList <Village>();
        castles =  new ArrayList <Castle>();
        yourSelection = new ArrayList<Cities>();
    
        /*if(level % 2 ==0){
            for(int i = 0; i < 10; i++){ // each 'y' row
                
                ArrayList <Integer> tempArray = new ArrayList<Integer>(); //new arraylist stored in temparray
                
                for(int j = 0; j < 10; j++){ //populate specific temparrays
                    if(((i >=0) && i<=1) && (j ==4)){
                        tempArray.add(1);
                    }
                    else if((i ==2) && ((j >=1) && (j <=4))){
                        tempArray.add(1);
                    }
                    else if(((i >=2) && (i<=4)) && (j ==1)){
                        tempArray.add(1);
                    }
                    else if((i ==5) && ((j >=1) && (j <=6))){
                        tempArray.add(1);
                    }
                    else if(((i >=5) && i<=9) && (j ==6)){
                       tempArray.add(1); 
                    }
                    
                    else{
                        tempArray.add(0);
                    }
                    
                }
                listOfArrayLists.add(tempArray); //add temparray to the arraylist of arraylists
            }
        }
        
        else{*/
            /**Key code:
             * 0 = terrain
             * 1 = road / boarder/ whatever you want it to be nicky boy
             * 2 = castle
             * 3 = empty
             * 4 = village
             * 5 = mountain sideways
             * 6 = water
             * 7 = mountain normal
             * 8 = ui boundaries
             */
            for(int i = 0; i < 15; i++){ // each 'y' row
                
                ArrayList <Integer> tempArray = new ArrayList<Integer>(); //new arraylist stored in temparray
                //the grid is 25x by 15y, aka 15 arraylists holding arraylists of 15 long
                //so i noticed i'm doing this backwards, j represents x and i represents y
                for(int j = 0; j < 25; j++){ //populate specific temparrays
                     /**Adding specific terrain
                     * 
                     */
                    if(   ((j>=5) && (j<=6) && (i >=4) && (i <=6)) || ((j ==7) && (i ==3))   || ((j ==7) && (i ==4))){//   || ((j ==6) && (i ==12)) || ((j ==21) && (i ==12))   || ((j ==21) && (i ==3))   || ((j ==6) && (i ==12)) || ((j ==21) && (i ==12))   || ((j ==21) && (i ==3))   || ((j ==6) && (i ==12)) || ((j ==21) && (i ==12))   ){
                        tempArray.add(0);
                    }
                    
                    /**Adding roads or boundaries or ui stuff
                     * 
                     */
                     /*if(((j ==1) &&(i >=0) && i<=15)){
                        tempArray.add(1);
                    }
                    
                    /**Adding Castles
                     * 
                     */
                    else if(   ((j==6) && (i == 3))    || ((j ==21) && (i ==3))   || ((j ==6) && (i ==11)) || ((j ==21) && (i ==11))   ){
                        tempArray.add(2);
                    }
                    
                    /**Adding Empty Spots
                     * 
                     */ 
                    
                    /*else if(   ((j==5) && (i == 3))    || ((j ==20) && (i ==3))   || ((j ==5) && (i ==12)) || ((j ==20) && (i ==12))   ){
                       tempArray.add(3); 
                    }*/
                    /**Adding Villages
                     * 
                     */
                    
                    else if(   ((j==7) && (i == 5))    || ((j ==9) && (i ==12))   || ((j ==16) && (i ==10)) || ((j ==23) && (i ==12))   || ((j ==17) && (i ==3))   || ((j ==21) && (i ==6))||  ((j ==18) && (i ==5))   || ((j ==13) && (i ==2))   || ((j ==12) && (i ==2)) || ((j ==12) && (i ==3))   || ((j ==9) && (i ==0))   || ((j ==10) && (i ==8)) || ((j ==12) && (i ==12))){//   || ((j ==21) && (i ==3))   || ((j ==6) && (i ==12)) || ((j ==21) && (i ==12))   ){
                        tempArray.add(4);
                    }
                    
                    /**Adding Mountains sideways
                     * 
                     */
                    else if((((j <=1)) &&((i >=0) && i<=12))   ||  (((j ==18)) &&((i >=10) && i<13))){
                        tempArray.add(5);
                    }
                    
                    /**Adding Lakes
                     * 
                     */
                    else if(   (((j >2)&& (j <=8)) &&((i >=0) && (i<=6)))   ||   (((j >=13)&& (j <=15)) &&((i >=7) && (i<=9)))){
                        tempArray.add(6);
                    }
                    
                    /**Adding Mountains normal
                     * 
                     */
                    else if((((j >19)) &&((i ==9)))){
                        tempArray.add(7);
                    }
                    
                    /**Adding UI
                     * 
                     */
                    else if((((i >=13)))){
                        tempArray.add(8);
                    }
                    
                    /**Making everything else a terrain
                     * 
                     */
                    else{
                        tempArray.add(0);
                    }
                    
                }
                listOfArrayLists.add(tempArray); //add temparray to the arraylist of arraylists
            }
        //}
        
        int loopCounter =0; //this signifies the amount of arraylists
        for (ArrayList a : listOfArrayLists) { //for each Arraylist in the list of arrays
            
             for (int i = 0; i < 25; i++) { //go through each element of the array list
               //System.out.print(a.get(i)); //print the array
                 if((int) a.get(i) == 0){ //if a 0 has been assigned . 
                    Brick d = new Brick(40,40, new Color(85,107, 47)); //create dirt at the designated spot on my 'grid'
                    addObject(d,(i*40)+20 ,(loopCounter*40) +20); //*60 to put it in the right spot 'cause 400/10 = 40. 20 'cause greenfoot uses imgmode center. same concept with the *40 and +20     
                }
                
                else if((int) a.get(i) == 1){ //if a one  has been assigned 
                    Brick rd = new Brick(5,40, java.awt.Color.BLACK); //create a road at the designated spot on my 'grid' (a 10 by 10 grid so 600 and 400 each divided by 10)      
                    addObject(rd,(i*40)+20 ,(loopCounter*40)+20); //*40 to put it in the right spot 'cause 400/10 = 40. 20 'cause greenfoot uses imgmode center. same concept with the *40 and +20     
                   
                }
                else if((int) a.get(i) == 2){ //if a one  has been assigned 
                    Castle ci = new Castle(timer,typey); //create a road at the designated spot on my 'grid' (a 10 by 10 grid so 600 and 400 each divided by 10)      
                    addObject(ci,(i*40) ,(loopCounter*40)+20); //no +20 cause we don't want to compensate for the centre if there's a blank one next to it    
                    castles.add(ci);
                }
                else if((int) a.get(i) == 3){ //if a one  has been assigned 
                   //do nothing
                }
                else if((int) a.get(i) == 4){ //if a one  has been assigned 
                    Village vi = new Village(timer,typey); //create a road at the designated spot on my 'grid' (a 10 by 10 grid so 600 and 400 each divided by 10)      
                    addObject(vi,(i*40)+20 ,(loopCounter*40)+20); //no +20 cause we don't want to compensate for the centre if there's a blank one next to it    
                    villages.add(vi);
                }
                else if((int) a.get(i) == 5){ //if a one  has been assigned 
                    MountainImage mi = new MountainImage(); //create a road at the designated spot on my 'grid' (a 10 by 10 grid so 600 and 400 each divided by 10)      
                    addObject(mi,(i*40)+20 ,(loopCounter*40)+20); //no +20 cause we don't want to compensate for the centre if there's a blank one next to it    
                   
                }
                else if((int) a.get(i) == 6){ //if a one  has been assigned 
                    Brick d = new Brick(40,40, new Color(95,158,160)); //create dirt at the designated spot on my 'grid'
                    addObject(d,(i*40)+20 ,(loopCounter*40) +20); //*60 to put it in the right spot 'cause 400/10 = 40. 20 'cause greenfoot uses imgmode center. same concept with the *40 and +20     
                }
                else if((int) a.get(i) == 7){ //if a one  has been assigned 
                    CopyOfMountainImage mi = new CopyOfMountainImage(); //create a road at the designated spot on my 'grid' (a 10 by 10 grid so 600 and 400 each divided by 10)      
                    addObject(mi,(i*40)+20 ,(loopCounter*40)+20); //no +20 cause we don't want to compensate for the centre if there's a blank one next to it    
                   
                }
                else if((int) a.get(i) == 8){ //if a one  has been assigned 
                    Brick d = new Brick(40,40,  new Color(68,68,68)); //create dirt at the designated spot on my 'grid'
                    addObject(d,(i*40)+20 ,(loopCounter*40) +20);
                }
                else{
                }
                
            }
            //System.out.println(" "); //print a new line
            loopCounter +=1; //add one to this so the grid knows to move on to the next arraylist
        }
    }
    
    /**
     * This is a method to handle the fuctions of the buttons in the game screen.
     * It's essentially just handling the back button, stopping the music and 
     * changing the world back to the menu. 
     */
    
    public void buttonsFunctions(){
        if((Greenfoot.mouseClicked(back))){//|| (Greenfoot.mouseClicked(d))){//if the back button is clicked
            MyWorld.music = false; //allow the menu music to play again
            initialize(); //call the reset method
            for(int i =0; i <=ss.size()-1;i++){
                Sounds m = ss.get(i); //get the first index of the sounds arraylist (the only instance of sounds in the program) and tell it to stop the music it's playing
               // m.stopEpicBattleMusic(); //greenfoot's finicky so the music needs to be changed before the world
                m.stopCelticMusicProphecy();
                m.stopCelticMusicKing();
               // m.stopNorrisSong();
            }
            //egg = false; //reset the easter egg
            menu = new MenuScreen(); //make a new world, and therefore a new song
            Greenfoot.setWorld(menu); //greenfoot's finicky so the music needs to be changed before the world
        }
    }
    
    public void clock(){
        if(starter == false){ //a method to run as soon as the program is initiated
            timer.mark();
            starter = true;
        }
        if((timer.millisElapsed()/1000 % 60 ==0) && (timer.millisElapsed()/1000 != 0)){
            minutes++;
            timer.mark();
        }
        if(minutes >=60){
            hours ++;
            minutes =0;
        }
    }
    
    public void selectionStage(){
        if(MyWorld.choosingStage == true){
            for(Village v : villages){
                if(v.isChosen ==  true){
                    counter ++;
                    villages.remove(v);
                    yourSelection.add(v);
                    citiesLeft --;
                    helper.setValue("Settlements Remaining: " + citiesLeft);
                    break;
                }
            }
            for(Castle c : castles){
                if(c.isChosen ==  true){
                    counter ++;
                    castles.remove(c);
                    yourSelection.add(c);
                    citiesLeft --;
                    helper.setValue("Settlements Remaining: " + citiesLeft);
                    break;
                }
            } 
            
        }
        if(counter >= 8){
                MyWorld.choosingStage =  false;
                if(doOnce == false){ //a method to run as soon as the program is initiated
                    timer.mark();
                    removeObject(selections);
                    removeObject(helper);
                    
                    for(Village v : villages){
                        if(MyWorld.typey.equals("Dannicka")){
                            v.axelaImage();
                            troopsCap += v.armyBoost;
                            productionRate += v.goldBoost;
                            culture += v.culturalBoost;
                        }
                        else{
                            v.dannickaImage();
                            troopsCap += v.armyBoost;
                            productionRate += v.goldBoost;
                            culture += v.culturalBoost;
                        }
                    }
                    for(Castle c : castles){
                        if(MyWorld.typey.equals("Dannicka")){
                            c.axelaImage();
                            troopsCap += c.armyBoost;
                            productionRate += c.goldBoost;
                            culture += c.culturalBoost;
                        }
                        else{
                            c.dannickaImage();
                            troopsCap += c.armyBoost;
                            productionRate += c.goldBoost;
                            culture += c.culturalBoost;
                        }
                    } 
                    
                    army.setValue("Troops: " + troops);
                    goldL.setValue("Gold: " +gold);
                    cultureL.setValue("Culture: " + culture);
                    
                    armyCap.setValue("Troops Cap: " + troopsCap);
                    production.setValue("Production Rate: " + Math.ceil(productionRate));
                    cBenefits.setValue("Cultural Benefits: " + culture);
                    
                    addObject(army,325,550);
                    addObject(goldL,500,550);
                    addObject(cultureL,675,550);
                    
                    addObject(armyCap,325,580);
                    addObject(production,500,580);
                    addObject(cBenefits,675,580);
                    
                    addObject(troopB, 100,580);
                    addObject(troopsL, 100,580);
                    
                    doOnce = true;
                }
        }  
        
    }
    public void act(){
        selectionStage();
        buttonsFunctions();
        clock();
        if(MyWorld.choosingStage ==  false){
            timerLabel.setValue(hours + " : " + minutes + " : " +timer.millisElapsed()/1000);
            // if((minutes % 2 ==0) && (minutes !=0)){
            if((timer.millisElapsed()/1000 %10 ==0) && (timer.millisElapsed()/1000 !=0)){
                int i = Greenfoot.getRandomNumber(yourSelection.size());
                Cities c = yourSelection.get(i);
                c.decision();
            }
        }
        
        gold += Math.ceil(productionRate);
        
        if(gold >600){
            if(Greenfoot.mouseClicked(troopsL)){
                troops += 100;
                gold -=600;
            }
        }
        army.setValue("Troops: " + troops);
        goldL.setValue("Gold: " +gold);
        cultureL.setValue("Culture: " + culture);
        
        armyCap.setValue("Troops Cap: " + troopsCap);
        production.setValue("Production Rate: " + Math.ceil(productionRate));
        cBenefits.setValue("Cultural Benefits: " + culture);
        
        
    }
}
