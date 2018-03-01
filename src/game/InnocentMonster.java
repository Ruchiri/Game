/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author HP
 */
public class InnocentMonster extends AbstractMonster{
    public InnocentMonster(String name,int age){
        super(name, age);
    }
    @Override
    public void steal(AbstractWarrior warrior) {
        WalkingStick stick=warrior.loseStick();
        System.out.println("Moster  :"+getName()+" steal from Warrior "+warrior.getName());
        walkingSticks.add(stick);
    }
    
}
