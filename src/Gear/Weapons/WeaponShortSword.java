package Gear.Weapons;

import Gear.IGearBehaviour;
import Monsters.Monster;

public class WeaponShortSword implements IGearBehaviour {
    @Override
    public void equip(Monster monster)
    {
        monster.addBonusDamage(7);
        monster.addDodge(7);
        System.out.println(monster.getName() + " equipped Short Sword!\n");

    }
}
