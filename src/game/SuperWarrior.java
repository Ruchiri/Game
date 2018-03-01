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
public class SuperWarrior extends AbstractWarrior{
    public SuperWarrior(String name,int age){
        super(name, age);
    }

    @Override
    public String walk() {
        Random random=new Random();
        Node node=getNode();
        
        ArrayList<int[]> treeList=binocularView();
        
        String change;
        while(! treeList.isEmpty()){
            int r=random.nextInt(treeList.size());
            int x1=treeList.get(r)[0];
            int y1=treeList.get(r)[1];
            if(x1!=node.getX0() | y1!=node.getY0()){
                change=changePosition(x1,y1);
                if(change!="NONE"){
                    return change;
                }
            }
            treeList.remove(treeList.get(r));
        }
        
        ArrayList<int[]> list2=new ArrayList<int[]>();
        list2.add(new int[]{0,-1});
        list2.add(new int[]{0,1});
        list2.add(new int[]{-1,0});
        list2.add(new int[]{1,0});
        
        while(! list2.isEmpty()){
            int r=random.nextInt(list2.size());
            int x1=node.getX()+list2.get(r)[0];
            int y1=node.getY()+list2.get(r)[1];
            if(x1!=node.getX0() | y1!=node.getY0()){
                change=changePosition(x1,y1);
                if(change!="NONE"){
                    return change;
                }
            }
            list2.remove(list2.get(r));
        }
        
        change=changePosition(node.getX0(), node.getY0());
        return change;
    }
    public ArrayList<int[]> binocularView(){                                                  
        Node node=getNode();
        ArrayList<int[]> treeList=new ArrayList<int[]>();
        int x=node.getX();
        int y=node.getY();
        if(x!=0 && grid[x][y-1][0]!=null && grid[x][y-1][0].getObject() instanceof Tree){
            treeList.add(new int[]{x,y-1});
        }else if(x!=10 && grid[x][y+1][0]!=null && grid[x][y+1][0].getObject() instanceof Tree){
            treeList.add(new int[]{x,y+1});
        }else if(y!=0 && grid[x-1][y][0]!=null && grid[x-1][y][0].getObject() instanceof Tree){
            treeList.add(new int[]{x-1,y});
        }else if(y!=10 && grid[x+1][y][0]!=null && grid[x+1][y][0].getObject() instanceof Tree){
            treeList.add(new int[]{x+1,y});
        }
        return treeList;
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
