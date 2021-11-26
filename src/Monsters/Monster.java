package Monsters;

import Attacks.IAttackBehaviour;
import Gear.IGearBehaviour;

import java.util.LinkedList;
import java.util.List;

public abstract class Monster {

    //fields
    private String name;
    private int hp;
    private int protection; //reduces attack's damage in percent proportion
    private int dodge; //increases a chance of evading an incoming attack
    private int bonusDamage;
    private int accuracy;
    public IGearBehaviour swordBehaviour, armorBehaviour;
    List<IAttackBehaviour> listOfAttacks = new LinkedList<>();
    //constructor using Bridge
    public Monster(IGearBehaviour swordBehaviour, IGearBehaviour armorBehaviour)
    {
        this.swordBehaviour=swordBehaviour;
        this.armorBehaviour=armorBehaviour;
    }

    public Monster()
    {

    }

    //methods
    public abstract void checkMonster();


//    public void fight(Monster monster) throws InterruptedException
//    {
//        System.out.println("The fight between "+ this.getName() +" and " + monster.getName() + " is starting!\n");
//        Thread.sleep(2000);
//        this.swordBehaviour.equip(this);
//        monster.swordBehaviour.equip(monster);
//        this.armorBehaviour.equip(this);
//        monster.armorBehaviour.equip(monster);
//        if((int)(Math.random()*2)==1)
//        {
//            System.out.println(this.getName()+" moves first!\n");
//            Thread.sleep(2000);
//
//            while(this.hp>0 && monster.hp>0)
//            {
//                this.listOfAttacks.get((int)(Math.random()*listOfAttacks.size())).attack(this, monster);
//                Thread.sleep(2000);
//
//                if(monster.getHp()<=0)
//                {
//                    System.out.println(monster.getName()+" was slain! The winner is "+this.getName()+"\n" +
//                            "The remaining hp is = " + this.getHp());
//                    break;
//                }
//
//                monster.listOfAttacks.get((int)(Math.random()*listOfAttacks.size())).attack(monster, this);
//                Thread.sleep(2000);
//
//                if(this.getHp()<=0)
//                {
//                    System.out.println(this.getName()+" was slain! The winner is "+monster.getName()+"\n" +
//                            "The remaining hp is = " + monster.getHp());
//                    break;
//                }
//            }
//        }
//        else{
//            System.out.println(monster.getName()+" moves first!\n");
//            Thread.sleep(2000);
//            while(this.hp>0 && monster.hp>0)
//            {
//                monster.listOfAttacks.get((int)(Math.random()*listOfAttacks.size())).attack(monster, this);
//                Thread.sleep(2000);
//                if(this.getHp()<=0)
//                {
//                    System.out.println(this.getName()+" was slain! The winner is "+monster.getName()+"\n" +
//                            "The remaining hp is = " + monster.getHp());
//                    break;
//                }
//                this.listOfAttacks.get((int)(Math.random()*listOfAttacks.size())).attack(this, monster);
//                Thread.sleep(2000);
//                if(monster.getHp()<=0)
//                {
//                    System.out.println(monster.getName()+" was slain! The winner is "+this.getName()+"\n" +
//                            "The remaining hp is = " + this.getHp());
//                    break;
//                }
//            }
//        }
//    }

    //Name getter and setter
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    //Health Points getter, setter and adding
    public int getHp()
    {
        return hp;
    }
    public void setHp(int hp)
    {
        this.hp = hp;
    }
    public void addHp(int hp){this.setHp(this.getHp()+hp);}

    //Protection getter, setter and adding
    public int getProtection()
    {
        return protection;
    }
    public void setProtection(int protection)
    {
        this.protection = protection;
    }
    public void addProtection(int protection){this.setProtection(this.getProtection()+protection);}

    //Dodge getter, setter and adding
    public int getDodge() {
        return dodge;
    }
    public void setDodge(int dodge) {
        this.dodge = dodge;
    }
    public void addDodge(int dodge){this.setDodge(this.getDodge() + dodge);}


    public int getBonusDamage() {
        return bonusDamage;
    }
    public void setBonusDamage(int bonusDamage) {
        this.bonusDamage = bonusDamage;
    }
    public void addBonusDamage(int bonusDamage){this.setBonusDamage(this.getBonusDamage()+bonusDamage);}

    public int getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    public void addAccuracy(int accuracy){this.setAccuracy(this.getAccuracy()+accuracy);}

    public List<IAttackBehaviour> getListOfAttacks()
    {
        return this.listOfAttacks;
    }
}
