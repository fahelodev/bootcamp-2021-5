package katas.jvega;



public class ReverseWord {


public  String wordReverse(final String original){
    String palabraFinal="";

    if(original.contains(" ")) { //caso  que contenga espacios
        String [] arregloPalabras= original.split("\\s"); //le paso el string separado pro espacio

        if(arregloPalabras.length==0)
            return original;

        for (int i=0; i< arregloPalabras.length;i++){
            StringBuilder entrada = new StringBuilder(arregloPalabras[i]);
            palabraFinal +=entrada.reverse().toString()+" ";  //voy acumuluando palabras invertidas y agrego un espacio
                  }

    }else{ //no contiene espacios
        StringBuilder entrada= new StringBuilder(original);
        palabraFinal=entrada.reverse().toString();
    }

    return palabraFinal.trim(); //Trim permite sacar los espacios de los extremos


}

 }



