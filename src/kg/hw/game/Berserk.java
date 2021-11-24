package kg.hw.game;

import kg.hw.lesson8.RPG_Game;

public class Berserk extends Hero {
    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    public void applySuperPower(Boss boss, Hero[] heroes) {
        int blocked = RPG_Game.random.nextInt(boss.getDamage() - 18) + 18;
            if (heroes[2].getHealth() > 0){
               heroes[2].setHealth (blocked);
               boss.setHealth(boss.getHealth()-blocked);
            }
        System.out.println(this.getName() + " applies " + getAbility());
    }

}