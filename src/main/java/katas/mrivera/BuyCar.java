package katas.mrivera;

public class BuyCar {
    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {

        double precioAutoViejo = startPriceOld;
        double precioAutoNuevo = startPriceNew;
        double porcentajeDePérdidaDeValorPorMes = percentLossByMonth;
        int ahorroPorMes = savingperMonth;
        int meses = 0;

        while((ahorroPorMes * meses) + precioAutoViejo - precioAutoNuevo < 0){
            meses += 1;
            if(esPar(meses)){
                porcentajeDePérdidaDeValorPorMes+= 0.5;
            }
            precioAutoViejo -= precioAutoViejo * (porcentajeDePérdidaDeValorPorMes / 100);
            precioAutoNuevo -= precioAutoNuevo * (porcentajeDePérdidaDeValorPorMes / 100);
        }

        int restante = (int)Math.round((ahorroPorMes * meses) + precioAutoViejo - precioAutoNuevo);

        int[] valoresDeRetorno = {meses, restante};

        return valoresDeRetorno;
    }

    public static boolean esPar(int numero) {
        if (numero % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
