package katas.maraya;

public class BuyCar {

    public  int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {

        int cont=0;
        int dinero=startPriceOld;

        for (int i=1; dinero<=startPriceNew; i++){
            if (i%2==0){
                percentLossByMonth += 0.5;

            }
            cont++;
            startPriceOld = (int) (startPriceOld - (startPriceOld*(percentLossByMonth/100)));

            startPriceNew = (int) (startPriceNew - ((startPriceNew*percentLossByMonth)/100));



            dinero= startPriceOld + (savingperMonth*cont);

        }

        return new int []{cont,Math.round(dinero-startPriceNew)};

    }
}
