package Factory;

import Gear.Armor.ArmorChainmail;
import Gear.Armor.ArmorLeather;
import Gear.Armor.ArmorSteel;
import Gear.Weapons.WeaponLongSword;
import Gear.Weapons.WeaponShortSword;
import Gear.Weapons.WeaponWoodenSword;
import Monsters.Lizard;
import Monsters.Monster;

public class LizardFactory implements IMonsterFactory{
    public Lizard createStrongMonster(){
        return new Lizard("Armored Lizard", new WeaponLongSword(), new ArmorSteel());
    }
    public Lizard createNormalMonster(){
        return new Lizard("Agile Lizard", new WeaponShortSword(), new ArmorChainmail());
    }
    public Lizard createWeakMonster(){
        return new Lizard("Weakling Lizard", new WeaponWoodenSword(), new ArmorLeather());
    }

}
