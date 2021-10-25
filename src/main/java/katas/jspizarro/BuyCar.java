package katas.jspizarro;

public class BuyCar {
    public int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        int mes=0;
        double precioViejo = startPriceOld;
        double precioNuevo = startPriceNew;
        double porcentajePerdidaxMes = percentLossByMonth;
        double dineroFaltante = 0;
        double ahorro = 0;

        while ((precioViejo+ahorro)<precioNuevo){
            mes += 1;
            if (esPar(mes)){
                porcentajePerdidaxMes += (0.5);
            }
                precioViejo -= precioViejo * (porcentajePerdidaxMes / 100);
                precioNuevo -= precioNuevo * (porcentajePerdidaxMes / 100);
                ahorro += savingperMonth;
        }
        dineroFaltante = (ahorro+precioViejo)-precioNuevo;

        return new int[]{mes,(int)Math.round(dineroFaltante)};
    }

    public static boolean esPar(int numero){
        return numero % 2 == 0;
    }

}
