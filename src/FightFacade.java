import Factory.DwarfFactory;
import Factory.LizardFactory;
import Gear.Armor.ArmorChainmail;
import Gear.Armor.ArmorLeather;
import Gear.Armor.ArmorSteel;
import Gear.Weapons.WeaponLongSword;
import Gear.Weapons.WeaponShortSword;
import Gear.Weapons.WeaponWoodenSword;
import Monsters.Dwarf;
import Monsters.Lizard;
import Monsters.Monster;
import Observer.Observable;
import Observer.Observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FightFacade {
    private Observable curPlayer=new Observable("");
    //Fighting process with two AI(lol) monsters
    public void fight(Monster monster1, Monster monster2) throws InterruptedException
    {
        System.out.println("The fight between "+ monster1.getName() +" and " + monster2.getName() + " is starting!\n");
        Thread.sleep(2000);
        monster1.swordBehaviour.equip(monster1);
        monster2.swordBehaviour.equip(monster2);
        monster1.armorBehaviour.equip(monster1);
        monster2.armorBehaviour.equip(monster2);
        if((int)(Math.random()*2)==1)
        {
            System.out.println(monster1.getName()+" moves first!\n");
            Thread.sleep(2000);

            while(monster1.getHp()>0 && monster2.getHp()>0)
            {
                monster1.getListOfAttacks().get((int)(Math.random()*monster1.getListOfAttacks().size())).attack(monster1, monster2);
                Thread.sleep(2000);

                if(monster2.getHp()<=0)
                {
                    System.out.println(monster2.getName()+" was slain! The winner is "+monster1.getName()+"\n" +
                            "The remaining hp is = " + monster1.getHp());
                    break;
                }

                monster2.getListOfAttacks().get((int)(Math.random()*monster2.getListOfAttacks().size())).attack(monster2, monster1);
                Thread.sleep(2000);

                if(monster1.getHp()<=0)
                {
                    System.out.println(monster1.getName()+" was slain! The winner is "+monster2.getName()+"\n" +
                            "The remaining hp is = " + monster2.getHp());
                    break;
                }
            }
        }
        else{
            System.out.println(monster2.getName()+" moves first!\n");
            Thread.sleep(2000);
            while(monster1.getHp()>0 && monster2.getHp()>0)
            {
                monster2.getListOfAttacks().get((int)(Math.random()*monster2.getListOfAttacks().size())).attack(monster2, monster1);
                Thread.sleep(2000);
                if(monster1.getHp()<=0)
                {
                    System.out.println(monster1.getName()+" was slain! The winner is "+monster2.getName()+"\n" +
                            "The remaining hp is = " + monster2.getHp());
                    break;
                }
                monster1.getListOfAttacks().get((int)(Math.random()*monster1.getListOfAttacks().size())).attack(monster1, monster2);
                Thread.sleep(2000);
                if(monster2.getHp()<=0)
                {
                    System.out.println(monster2.getName()+" was slain! The winner is "+monster1.getName()+"\n" +
                            "The remaining hp is = " + monster1.getHp());
                    break;
                }
            }
        }
    }

    public boolean fightInArenaProcess(Monster monster1, Monster monster2) throws InterruptedException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        int userInputInt;
        int roundCounter = 0;
        boolean checker = false;
        System.out.println("The fight between "+ monster1.getName() +" and " + monster2.getName() + " is starting!\n");
        Thread.sleep(2000);
        monster1.swordBehaviour.equip(monster1);
        monster2.swordBehaviour.equip(monster2);
        monster1.armorBehaviour.equip(monster1);
        monster2.armorBehaviour.equip(monster2);
        if((int)(Math.random()*2)==1)
        {
            System.out.println(monster1.getName()+" moves first!\n");
            Thread.sleep(2000);

            while(monster1.getHp()>0 && monster2.getHp()>0 && roundCounter<30)
            {
                while(!checker)
                {
                    System.out.println("Choose your attack type: \n" +
                            "1. "+ monster1.getListOfAttacks().get(0).getName() + "\n" +
                            "2. "+ monster1.getListOfAttacks().get(1).getName() + "\n");
                    userInput = reader.readLine();
                    try{
                        userInputInt = Integer.parseInt(userInput);
                        if(userInputInt<1 || userInputInt>2)
                        {
                            System.out.println("Incorrect number. Try again \n");
                        }
                        else{
                            checker = true;
                            switch (userInputInt){
                                case 1: monster1.getListOfAttacks().get(0).attack(monster1, monster2); break;
                                case 2: monster1.getListOfAttacks().get(1).attack(monster1, monster2); break;
                                default:
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("please, input just a number and nothing else \n");
                    }
                }
                checker = false;
                Thread.sleep(2000);

                if(monster2.getHp()<=0)
                {
                    System.out.println(monster2.getName()+" was slain! The winner is "+monster1.getName()+"\n" +
                            "The remaining hp is = " + monster1.getHp());
                    return true;
                }

                monster2.getListOfAttacks().get((int)(Math.random()*monster2.getListOfAttacks().size())).attack(monster2, monster1);
                Thread.sleep(2000);

                if(monster1.getHp()<=0)
                {
                    System.out.println(monster1.getName()+" was slain! The winner is "+monster2.getName()+"\n" +
                            "The remaining hp is = " + monster2.getHp());
                    return false;
                }
                roundCounter++;
            }
            if(roundCounter>=30)
            {
                System.out.println("Unfortunately, the fight took too long and the crowd is bored. It counts as a loss :(");
            }
        }
        else{
            System.out.println(monster2.getName()+" moves first!\n");
            Thread.sleep(2000);
            while(monster1.getHp()>0 && monster2.getHp()>0 && roundCounter<30)
            {
                monster2.getListOfAttacks().get((int)(Math.random()*monster2.getListOfAttacks().size())).attack(monster2, monster1);
                Thread.sleep(2000);
                if(monster1.getHp()<=0)
                {
                    System.out.println(monster1.getName()+" was slain! The winner is "+monster2.getName()+"\n" +
                            "The remaining hp is = " + monster2.getHp());
                    return false;
                }
                while(!checker)
                {
                    System.out.println("Choose your attack type: \n" +
                            "1. "+ monster1.getListOfAttacks().get(0).getName() + "\n" +
                            "2. "+ monster1.getListOfAttacks().get(1).getName() + "\n");
                    userInput = reader.readLine();
                    try{
                        userInputInt = Integer.parseInt(userInput);
                        if(userInputInt<1 || userInputInt>2)
                        {
                            System.out.println("Incorrect number. Try again \n");
                        }
                        else{
                            checker = true;
                            switch (userInputInt){
                                case 1: monster1.getListOfAttacks().get(0).attack(monster1, monster2); break;
                                case 2: monster1.getListOfAttacks().get(1).attack(monster1, monster2); break;
                                default:
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("please, input just a number and nothing else \n");
                    }
                }
                checker = false;
                Thread.sleep(2000);
                if(monster2.getHp()<=0)
                {
                    System.out.println(monster2.getName()+" was slain! The winner is "+monster1.getName()+"\n" +
                            "The remaining hp is = " + monster1.getHp());
                    return true;
                }
                roundCounter++;
            }
            if(roundCounter>=30)
            {
                System.out.println("Unfortunately, the fight took too long and the crowd is bored. It counts as a loss :(");
            }
        }
        return false;
    }

    //when user chooses "random fight" option
    public void randomFight() throws InterruptedException
    {
        LizardFactory factoryLizard = new LizardFactory();
        DwarfFactory factoryDwarf = new DwarfFactory();
        int randomNumber = (int)(Math.random()*3);
        Lizard lizard = null;
        Dwarf dwarf = null;
        switch (randomNumber) {
            case 0: lizard = factoryLizard.createWeakMonster(); break;
            case 1: lizard = factoryLizard.createNormalMonster(); break;
            case 2: lizard = factoryLizard.createStrongMonster(); break;
            default:
        }
        randomNumber = (int) (Math.random()*3);
        switch (randomNumber) {
            case 0: dwarf = factoryDwarf.createWeakMonster(); break;
            case 1: dwarf = factoryDwarf.createNormalMonster(); break;
            case 2: dwarf = factoryDwarf.createStrongMonster(); break;
            default: break;
        }
        fight(lizard, dwarf);
        System.out.println("\n");
    }




    //When user chooses Arena option
    public Monster createCharacter() throws IOException
    {
        boolean checker = false;
        boolean checker1 = true;
        Monster character = null;
        int raceIndex = -1;
        int weaponIndex = -1;
        int armorIndex = -1;
        String name;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose your character's name: ");
        name = reader.readLine();
        curPlayer.setName(name);
        Observer observer=new Observer(curPlayer,name);
        String userInput;
        int userInputInt;
        while(!checker){
            try {
                System.out.println("Choose your character's race: \n" +
                        "1. Lizard \n" +
                        "2. Dwarf \n");
                userInput = reader.readLine();
                userInputInt = Integer.parseInt(userInput);
                switch (userInputInt) {
                    case 1: raceIndex=1; checker1 = true; break;
                    case 2: raceIndex=2; checker1 = true; break;
                    default:
                        System.out.println("Impossible choice."); checker1 = false;
                }
                if(checker1)
                    checker = true;
            }
            catch (Exception e)
            {
                System.out.println("Please, enter just the number \n");
            }
        }
        checker = false;
        while (!checker)
        {
            System.out.println("Choose your character's weapon: \n" +
                    "1. Long Sword \n" +
                    "2. Short Sword \n" +
                    "3. Wooden Sword");
            userInput = reader.readLine();
            try {
                userInputInt = Integer.parseInt(userInput);
                switch (userInputInt) {
                    case 1: weaponIndex=1; checker1 = true; break;
                    case 2: weaponIndex=2; checker1 = true; break;
                    case 3: weaponIndex=3; checker1 = true; break;
                    default:
                        System.out.println("Impossible choice."); checker1 = false;
                }
                if(checker1)
                    checker = true;
            }
            catch (Exception e)
            {
                System.out.println("Please, enter just the number \n");
            }
        }
        checker = false;
        while (!checker)
        {
            System.out.println("Choose your character's armor: \n" +
                    "1. Steel Armor \n" +
                    "2. Chainmail Armor \n" +
                    "3. Leather Armor");
            userInput = reader.readLine();
            try {
                userInputInt = Integer.parseInt(userInput);
                switch (userInputInt) {
                    case 1: armorIndex=1; checker1 = true; break;
                    case 2: armorIndex=2; checker1 = true; break;
                    case 3: armorIndex=3; checker1 = true; break;
                    default:
                        System.out.println("Impossible choice."); checker1 = false;
                }
                if(checker1)
                    checker = true;
            }
            catch (Exception e)
            {
                System.out.println("Please, enter just the number \n");
            }
        }
        checker = false;

        switch (raceIndex) {
            case 1: switch (weaponIndex) {
                case 1: switch (armorIndex) {
                    case 1: character = new Lizard(name,new WeaponLongSword(), new ArmorSteel()); break;
                    case 2: character = new Lizard(name,new WeaponLongSword(), new ArmorChainmail()); break;
                    case 3: character = new Lizard(name,new WeaponLongSword(), new ArmorLeather()); break;
                } break;
                case 2:  switch (armorIndex) {
                    case 1: character = new Lizard(name,new WeaponShortSword(), new ArmorSteel()); break;
                    case 2: character = new Lizard(name,new WeaponShortSword(), new ArmorChainmail()); break;
                    case 3: character = new Lizard(name,new WeaponShortSword(), new ArmorLeather()); break;
                } break;
                case 3:  switch (armorIndex) {
                    case 1: character = new Lizard(name,new WeaponWoodenSword(), new ArmorSteel()); break;
                    case 2: character = new Lizard(name,new WeaponWoodenSword(), new ArmorChainmail()); break;
                    case 3: character = new Lizard(name,new WeaponWoodenSword(), new ArmorLeather()); break;
                } break;
            } break;
            case 2: switch (weaponIndex) {
                case 1: switch (armorIndex) {
                    case 1: character = new Dwarf(name,new WeaponLongSword(), new ArmorSteel()); break;
                    case 2: character = new Dwarf(name,new WeaponLongSword(), new ArmorChainmail()); break;
                    case 3: character = new Dwarf(name,new WeaponLongSword(), new ArmorLeather()); break;
                } break;
                case 2:  switch (armorIndex) {
                    case 1: character = new Dwarf(name,new WeaponShortSword(), new ArmorSteel()); break;
                    case 2: character = new Dwarf(name,new WeaponShortSword(), new ArmorChainmail()); break;
                    case 3: character = new Dwarf(name,new WeaponShortSword(), new ArmorLeather()); break;
                } break;
                case 3:  switch (armorIndex) {
                    case 1: character = new Dwarf(name,new WeaponWoodenSword(), new ArmorSteel()); break;
                    case 2: character = new Dwarf(name,new WeaponWoodenSword(), new ArmorChainmail()); break;
                    case 3: character = new Dwarf(name,new WeaponWoodenSword(), new ArmorLeather()); break;
                } break;
            } break;
            default: character = new Lizard("null Lizard",new WeaponWoodenSword(), new ArmorSteel()); break;
        }
        return character;
    }
    public void arenaFight(Monster character) throws InterruptedException, IOException
    {
        int saveHp = character.getHp();
        boolean fightResult;
        LizardFactory factoryLizard = new LizardFactory();
        DwarfFactory factoryDwarf = new DwarfFactory();
        Lizard[] lizard = new Lizard[3];
        Dwarf[] dwarf = new Dwarf[3];
        for(int i=0; i<3; i++)
        {
            int randomNumber = (int)(Math.random()*2);
            int randomNumber1 = (int)(Math.random()*3);
            switch (randomNumber) {
                case 0:
                    switch (randomNumber1) {
                        case 0: lizard[i] = factoryLizard.createWeakMonster(); break;
                        case 1: lizard[i] = factoryLizard.createNormalMonster(); break;
                        case 2: lizard[i] = factoryLizard.createStrongMonster(); break;
                        default:
                    }
                    break;
                case 1:
                    switch (randomNumber1) {
                        case 0: dwarf[i] = factoryDwarf.createWeakMonster(); break;
                        case 1: dwarf[i] = factoryDwarf.createNormalMonster(); break;
                        case 2: dwarf[i] = factoryDwarf.createStrongMonster(); break;
                        default: break;
                    }
                    break;
                default:
            }
            if(randomNumber==0)
                fightResult = fightInArenaProcess(character, lizard[i]);
            else fightResult = fightInArenaProcess(character, dwarf[i]);
            if(!fightResult)
            {
                System.out.println("You lost the number " + i+1 + " fight! That's unfortunate :(");
                return;
            }
            character.setHp(saveHp);
        }
        System.out.println("You have won all the fights! You are a new arena champion, congratulations!");
        curPlayer.sendMessage();

    }
}
