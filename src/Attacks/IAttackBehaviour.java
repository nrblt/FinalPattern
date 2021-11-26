package Attacks;

import Monsters.Monster;

public interface IAttackBehaviour {
    void attack(Monster monster1, Monster monster2);
    String getName();
}
