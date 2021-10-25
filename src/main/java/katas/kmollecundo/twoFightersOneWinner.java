/*
Crea una función que devuelva el nombre del ganador en una pelea entre dos luchadores.

PreCondiciones :
1. La funcion debe devolver el nombre del ganador de una pelea de dos luchadores
    cuando la vida de alguno de los dos es menor o igual a 0.

Acciones:
1. DatoEntradaRetonarHarryVsLew
2. DatoEntradaRetornarLewVsHarry
3. DatoEntradaRetornarHaraldVsHarry
4. DatoEntradaRetornarHarryVsHarald
5. DatoEntradaRetornarHaraldVsJerry
6. DatoEntradaRetornarJerryVsHarald

PostCondiciones:
DATO -> ENTRADA -> SALIDA
 */

package katas.kmollecundo;

import java.util.Objects;

public class twoFightersOneWinner {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        // Uso metodo boolean para saber el primer atacante
    boolean primerTurno = Objects.equals(fighter1.name, firstAttacker);
    while (true) {
        if (primerTurno) {
            fighter2.health -= fighter1.damagePerAttack;
            if (fighter2.health <= 0)
                return fighter1.name;
        }else {
            fighter1.health -= fighter2.damagePerAttack;
            if (fighter1.health <= 0)
                return fighter2.name;
        }
        primerTurno=!primerTurno;
    }
    }
    }