package katas.jvega;

public class BuyCar {

    public  int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        int [] mesCompra;
        int mes = 0;
        double ahorro = 0;
        double sobrante = 0;
        double precioViejo = startPriceOld;   //les paso los precios a una variable tipo double
        double precioNuevo = startPriceNew;

        while (precioViejo + ahorro < precioNuevo) { //pregunto si el $ del auto nuevo es mayor q los ahorros mas el auto viejo
            mes++;
            if (mes % 2 == 0) //cada dos meses le agrego un 0.5
                percentLossByMonth += 0.5;

            precioViejo-=precioViejo * (percentLossByMonth / 100); //disminuye sus respectivos porcentajes
            precioNuevo-=precioNuevo * (percentLossByMonth / 100);
            ahorro+=savingperMonth; //cada mes ingremento el ahorro en mil

        }
        sobrante = (ahorro + precioViejo)- precioNuevo; //la $ q me sobra a cabo de los meses


        return mesCompra= new int[]{mes, (int) Math.round(sobrante)};
    }
}
