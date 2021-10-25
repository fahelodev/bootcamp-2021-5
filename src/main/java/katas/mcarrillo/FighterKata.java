package katas.mcarrillo;

import java.util.Objects;

public class FighterKata {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        boolean PrimerAtaque = Objects.equals(fighter1.name, firstAttacker);
        while (true){
            if (PrimerAtaque){
                fighter2.health = fighter2.health - fighter1.damagePerAttack;
                if (fighter2.health <= 0)
                    return fighter1.name;
        }else{
                    fighter1.health = fighter1.health- fighter2.damagePerAttack;
                    if (fighter1.health <= 0)
                        return fighter2.name;
    }
                    PrimerAtaque=!PrimerAtaque;
}
}
}
