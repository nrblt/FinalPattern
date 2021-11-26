package Monsters;

import Attacks.IAttackBehaviour;
import Gear.IGearBehaviour;
import Attacks.AttackSimple;
import Attacks.AttackSpeedSlash;

import java.util.LinkedList;
import java.util.List;

public class Lizard extends Monster {
    List<IAttackBehaviour> listOfAttacks = new LinkedList<>();
    //constructor using Strategy
    public Lizard(String name, IGearBehaviour weaponBehaviour, IGearBehaviour armorBehaviour)
    {
        super(weaponBehaviour, armorBehaviour);
        this.listOfAttacks.add(new AttackSpeedSlash());
        this.listOfAttacks.add(new AttackSimple());
        this.setName("The Fastest "+name);
        this.setHp(110);
        this.setProtection(10);
        this.setDodge(25);
        this.setAccuracy(100);
    }
    public void checkMonster()
    {
        System.out.println("Monsters.Monster's race is " + getClass().toString().substring(6) + ",\n name is '"+ getName() + "',\n his max hp is " + getHp() + ",\n his protection is " + getProtection() + "%,\n his dodge is " + getDodge() + "%.\n");
    }
    public List<IAttackBehaviour> getListOfAttacks()
    {
        return this.listOfAttacks;
    }
}
