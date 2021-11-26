package Monsters;

import Attacks.IAttackBehaviour;
import Gear.IGearBehaviour;
import Attacks.AttackMightyCrash;
import Attacks.AttackSimple;

import java.util.LinkedList;
import java.util.List;

public class Dwarf extends Monster {
    List<IAttackBehaviour> listOfAttacks = new LinkedList<>();
    //constructor using Strategy
    public Dwarf(String name, IGearBehaviour weaponBehaviour, IGearBehaviour armorBehaviour)
    {
        super(weaponBehaviour, armorBehaviour);
        this.listOfAttacks.add(new AttackMightyCrash());
        this.listOfAttacks.add(new AttackSimple());
        this.setName("The Mightiest "+name);
        this.setHp(90);
        this.setProtection(25);
        this.setDodge(10);
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
