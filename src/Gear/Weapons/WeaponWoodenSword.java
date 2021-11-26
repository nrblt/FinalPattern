package Gear.Weapons;

import Gear.IGearBehaviour;
import Monsters.Monster;

public class WeaponWoodenSword implements IGearBehaviour {
    @Override
    public void equip(Monster monster)
    {
        monster.addBonusDamage(5);
        monster.addAccuracy(5);
        System.out.println(monster.getName() + " equipped Wooden Sword!\n");
    }
}
