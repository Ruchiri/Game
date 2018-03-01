/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.IGrid.grid;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Tree implements IGrid{
    private boolean fruit;
    private Node node;
    private static int noOfTrees=0;
    public Tree(){
        node=new Node(this,0,0);
        fruit=true;
        noOfTrees++;
        setTree();
    }

    private void setTree() {
        Random random=new Random();
        while(true){
            int x=random.nextInt(9)+1;
            int y=random.nextInt(9)+1;
            if (grid[x][y][0]==null & !(x==5 & y==5)){
                getNode().setCoordinates(x, y);
                grid[x][y][0]=getNode();
                System.out.println("Tree "+noOfTrees+" ("+x+" ,"+y+")");
                break; 
            }
        }
    }
    public boolean getFruit(){
        boolean temp=fruit;
        fruit=false;
        return temp;
    }
    /**
     * @return the node
     */
    public Node getNode() {
        return node;
    }
    
}
