/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.IGrid.grid;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public abstract class AbstractWarrior extends Inhabitant implements IObservable,Runnable{
    private static int NoOfWarriors=0;
    private boolean mobility;
    private boolean immortal;
    private WalkingStick walkingStick;
    private Node node;
    //private ArrayList<AbstractWarrior> warriorList=new ArrayList<AbstractWarrior>();
    public String q;
    
    public AbstractWarrior(String name,int age){
        super(name,age);
        mobility=true;
        immortal=false;
        //warriorList.add(this);
        NoOfWarriors++;
        walkingStick=new WalkingStick(name);    
        node=new Node(this,0,0);
        setWarrior();                           //place the warriors
    }
    private void setWarrior() {
        Random random=new Random();
        while(true){
             int x = random.nextInt(11);        
             int y = random.nextInt(11);
             if(grid[x][y][1]==null & (x==0|x==10|y==0|y==10)){     //place warrior at the boader
                 getNode().setCoordinates(x, y);
                 grid[x][y][1]=getNode();
                 System.out.println("Warrior "+getName()+" ("+x+" ,"+y+")");
                 break;
            }
        }
    }
    public abstract String walk();
    
    public String changePosition(int x,int y){
        Node node=getNode();
        if(x<11 & x>-1 & y<11 &y>-1){                                      
            synchronized(grid){
                if(grid[x][y][1]==null){                                            
                    grid[node.getX()][node.getY()][1]=null;
                    node.setCoordinates(x, y);
                    grid[x][y][1]=node;                                          

                    if(x==5 && y==5){ 
                        q="MOUNTDOOM";
                        return q;
                    }else if(grid[x][y][0]!=null && grid[x][y][0].getObject() instanceof Tree){
                        q="TREE";
                        return q;
                    }else if(grid[x][y][0]!=null && grid[x][y][0].getObject() instanceof AbstractMonster){
                        q="INNOCENTMONSTER";
                        return q;
                    }else{
                        q="WALKED";
                        return q;
                    }
                }else{
                    System.out.println("Warrior :"+getName()+" ( "+x+" "+y+" )");
                }
            }
        }else{
            //System.out.println("Warrior :"+getName()+" ###(edge) "+x+" "+y);
        }
        q="NONE";
        return q;
        
    }
    public WalkingStick loseStick(){
        
        WalkingStick tempStick = walkingStick;
        this.setMobility(false);
        walkingStick = null;
        return tempStick;
    }
    public void run(){
        
        while(mobility){
            String change=walk();
            if(change=="NONE"){
                continue;
            }
            int x=node.getX();
            int y=node.getY();
            if(change=="MOUNTDOOM"){
                System.out.println("Warrior :"+getName()+" ( "+x+","+y+" )found MOUNT DOOM.");
                break;
            }else if(change=="WALKED"){
                System.out.println("Warrior :"+getName()+" ( "+x+","+y+" )");
            }else if(change=="TREE"){
                Tree tree=(Tree) grid[x][y][0].getObject();
                if(tree.getFruit()){
                    immortal=true;
                    System.out.println("Warrior :"+getName()+" ( "+x+","+y+" )  (immortal)");
                }else{
                    System.out.println("Warrior :"+getName()+" ( "+x+","+y+" )  (tree)");
                }
            }else if(change=="INNOCENTMONSTER"){
                synchronized(grid){
                    notifyObservers();
                }
            }
        }
     //}
    }
    /**
     * @return the mobility
     */
    public boolean isMobility() {
        return mobility;
    }

    /**
     * @param mobility the mobility to set
     */
    public void setMobility(boolean mobility) {
        this.mobility = mobility;
    }

    /**
     * @return the immortal
     */
    public boolean isImmortal() {
        return immortal;
    }
     /**
     * @param immortal the immortal to set
     */
    public void setImmortal(boolean immortal) {
        this.immortal = immortal;
    }
    
    /**
     * @return the NoOfWarriors
     */
    public static int getNoOfWarriors() {
        return NoOfWarriors;
    }
    /**
     * @return the node
     */
    public Node getNode() {
        return node;
    }
    public void attach(IObserver observer){
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }
    
    public void dettach(IObserver observer){
        observers.remove(observer);
    }
   
    public void notifyObservers(){
        for(IObserver observer:observers){
            observer.update(this);
        }
    }
    public abstract void eat();
    public abstract void drink();
    public abstract void sleep();
}
