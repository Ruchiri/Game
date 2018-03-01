/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HP
 */
public abstract class AbstractMonster extends Inhabitant implements IObserver{
    protected ArrayList<WalkingStick> walkingSticks;
    private Node node;
    public AbstractMonster(String name,int age){
        super(name, age);
        walkingSticks = new ArrayList<WalkingStick>();      //to keep the stole sticks from the warrior
        node=new Node(this,0,0);
        setMonster();                                       //place the monster in the grid
        AbstractWarrior.observers.add(this);
    }

    private void setMonster() {
        Random random=new Random();
        while(true){
            int x=random.nextInt(9)+1;                     //to get nodes from the center of the grid
            int y=random.nextInt(9)+1;
            if (grid[x][y][0]==null & !(x==5 & y==5)){      //checking for a possible node
                getNode().setCoordinates(x, y);
                grid[x][y][0]=getNode();                    //place the monster in grid
                System.out.println("Monster "+getName()+" ("+x+" ,"+y+")");
                break; 
            }
        }
    }
    public abstract void steal(AbstractWarrior warrior);
    
    /**
     * @return the node
     */
    public Node getNode() {
        return node;
    }
    public void update(IObservable  observable){
        Node node=getNode();
        int x=node.getX();
        int y=node.getY();
        if(grid[x][y][1]!= null){                               //lookig for warrior in the same location
            AbstractWarrior warrior=(AbstractWarrior) observable;
            if(warrior==grid[x][y][1].getObject()){
                steal(warrior);                                 //steal the walkingstick of the warrior
            }
        }
    }
}
