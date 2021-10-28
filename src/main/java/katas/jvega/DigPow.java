package katas.jvega;

public class DigPow {

    public  long digPow(int n, int p) {
        int k, cantidadDigitos;
        int numero, acumulador=0;

        String numeroAuxiliar = String.valueOf(n);

        String []digitos= numeroAuxiliar.split("(?<=.)"); // divido mi numero en digitos
        cantidadDigitos= digitos.length; // obtengo la cantidad de digitos

        for (int i=0; i<cantidadDigitos;i++) {
           numero= Integer.parseInt((digitos[i]));
           acumulador += Math.pow(numero,p+i);  // realizo la sumatoria con la potencia
           numero=0; //lo vuevlo a cero al numero
        }
        numero=acumulador;

        k= (numero/n); //obtengo el valor de k


         if(n*k==numero)
            return k;
            else
          return -1;

    }

}
