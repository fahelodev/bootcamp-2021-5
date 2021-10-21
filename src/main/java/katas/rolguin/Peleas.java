package katas.rolguin;

public class Peleas {

    public static class Peleador {
        public String Nombre;
        public int Vida, DañoPorAtaque;

        public Peleador(String nombre, int vida, int dañoPorAtaque) {
            this.Nombre = nombre;
            this.Vida = vida;
            this.DañoPorAtaque = dañoPorAtaque;
        }
    }
    public static String ElegirGanador(Peleador peleador1,Peleador peleador2,String primerAtaque){
        String ganador;
        if (primerAtaque.equals(peleador1.Nombre)){
            while (true){
                peleador2.Vida -= peleador1.DañoPorAtaque;
                if (peleador2.Vida<=0){
                    ganador=peleador1.Nombre;
                    break;
                }
                peleador1.Vida-=peleador2.DañoPorAtaque;
                if(peleador1.Vida<=0){
                    ganador=peleador2.Nombre;
                    break;
                }
            }
        }else{
            while(true){
                peleador1.Vida-=peleador2.DañoPorAtaque;
                if(peleador1.Vida<=0){
                    ganador=peleador2.Nombre;
                    break;
                }
                peleador2.Vida-=peleador1.DañoPorAtaque;
                if(peleador2.Vida<=0){
                    ganador=peleador1.Nombre;
                    break;
                }
            }
        }
        return ganador;

    }
}
