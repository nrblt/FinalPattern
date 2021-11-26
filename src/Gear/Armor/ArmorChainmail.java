package Gear.Armor;

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
        System.out.println(monster.getName() + " equipped Chainmail Armor!\n");

    }
}
