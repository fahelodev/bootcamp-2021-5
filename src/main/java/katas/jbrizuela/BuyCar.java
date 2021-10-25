package katas.jbrizuela;

public class BuyCar {
    public int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {

        int meses = 0;
        double ahorro = 0;
        double dinerogastado = 0;
        double priceOld = startPriceOld;
        double priceNew = startPriceNew;

        while(priceOld + ahorro < priceNew) {

            meses++;

            if (meses % 2 == 0) {
                percentLossByMonth = percentLossByMonth + 0.5;
            }
            priceOld = priceOld - priceOld * (percentLossByMonth / 100);
            priceNew = priceNew - priceNew * (percentLossByMonth / 100);
            ahorro = ahorro + savingperMonth;
        }

        dinerogastado = (ahorro + priceOld) - priceNew;

        return new int[]{meses, (int) Math.round(dinerogastado)};
    }

}
