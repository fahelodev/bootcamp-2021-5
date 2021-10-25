package katas.mrivera;

class Fighter {
    public String name;
    public int health, damagePerAttack;
    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }
}

public class TwoFightersOneWinner {

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

        Fighter atacante;
        Fighter defensor;

        //Selecciona al defensor y al atacante
        if (fighter1.name == firstAttacker) {
            atacante = fighter1;
            defensor = fighter2;
        } else {
            atacante = fighter2;
            defensor = fighter1;
        }

        while (fighter1.health > 0 && fighter2.health > 0) {
            defensor.health -= atacante.damagePerAttack;
            //intercambia puestos
            Fighter temp = atacante;
            atacante = defensor;
            defensor = temp;
        }

        //retorna al campeón
        if (fighter1.health > fighter2.health) {
            return fighter1.name;
        } else {
            return fighter2.name;
        }
    }
}
