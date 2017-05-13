import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.awt.Color;
/**This is a scrolling world class that holds the credits to the game. 
 * By repositioning all the text actors realtive to the up or down buttons 
 * being clicked, I effectively made a scrolling world as the all the actors
 * move up when up is pressed or they move down when down is pressed. 
 * Basically there is an arraylist of lines and a 
 * int counter and offcounter. Counter is the index of the line that is
 * to be added to the screen from the bottom and offcounter is the index
 * of the line that should be added to the top should you scroll down. They
 * both increase or decrease relative to the amount of times the scroll up
 * or scroll down button is pressed and in the button functions method, it goes
 * through a for loop of the whole array, repositions what needs to be, removes
 * any at the top or bottom then adds the line at counter or offCounter. There 
 * is also a button to reset the instructions to the top by removeing all the
 * objects and reseting the counters. 
 * Pretty genius if i do say so myself,
 * and the best part of the whole thing is that i came up with it 100% by
 * myself. I'm proud!. 
 * 
 * @Nicholas Paul 
 * @Version 18
 */
public class Credits extends World
{
    protected Label q,w,e,r,t,y,u,i,o,p,l;
    protected Button b,sU,sD,top,bottom,egg;
    protected MenuScreen menu;
    protected ArrayList <FileText> h = new ArrayList();
    protected FileText[] hey = new FileText[43];
    protected int counter,offCounter;
    protected FileText clickable = new FileText();;
    
    protected ArrayList <FileText> tempList = new ArrayList();
    
    /**This is a general constructor for the credits class.
     * It creates the buttons and labels.
     */
    
    public Credits()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
       counter = 11;
       offCounter = -2; //'cause the first line is line 0 and it starts 2 down
        
       createText();
       
       b = new Button(100,50);
       addObject(b,500,350);
       
       l = new Label("back", 50);
       addObject(l,500,350);
       
       q= new Label("Faleore; A Kingdom Divided", 50);
       addObject(q,300,50);
       
       sD = new Button(125,25);
       addObject(sD,100,350);
       
       w= new Label("Scroll Down", 25);
       addObject(w,100,350);
       
       sU = new Button(125,25);
       addObject(sU,237,350);
       
       e= new Label("Scroll Up", 25);
       addObject(e,237,350);
       
       top = new Button(125,25);
       addObject(top,375,350);
       
