package Attacks;

import Monsters.Monster;

public class AttackSpeedSlash implements IAttackBehaviour {
    String name = "Speed Slash";
    @Override
    public void attack(Monster monster1, Monster monster2)
    {
        int accuracy = monster1.getAccuracy()+30-monster2.getDodge();
        if((int)(Math.random()*100)>accuracy)
        {
            System.out.println(monster2.getName() + " avoided the Speed Slash Attack!");
            System.out.println(monster2.getName() + "'s hp equals " + monster2.getHp() + "\n");
        }
        else
        {
            monster2.setHp(monster2.getHp()-(int)((5 + monster1.getBonusDamage())*(100 - monster2.getProtection())/100));
            System.out.println(monster2.getName() + " was hit by the Speed Slash Attack! It lost " + (int)((5 + monster1.getBonusDamage())*(100 - monster2.getProtection())/100) + "hp");
            System.out.println(monster2.getName() + "'s hp equals " + monster2.getHp() + "\n");
        }
    }

    public String getName() {
        return name;
    }
}
