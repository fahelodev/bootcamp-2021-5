package katas.fcuevas;

public class declareWinner {

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter primerAtacante = new Fighter ("",100,5);
        Fighter segundoAtacante = new Fighter ("",100, 5);


        if (fighter1.name == firstAttacker){
            primerAtacante=fighter1;
            segundoAtacante=fighter2;
        }
        if (fighter2.name ==firstAttacker){
            primerAtacante=fighter2;
            segundoAtacante=fighter1;
        }

        while (primerAtacante.health>0 && segundoAtacante.health>0){
            segundoAtacante.health = segundoAtacante.health - primerAtacante.damagePerAttack;

            if (segundoAtacante.health<=0){
                return primerAtacante.name;
            }
            primerAtacante.health= primerAtacante.health - segundoAtacante.damagePerAttack;
            if (primerAtacante.health<=0){
                return segundoAtacante.name;
            }
        }
        return "";
    }

}