package katas.clopez;

public class BuyCar {
    // eliminamos la palabra reservada static
    // declaramos un atributo privado en
    public int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        // traemos los datos del enunciado
        double AutoViejo = startPriceOld;
        double AutoNuevo = startPriceNew;
        double porcentaje = percentLossByMonth;
        double resultado;
        int cantMeses = 0;
        resultado = AutoViejo - AutoNuevo;
        if (resultado < 0) {
            do {
                cantMeses++;
                if ((cantMeses % 2) == 0) {
                    porcentaje = porcentaje + 0.5;
                }
                AutoViejo = AutoViejo - ((AutoViejo * porcentaje) / 100);
                AutoNuevo = AutoNuevo - ((AutoNuevo * porcentaje) / 100);
                resultado = AutoViejo - AutoNuevo + (savingperMonth * cantMeses);
            } while (resultado < 0);
        }
        // convertimos de double a int
        int monto = (int) Math.round(resultado);
        // arreglo de respuesta
        int[] respuesta = new int[] { cantMeses, monto };
        return respuesta;
    }
}
