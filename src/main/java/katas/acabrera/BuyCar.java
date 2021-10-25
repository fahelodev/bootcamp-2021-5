package katas.acabrera;

public class BuyCar {

    //declaramos las variables

    private double total;
    private int mes;

    //creamos el metodo

    public BuyCar(){


    }

    public int[] nbMonths(double startPriceOld, double startPriceNew, int savingperMonth, double percentLossByMonth){

        double ahorroSuficiente;
        while (true) {
            //verificamos si puede comprar un auto nuevo
            if (startPriceOld + total >= startPriceNew) {
                ahorroSuficiente = startPriceOld + total - startPriceNew;
                break;
            }
            mes++;

            // porcentaje perdida cada 2 meses
            if (mes%2 == 0) {
                percentLossByMonth = percentLossByMonth + 0.5;
            }
            startPriceOld = startPriceOld * (1-percentLossByMonth/100);
            startPriceNew = startPriceNew * (1-percentLossByMonth/100);
            total += savingperMonth;

        }

        int[] resultado = new int[2];
        resultado[0] = mes;
        resultado[1] = (int)Math.round(ahorroSuficiente);
        return resultado;

    }
}
