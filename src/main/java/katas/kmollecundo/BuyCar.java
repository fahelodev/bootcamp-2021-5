/*
Un hombre tiene un coche bastante viejo que vale $ 2000. Vio un automóvil de segunda mano que valía $ 8000.
Quiere quedarse con su coche viejo hasta que pueda comprar uno de segunda mano.
Él cree que puede ahorrar $ 1000 cada mes, pero los precios de su automóvil viejo y del nuevo
disminuyen un 1.5 por ciento por mes. Además, este porcentaje de pérdida aumenta en un 0,5 por ciento
al final de cada dos meses. A nuestro hombre le resulta difícil hacer todos estos cálculos.
¿Cuántos meses le llevará ahorrar suficiente dinero para comprar el coche que quiere y cuánto dinero le sobrará?

NOTA
Si por casualidad desde el inicio, el valor del automóvil viejo es mayor que el valor del nuevo o igual,
no hay ningún ahorro que hacer, no es necesario esperar, por lo que puede comprar el coche nuevo a principios del mes.

PreCondiciones:
1. La funcion debe devolver el precio del automovil viejo y del nuevo al final de cada mes.
2. La Funcion debe devolver el precio del automovil viejo y del nuevo al final de cada dos meses.


Acciones:
1. DatoEntradaRetornarConAhorro
2. DatoEntradaRetornarSinAhorro

PostCondiciones:
1. La funcion debe devolver los meses que llevara ahorrar suficiente para comprar el coche
2. La Funcion debe devolver el dinero que sobrara

 */

package katas.kmollecundo;

public class BuyCar {
    public static final double lossPercentIncrease = 0.5;

    public int[] nbMonths(int startPriceOld, int startPriceNew, int savingPerMonth, double percentLossByMonth) {
        // inicializamos las variables
        int meses = 0;
        double dineroFaltante = 0;
        double precioViejo = startPriceOld;
        double precioNuevo = startPriceNew;
        double ahorros = 0;
        // ciclo while para cumplir las condiciones que se pidieron
        while ((precioViejo + ahorros) < precioNuevo){
            meses++;
            if (meses % 2 == 0){
                percentLossByMonth = percentLossByMonth + lossPercentIncrease;
            }
            precioViejo = precioViejo - precioViejo * (percentLossByMonth / 100);
            precioNuevo = precioNuevo - precioNuevo * (percentLossByMonth / 100);
            ahorros = ahorros + savingPerMonth;
        }
            dineroFaltante = (ahorros + precioViejo) - precioNuevo;

        return new int[]{meses,(int) Math.round(dineroFaltante)}; //utilizo mathround para redondear el numero en el arreglo
    }
}
