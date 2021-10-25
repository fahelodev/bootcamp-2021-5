package katas.jbrizuela;

import org.jetbrains.annotations.NotNull;

public class declareWinner {
    public String declareWinner(Fighter fighter1, @NotNull Fighter fighter2, @NotNull String firstAttacker) {

        if (firstAttacker.equals(fighter2.name)) {

            while (fighter1.health > 0 && fighter2.health > 0) {
                fighter1.health = fighter1.health - fighter2.damagePerAttack;
                if (fighter1.health <= 0) {
                    return fighter2.name;
                }

                fighter2.health = fighter2.health - fighter1.damagePerAttack;
                if (fighter2.health <= 0){
                    return fighter1.name;
                }
            }

        } else {
            while (fighter1.health > 0 && fighter2.health > 0) {
                fighter2.health = fighter2.health - fighter1.damagePerAttack;
                if (fighter2.health <= 0){
                    return fighter1.name;
                }
                fighter1.health = fighter1.health - fighter2.damagePerAttack;
                if (fighter1.health <= 0) {
                    return fighter2.name;
                }
            }
        }
        return "";
    }

}
