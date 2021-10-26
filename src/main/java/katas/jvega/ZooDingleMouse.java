package katas.jvega;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZooDingleMouse {

    public  String[] whoEatsWho(final String zoo) {
        String  []animales = zoo.split(",");  //paso los animales a un array de tipo string
        List<String> lista= new ArrayList<String>();  // utilizo una lista de string para poder ir Modificando los animales
        String animalComido;
        String []animalCome = null;
        Boolean muerteIzquierda= false;
        Boolean muerteDerecha= false;
        ArrayList<String> resultado= new ArrayList<>();  //para retornar el resultado final

        resultado.add(zoo);

        //agregamos los animales a la lista
        for(int i=0; i< animales.length;i++)
            lista.add(i, animales[i]);

        //utilizo hasmap para relacionar cada animal con el que puede comer (cada llave con su valor)
        HashMap <String, String []>listaAlimenticia;
        listaAlimenticia = new HashMap<>();
        listaAlimenticia.put("chicken", new String[]{"bug"});
        listaAlimenticia.put("fox", new String[]{"chicken","sheep"});
        listaAlimenticia.put("sheep", new String[]{"grass"});

//        con el do while  ire comparando y comiendo hasta que llegue a un elemento la lista
        int i=0;
        do{
            if(listaAlimenticia.get(lista.get(i))!=null){ //el animal come a alguien

                animalCome = listaAlimenticia.get(lista.get(i)); //paso a un array todos los animales que come

                // Animal come a la izquierda
                if(i!=0 &&  lista.size()>1){
                    for(int j=0; j< animalCome.length;j++)
                    {
                        if(lista.get(i-1).equals(animalCome[j])) //corroboro que coma al de la izquierda
                        {
                            animalComido=lista.get(i-1);
                            resultado.add(lista.get(i)+ " eats " +animalComido);
                            lista.remove(i-1);
                            muerteIzquierda=true;
                        }
                    }
                }

//                //Animal come a la derecha
                if(lista.size()>1 && muerteIzquierda==false){
                    for(int j=0; j< animalCome.length;j++)
                    {
                        if(lista.get(i+1).equals(animalCome[j])) //corroboro que coma el de la derecha
                        {
                            animalComido=lista.get(i+1);
                            resultado.add(lista.get(i)+ " eats " +animalComido);
                            lista.remove(i+1);
                            muerteDerecha=true;
                        }
                    }
                }
            }
            //si hubo animal muerto, hay que reiniciar la lista, por lo tanto recorremos desde la posicion 0
            if(muerteIzquierda==true || muerteDerecha==true)
                i=0;
            else
                i++;


            //seteo las muerte a falso para volver a recorrer
            muerteDerecha=false;
            muerteIzquierda= false;
        }while(lista.size()!=1);
        resultado.add(lista.get(0));

        return resultado.toArray( new String[0]);
    }
}
