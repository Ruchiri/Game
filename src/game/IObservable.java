/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public interface IObservable {
    public static final ArrayList<IObserver> observers=new ArrayList();
    
    public abstract void attach(IObserver observer);
    public abstract void dettach(IObserver observer);
    public abstract void notifyObservers();
}
