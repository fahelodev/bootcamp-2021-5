package katas.rolguin;

public class CalcularMes {

    public int []  CalcularCompra(int precioAutoAntiguo,int precioAutoNuevo, int ahorroPorMes,double descuentoPorMes){

        //si el precio del auto antiguo es mayor o igual al auto nuevo se el resultado retornado es 0
        if (precioAutoAntiguo>=precioAutoNuevo){
            return new int[]{0 ,precioAutoAntiguo-precioAutoNuevo};
        }
        int meses=0;
        int ahorroTotal=0;
        int dineroRestante=0;

//si la suma del ahorrototal mas el precioautoantiguao es menor al precioautonuevo
        while ((ahorroTotal+precioAutoAntiguo)<precioAutoNuevo){
            meses++;
            if (meses % 2 == 0){
                descuentoPorMes+=0.5;
            }
            ahorroTotal+= ahorroPorMes;
            precioAutoAntiguo-= precioAutoAntiguo * (descuentoPorMes / 100);
            precioAutoNuevo -= precioAutoNuevo * (descuentoPorMes / 100);
            dineroRestante = ((ahorroTotal+precioAutoAntiguo)-precioAutoNuevo);
        }
        return  new int[]{meses , Math.round(dineroRestante)};
    }
}