       p= new Label("Back to top?", 25);
       addObject(p,375,350);
       
       
    }
    
    /**This method controls the functionality of the buttons.
     * It is here that the counters are manipulated to show different index
     * dependant on how far up or down the user has scolled. Objects are 
     * added to the world dependant on the conters and removed dependant on 
     * the counters. All the text actors are deleted and recreated when back
     * to top is clicked. The easter eggs are handled here.
     */
    
    public void buttonsFunctions(){
        if(Greenfoot.mouseClicked(l)){
            menu = new MenuScreen();
            Greenfoot.setWorld(menu);
        }
        
         if(Greenfoot.mouseClicked(w)){ //if the scroll up label is pressed
            
            List a = getObjects(FileText.class);
            for(int i =0;i<h.size();i++){
                if (a.contains(h.get(i))) { //check if the object at i exists in the world by corresponding it with the list of object in the world      
                    if(h.get(i).getY() < 100){ //if it gets to the knight's call label
                        FileText ay = h.get(i);
                        removeObject(ay); 
                    }
                    else{
                        h.get(i).setLocation(h.get(i).getX(),h.get(i).getY()-20); //move everything up
                        
                    }
                }
                if(i == counter){ //if it's the line after the ones that are being currently displayed
                    addObject(h.get(i),300,300); //add it to the world at the bottom of the page
                }
            }
            counter +=1; //add one to counter of lines off the screen (next to add)
           offCounter +=1; //if a line gets to the top add one to the lines off the screen
           //System.out.println(offCounter);
           //System.out.println(counter);
        }
        
        if(Greenfoot.mouseClicked(e)){ //if the scroll down label is pressed 
            List a = getObjects(FileText.class);
            for(int i =0;i<h.size();i++){
                if (a.contains(h.get(i))) { //check if the object at i exists in the world by corresponding it with the list of object in the world      
                    if(h.get(i).getY() > 300){ //if it gets to buttons
                        FileText ay = h.get(i);
                        removeObject(ay);
                    }
                    else{
                        h.get(i).setLocation(h.get(i).getX(),h.get(i).getY()+20); //move everything down
                        
                    }
                }
                if((i == offCounter)){ //if it's the line before the ones that are being currently displayed 
                    addObject(h.get(i),300,80); //add it to the world at the top of the page
                }
            }
            offCounter -=1; //sub one from the counter of lines off the screen 
            counter -=1; //if a line gets to the bottom sub one to the lines off the bottom of the screen
            //System.out.println(offCounter);
            //System.out.println(counter);
        }
        
        if(Greenfoot.mouseClicked(p)){ //if back to top is clicked
            List a = getObjects(FileText.class);
            for(int i =0; i<a.size();i++){ //erase all the text on the screen
                removeObject((FileText) a.get(i)); 
            }
            createText(); //redo all the text
            counter = 11; //reset the counters
            offCounter =-2; 
            
        }
        
        if(Greenfoot.mouseClicked(clickable)){ //if the easter egg is clicked, ohhh your in for a treat
            //MyWorld.egg= true;
            
        }
        
    }
    
    //for the two methods createText and scanText check the credits tab
    
    /**This is a method to create text actors to represent text in a given file Concept: davmac.
     * This method takes a string array from scanText and creates actors.
     * I could find any other way to do this apart from his method, and 
     * though it is not directly copy-pasted, i'm using his concept. 
     * What i did to this method was have it add the actors to an arraylist 
     * and only add the ones that could fit on the screen. The others just 
     * be created and wait to be added from the scroll functionality in 
     * buttonFuncitons(). The easter eggs are created here. 
     * 
     */
    
    public void createText(){
        try{
            String [] text = scanText(); //assign this string array to the one scanned from scan text 
            for(int i=0;i<25;i++){ //10 bigger than it needs to be 'cause empty lines
                if(text[i] != null){
                    GreenfootImage lineImage = new GreenfootImage(text[i],
                                18, Color.BLACK, Color.WHITE);
                    FileText a = new FileText();
                    //h.add(a); //add the line of text to the arraylist
                    a.setImage(lineImage);
                    h.add(a);
                    if(i < 11){//this is making it only add the stuff thats on the screen
                        tempList.add(a);
                        addObject(a, 300, i * 20 + 100);
                    }
                }
            }
            //declare new line actors
           
           FileText a = new FileText(), b = new FileText(), c = new FileText(), d = new FileText(), e = new FileText(), f = new FileText(), g = new FileText(), j = new FileText(), k = new FileText(), l = new FileText();
          
           /*
           //easater egg line
           GreenfootImage hi = new GreenfootImage("Hi.",
                                18, Color.BLACK, Color.WHITE);
           a.setImage(hi);
           
           h.add(a);
           //spacing
           emptyLines();
           
           
           
           //easater egg line
           GreenfootImage question = new GreenfootImage("I have a very important question for you.",
                                18, Color.BLACK, Color.WHITE);
           b.setImage(question);
           
           h.add(b);
           //spacing
           emptyLines();
           
           
           //easater egg line
           GreenfootImage front = new GreenfootImage("To ask, i'm going to call you all down to the front.",
                                18, Color.BLACK, Color.WHITE);
           c.setImage(front);
           
           h.add(c);
           //spacing
           emptyLines();
          
           
           //easater egg line
           GreenfootImage laptop = new GreenfootImage("And leave your laptops at your desk,",
                                18, Color.BLACK, Color.WHITE);
           d.setImage(laptop);
           
           h.add(d);
           //spacing
           emptyLines();
           
           
           //easater egg line
           GreenfootImage notes = new GreenfootImage("Nick you won't need to take notes.",
                                18, Color.BLACK, Color.WHITE);
           e.setImage(notes);
           
           h.add(e);
           //spacing
           emptyLines();
           
           
           
           //easater egg line
           GreenfootImage sinha = new GreenfootImage("Who is Sinha?",
                                18, Color.BLACK, Color.WHITE);
           f.setImage(sinha);
           
           h.add(f);
           //spacing
           emptyLines();
           
           
           
           
           //easater egg line
           GreenfootImage teacher = new GreenfootImage("A Teacher",
                                18, Color.BLACK, Color.WHITE);
           g.setImage(teacher);
           
           h.add(g);
           
           //spacing
           emptyLines();
           
           
           
           
           //easater egg line
           GreenfootImage cena = new GreenfootImage("John Cena",
                                18, Color.BLACK, Color.WHITE);
           j.setImage(cena);
           
           h.add(j);
           
           //spacing
           emptyLines();
           
           
           
           
           //easater egg line
           GreenfootImage norris = new GreenfootImage("or Chuck Norris in disguise",
                                18, Color.BLACK, Color.WHITE);
           clickable.setImage(norris); 
           
           h.add(clickable);
           
           //spacing
           emptyLines();
           
           
           //easater egg line
           GreenfootImage choose = new GreenfootImage("Select one of the above three options by clicking on it.",
                                18, Color.BLACK, Color.WHITE);
           l.setImage(choose);
           
           h.add(l);
           
           //spacing
           */
        }
        catch (IOException ioe) {
            GreenfootImage lineImage = new GreenfootImage("N/A",
                   18, Color.WHITE, Color.BLACK);
            FileText a = new FileText();
                    a.setImage(lineImage);
                    addObject(a, 300,100);
        }
    }
    
    /*public void emptyLines(){
        try{
            String [] text = scanText();
            for(int i = 15;i<20;i++){ //add 5 blank lines to the list
                   GreenfootImage lineImage = new GreenfootImage(text[i],
                                    18, Color.BLACK, Color.WHITE);
                        FileText a = new FileText();
                        //h.add(a); //add the line of text to the arraylist
                        a.setImage(lineImage);
                        h.add(a);
                   
                }
        }
        catch (IOException ioe) {
            GreenfootImage lineImage = new GreenfootImage("N/A",
                   18, Color.WHITE, Color.BLACK);
            FileText a = new FileText();
                    a.setImage(lineImage);
                    addObject(a, 300,100);
        }
    }*/
        
    /**This is a method that scans a specific text file and assigns the values to a string array Author: davmac.
     * I could find any other way to do this apart from his method, and 
     * though it is not directly copy-pasted, i'm using his concept. 
     */
    
    public String [] scanText () throws IOException{ //this is a method that will scan the text file
        
        String [] text = new String[100]; //the amount of lines in my text file
        InputStream is = getClass().getClassLoader().getResourceAsStream("credits.txt");
        BufferedReader s = new BufferedReader(new InputStreamReader(is)); //scane through the given string
        
           //Scanner s = new Scanner("TheKnightsCallInstructions.txt");
            for(int i =0; i<100; i++){
                text[i] = s.readLine();
            }
        
        return text;
    }
    
     public void act(){
         buttonsFunctions();
         //System.out.println(MyWorld.egg);
        }
    
}
