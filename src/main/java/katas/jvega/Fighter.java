package katas.jvega;

public class Fighter {
    //atributos
    public String name;
    public int health, damagePerAttack;

    public Fighter(){
    }
    //constructor
    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }
    public Boolean  ataque(Fighter atacado){  //funcion  que describe un ataque
        Boolean muerte= false;
        atacado.health -= this.damagePerAttack;
        if(atacado.health <=0)
            muerte=true;

        return muerte;
    }

    public  String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        String ganador="";
        Boolean muere;
        Fighter primerPeleador;
        Fighter segundoPeleador;

        if(firstAttacker==fighter1.name) {  //si el primero que ataca es el peleador1
            primerPeleador=fighter1 ;
            segundoPeleador=fighter2;
        }
        else{ //en caso contrario
            primerPeleador=fighter2;
            segundoPeleador=fighter1 ;
        }
        do {
            muere = primerPeleador.ataque(segundoPeleador); //ataca el primerpeleador
            if (muere == true)   //preguno si mato al segundo paleador
                ganador = primerPeleador.name;
            else {
                muere = segundoPeleador.ataque(primerPeleador); //ataca el segundopeleador
                if (muere == true)  //pregunto si mato al adversario
                    ganador = segundoPeleador.name;
            }
        }while(muere==false);  //van a pelear hasta que alguno muera

        return ganador;
    }


}
