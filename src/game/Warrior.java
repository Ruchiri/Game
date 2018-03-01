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
public class Warrior extends AbstractWarrior{
    public Warrior(String name,int age){
        super(name, age);
    }
    @Override
    public String walk() {
        Node node=getNode();
        Random random=new Random();
        ArrayList<int[]> list1= new ArrayList<int[]>();
        list1.add(new int[]{0,-1});
        list1.add(new int[]{0,1});
        list1.add(new int[]{-1,0});
        list1.add(new int[]{1,0});
        String change;
        while(! list1.isEmpty()){
            int r=random.nextInt(list1.size());
            int x1=node.getX()+list1.get(r)[0];
            int y1=node.getY()+list1.get(r)[1];
            if(x1!=node.getX0() | y1!=node.getY0()){
                change=changePosition(x1,y1);
                if(change!="NONE"){
                    return change;
                }
            }
            list1.remove(list1.get(r));
        }
        change=changePosition(node.getX0(), node.getY0());
        return change;
        
    }
    
    @Override
    public void eat() {
        
    }

    @Override
    public void drink() {
        
    }

    @Override
    public void sleep() {
        
    }
}
