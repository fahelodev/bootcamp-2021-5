package katas.bfuentes;

public class Kata {
    private static boolean primerAtaque = false;

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        // Your code goes here. Have fun!

        boolean firstFighter1 = false;
        boolean firstFighter2 = false;

        String nombre1 = fighter1.name;
        String nombre2 = fighter2.name;

        System.out.println(nombre1);
        System.out.println(nombre2);

        do {
            if (firstAttacker.equals(fighter1.name) && !firstFighter1) {
                fighter2.health = fighter2.health - fighter1.damagePerAttack;
                firstFighter1 = true;
                firstFighter2 = false;
            } else {
                if (firstAttacker.equals(fighter2.name) && !firstFighter2) {
                    fighter1.health = fighter1.health - fighter2.damagePerAttack;
                    firstFighter2 = true;
                    firstFighter1 = false;
                } else {
                    if (firstFighter2) {
                        fighter2.health = fighter2.health - fighter1.damagePerAttack;
                        firstFighter1 = true;
                        firstFighter2 = false;
                    } else {
                        fighter1.health = fighter1.health - fighter2.damagePerAttack;
                        firstFighter2 = true;
                        firstFighter1 = false;
                    }
                }

            }

        }

        while (fighter1.health > 0 && fighter2.health > 0);

        if (fighter1.health > 0) {
            return fighter1.name;
        } else {
            return fighter2.name;
        }
    }
}



