package kg.hw.game;

import kg.hw.lesson8.RPG_Game;

import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        boolean lucky = RPG_Game.random.nextBoolean();
        int critScale = RPG_Game.random.nextInt(2,4);

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[0].getHealth() > 0 ){
                if(lucky) {
                    heroes[0].setDamage(heroes[0].getDamage() * critScale);
                    System.out.println("Warrior strikes " + getAbility());

                    break;
                }
            }
        }
        heroes[0].getDamage();
    }
}
