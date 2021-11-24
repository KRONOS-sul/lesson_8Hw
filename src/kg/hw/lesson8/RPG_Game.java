package kg.hw.lesson8;
import kg.hw.game.*;


import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(999, 88, "Midir The World Ender");
        Warrior warrior = new Warrior(365, 30, "Barbarian");
        Medic doc = new Medic(265, 16, 40, "Aibolit");
        Berserk berserk = new Berserk(299, 55, "Berserker");
        Magic magic = new Magic(340, 40, "Cast over");
        Medic assistant = new Medic(299, 25, 17, "Med. Trainee");
        Hero[] heroes = {warrior, doc, berserk, magic, assistant};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        roundNumber++;
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesAppliesSuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("    Great foe vanquished         ");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("         Game Over");
        }
        return allHeroesDead;
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
        }
    }

    private static void heroesAppliesSuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                heroes[i].applySuperPower(boss, heroes);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println((roundNumber == 0 ? "BEFORE START" : roundNumber + " ROUND")
                + " ____________________\n");
        System.out.println("\u001B[31m" + boss.getName() + "\u001B[0m" +
                " HP: " + boss.getHealth() + " [" + boss.getDamage()+ "]\n");
        for (int i = 0; i < heroes.length; i++) {
            /*System.out.println(heroes[i].getClass().getSimpleName() +
                    " health: " + heroes[i].getHealth()
                    + "[" + heroes[i]-.getDamage() + "]");*/
            System.out.println("\u001B[32m" + heroes[i].getName() + "\u001B[0m" +
                    " HP: " + heroes[i].getHealth()
                    + " [" + heroes[i].getDamage() + "]");
        }
        System.out.println("\n____________________________");
    }
}
