package katas.foliva;

public class BuyCar {
    public int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        double  money = startPriceOld,
                currentPriceOld = startPriceOld,
                currentPriceNew = startPriceNew,
                percentLoss = percentLossByMonth/100;
        int months = 0;

        if(startPriceOld == startPriceNew){
            int[] resultSamePrice = {0,0};
            return resultSamePrice;
        }

        while (money <= currentPriceNew){
            months++;
            percentLoss = months%2 == 0?  percentLoss + 0.005 : percentLoss ;
            currentPriceNew -= (currentPriceNew * percentLoss);
            currentPriceOld -=  (currentPriceOld * percentLoss);
            money = currentPriceOld  + (savingperMonth * months);
        }

        int rest = (int) Math.round(money - currentPriceNew);
        int[] result = {months, rest};

        return result;
    }
}
