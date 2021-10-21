package katas.maraya;

public class TwoFightersOneWinner {

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
       //mientras  la salud del pelear uno y 2 sea Mayor a 0 se le resta el ataque del peleador contrario
        while (fighter1.health >0 && fighter2.health>0){
            fighter2.health -= fighter1.damagePerAttack;
            fighter1.health -= fighter2.damagePerAttack;
        }
        if (fighter1.health <=0 && fighter2.health  <=0){
            return firstAttacker;


        }else if(fighter1.health <=0 ){
            return fighter2.name;

        }else{
            return fighter1.name;

        }
    }
    // creae clase estatica para obtener atributos del peleador (observacion separar clases y usar get a set para el codigo)
    public static class Fighter {
        public String name;
        public int health, damagePerAttack;
        public Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }
    }

}
