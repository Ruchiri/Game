/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author HP
 */
public class NormalMonster extends AbstractMonster{
    public NormalMonster(String name, int age) {
        super(name, age);
    }

    @Override
    public void steal(AbstractWarrior warrior) {
         if(! warrior.isImmortal()){
            System.out.println("Moster  :"+getName()+" killed Warrior "+warrior.getName());
            Node node=warrior.getNode();
            grid[node.getX()][node.getY()][1]=null;
            WalkingStick stick=warrior.loseStick();
            walkingSticks.add(stick);
        }
    }
    
}
