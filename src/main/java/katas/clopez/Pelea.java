package katas.clopez;

public class Pelea {
    public static String declararGanador(Fighter fighter1, Fighter fighter2, String firstAttacker){
        //1.- quien golpea primero?
        //2.- revisar estatus de salud
        //3.- restar salud
        //4.- salud <=0, pierde
        //5.- declarar ganador
        String Nombre1 = new String(fighter1.name);
        String Nombre2 = new String(fighter2.name);
        int HP1 = fighter1.health;
        int HP2 = fighter2.health;
        int Atk1 = fighter1.damagePerAttack;
        int Atk2 = fighter2.damagePerAttack;
        StringBuilder Ganador = new StringBuilder();
        if (firstAttacker.equals(Nombre1)){
            do {
                HP2 = HP2 - Atk1;
                if (HP2 > 0){
                    HP1 = HP1 - Atk2;
                    if (HP1 <= 0){
                        Ganador.append(Nombre2);
                    }
                }
                else{
                    Ganador.append(Nombre1);
                }
            }while (HP1 > 0 && HP2 > 0);
        }
        else{
            do {
                HP1 = HP1 - Atk2;
                if (HP1 > 0){
                    HP2 = HP2 - Atk1;
                    if (HP2 <= 0){
                        Ganador.append(Nombre1);
                    }
                }
                else{
                    Ganador.append(Nombre2);
                }
            } while (HP1 > 0 && HP2 > 0);
        }
        return Ganador.toString();
    }
}
