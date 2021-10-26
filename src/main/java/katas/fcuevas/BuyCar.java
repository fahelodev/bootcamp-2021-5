package katas.fcuevas;

public class BuyCar {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        double ahorros = 0;
        double precioAutoNuevo = startPriceNew;
        double precioAutoViejo = startPriceOld;
        int cantidadMeses = 0;
        while ((ahorros + precioAutoViejo)<precioAutoNuevo){
            cantidadMeses=cantidadMeses+1;
            if (cantidadMeses%2==0){
                percentLossByMonth=percentLossByMonth+ 0.5;
            }
            precioAutoNuevo= precioAutoNuevo- precioAutoNuevo * (percentLossByMonth/100);
            precioAutoViejo= precioAutoViejo- precioAutoViejo * (percentLossByMonth/100);
            ahorros= ahorros + savingperMonth;
        }
        double dineroRestante= (precioAutoViejo+ahorros)- precioAutoNuevo;
        int [] resultado = new int [] {cantidadMeses,(int)Math.round (dineroRestante)};

        return resultado;

    }
}
