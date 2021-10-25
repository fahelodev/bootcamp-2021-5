package katas.bfuentes;
public class BuyCar {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        int[] arr = new int[2];
        if (startPriceOld > startPriceNew){
            arr[0] = 0;
            arr[1] = startPriceOld - startPriceNew;
            System.out.println("meses " +arr[0]);
            System.out.println("ahorro " +arr[1]);
            return arr;
        }
        else {
            int montoAhorrado = 0;
            int meses = 0;
            double percentLossByTwoMonth = 0;
            double startPriceNewDecimal = startPriceNew;
            double startPriceOldDecimal = startPriceOld;
            double costoTotal = 0;
            double porcentajeMensual = 0;

            do{
                meses++;
                if (meses%2==0){
                    percentLossByTwoMonth+= 0.5;
                }
                porcentajeMensual = (100-(percentLossByMonth+percentLossByTwoMonth))/100;
                startPriceOldDecimal = startPriceOldDecimal*porcentajeMensual;
                startPriceNewDecimal = startPriceNewDecimal*porcentajeMensual;
                costoTotal = startPriceNewDecimal - startPriceOldDecimal;
                montoAhorrado+=savingperMonth;
                System.out.println("end month "+meses +
                        ": percentLoss " + (percentLossByMonth+percentLossByTwoMonth) +
                        " available " + (montoAhorrado-costoTotal));
            }
            while(montoAhorrado < costoTotal);
            arr[0] = meses;
            int ahorradoNetoEntero = (int) Math.floor(montoAhorrado-costoTotal);
            arr[1] = ahorradoNetoEntero;
            System.out.println("Meses " +arr[0]);
            System.out.println("Ahorro " +arr[1]);
            return arr;
        }
    }

}