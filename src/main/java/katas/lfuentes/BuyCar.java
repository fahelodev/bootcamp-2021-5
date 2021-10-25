package katas;

public class BuyCar {
    public static final double LOSS_PERCENT_INCREASE = 0.5;

    public int[] nbMonths(int startPriceOld, int startPriceNew, int savingPerMonth, double percentLossByMonth) {
        int months = 0;
        double moneyLeft = 0;
        double priceOld = startPriceOld;
        double priceNew = startPriceNew;
        double savings = 0;

        while ((priceOld + savings) < priceNew) {
            months++;
            if (months % 2 == 0) {
                percentLossByMonth = percentLossByMonth + LOSS_PERCENT_INCREASE;
            }
            priceOld = priceOld - priceOld * (percentLossByMonth / 100);
            priceNew = priceNew - priceNew * (percentLossByMonth / 100);
            savings = savings + savingPerMonth;
        }
        moneyLeft = (savings + priceOld) - priceNew;

        return new int[]{months, (int) Math.round(moneyLeft)};
    }
}
