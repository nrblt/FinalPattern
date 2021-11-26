package Gear.Armor;

import AdapterArmor.MyArmor;
import AdapterArmor.ToHPImplementation;
import Gear.IGearBehaviour;
import Monsters.Monster;

public class ArmorChainmail implements IGearBehaviour {
    @Override
    public void equip(Monster monster)
    {
        monster.addDodge(15);
        monster.addProtection(10);
        monster.addBonusDamage(-3);
        monster.addAccuracy(-5);

        MyArmor myArmor=new MyArmor(10);
        ToHPImplementation toHPImplementation=new ToHPImplementation(myArmor);
//        System.out.println(toHPImplementation.getArmorHPValue());
        System.out.println(monster.getName() + " equipped Chainmail Armor! It's protection is " +
                "10 and it can save from \n"+toHPImplementation.getArmorHPValue()+"damage");
    }
}
