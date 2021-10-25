package katas.jspizarro;

public class DeclareWinner {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

        String winner = "";
        String attacker = firstAttacker;

        while (fighter1.getHealth()>=0 && fighter2.getHealth()>=0){
            if (fighter1.getName()==attacker) {
                fighter2.setHealth(fighter2.getHealth() - fighter1.getDamagePerAttack());
                attacker = fighter2.getName();
            }
            else {
                fighter1.setHealth(fighter1.getHealth() - fighter2.getDamagePerAttack());
                attacker = fighter1.getName();
            }
        }
        if (fighter1.getHealth()<=0)
            winner = fighter2.getName();
        else
            winner = fighter1.getName();


       return winner;
    }

}
