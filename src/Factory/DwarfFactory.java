package Factory;

import Gear.Armor.ArmorChainmail;
import Gear.Armor.ArmorLeather;
import Gear.Armor.ArmorSteel;
import Gear.Weapons.WeaponLongSword;
import Gear.Weapons.WeaponShortSword;
import Gear.Weapons.WeaponWoodenSword;
import Monsters.Dwarf;
import Monsters.Monster;

public class DwarfFactory implements IMonsterFactory{
    public Dwarf createStrongMonster(){
        return new Dwarf("Armored Dwarf", new WeaponLongSword(), new ArmorSteel());
    }
    public Dwarf createNormalMonster(){
        return new Dwarf("Agile Dwarf", new WeaponShortSword(), new ArmorChainmail());
    }
    public Dwarf createWeakMonster(){
        return new Dwarf("Weakling Dwarf", new WeaponWoodenSword(), new ArmorLeather());
    }
}
