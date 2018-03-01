/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author HP
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AbstractMonster m1=new NormalMonster("M1", 10);
        AbstractMonster m2=new NormalMonster("M2", 20);
        AbstractMonster m3=new NormalMonster("M3", 30);
        AbstractMonster m4=new InnocentMonster("M4", 40);
        AbstractMonster m5=new InnocentMonster("M5", 50);
        
        Tree t1=new Tree();
        Tree t2=new Tree();
        Tree t3=new Tree();
        Tree t4=new Tree();
        Tree t5=new Tree();
        
        AbstractWarrior w1=new Warrior("W1",10);
        AbstractWarrior w2=new Warrior("W2",20);
        AbstractWarrior w3=new Warrior("W3",30);
        AbstractWarrior w4=new Warrior("W4",40);
        
        new Thread(w1).start();
        new Thread(w2).start();
        new Thread(w3).start();
        new Thread(w4).start();
        
        
    }
}
