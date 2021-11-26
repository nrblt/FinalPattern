package Gear.Armor;

import Gear.IGearBehaviour;
import Monsters.Monster;

public class ArmorLeather implements IGearBehaviour {
    @Override
    public void equip(Monster monster)
    {
        monster.addDodge(20);
        monster.addProtection(5);
        monster.addBonusDamage(-1);
        monster.addAccuracy(5);
        System.out.println(monster.getName() + " equipped Leather Armor!\n");

    }
}
