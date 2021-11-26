package Factory;

import Monsters.Monster;

public interface IMonsterFactory {
    Monster createStrongMonster();
    Monster createNormalMonster();
    Monster createWeakMonster();
}
