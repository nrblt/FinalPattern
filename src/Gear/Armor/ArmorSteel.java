package Gear.Armor;

import Gear.IGearBehaviour;
import Monsters.Monster;

public class ArmorSteel implements IGearBehaviour {
    @Override
    public void equip(Monster monster)
    {
        monster.addDodge(-20);
        monster.addProtection(+40);
        monster.addBonusDamage(+15);
        monster.addAccuracy(-15);
        System.out.println(monster.getName() + " equipped Steel Armor!\n");
    }
}
