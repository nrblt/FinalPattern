package Gear.Weapons;

import Gear.IGearBehaviour;
import Monsters.Monster;

public class WeaponLongSword implements IGearBehaviour {
    @Override
    public void equip(Monster monster)
    {
        monster.addBonusDamage(15);
        monster.addDodge(-20);
        monster.addAccuracy(-20);
        System.out.println(monster.getName() + " equipped Long Sword!\n");
    }
}
