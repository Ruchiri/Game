/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author HP
 */
public class Node {
    private int x0;
    private int y0;
    private int x;
    private int y;
    
    private IGrid obj;
    Node(IGrid obj,int x,int y){
        this.obj=obj;
        this.x=x;
        this.y=y;
    }
    public void setCoordinates(int x,int y){
        x0=this.x;
        y0=this.y;
        this.x=x;
        this.y=y;
    }

    /**
     * @return the x0
     */
    public int getX0() {
        return x0;
    }

    /**
     * @return the y0
     */
    public int getY0() {
        return y0;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the object
     */
    public IGrid getObject() {
        return obj;
    }
    
}
