package katas.landres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZooDingleMouse {

    public  String [] whoEatsWho(final String zoo){

        String []animalsAll=zoo.split(",");  //utiliza  un arreglo de string para guardar la listP de animales
        List<String> listP= new ArrayList<String>(); //listP para poder pushear los animales
        String animalDeath;
        String []Whateat= null;
        Boolean deathright= false;
        Boolean deathleft=false;
        ArrayList<String>result=new ArrayList<>();

        result.add(zoo);// Variable para guardar el result final

        for (int i = 0; i <animalsAll.length ; i++)
            listP.add(i, animalsAll[i]);

        HashMap<String, String[]>dietAliment;
        dietAliment= new HashMap<>();
        dietAliment.put("antelope", new String []{"grass"});
        dietAliment.put("big-fish", new String []{"little-fish"});
        dietAliment.put("bug", new String []{"leaves"});
        dietAliment.put("bear", new String []{"big-fish","bug","chicken","cow","leaves","sheep"});
        dietAliment.put("chicken", new String []{"bug"});
        dietAliment.put("cow", new String []{"grass"});
        dietAliment.put("fox", new String []{"chicken","sheep"});
        dietAliment.put("giraffe", new String []{"leaves"});
        dietAliment.put("lion", new String []{"antelope","cow"});
        dietAliment.put("panda", new String []{"leaves"});
        dietAliment.put("sheep", new String []{"grass"});

        int i=0;
        do{
            if(dietAliment.get(listP.get(i))!=null){
                Whateat = dietAliment.get(listP.get(i));

                if(i!=0 &&  listP.size()>1){//como a la izq
                    for(int j=0; j< Whateat.length;j++)
                    {
                        if(listP.get(i-1).equals(Whateat[j]))
                        {
                            animalDeath=listP.get(i-1);
                            result.add(listP.get(i)+ " eats " +animalDeath);
                            listP.remove(i-1);
                            deathleft=true;
                        }
                    }
                }

                if(listP.size()>1 && deathleft==false){
                    for(int j=0; j< Whateat.length;j++)
                    {
                        if(listP.get(i+1).equals(Whateat[j]))
                        {
                            animalDeath=listP.get(i+1);
                            result.add(listP.get(i)+ " eats " +animalDeath);
                            listP.remove(i+1);
                            deathright=true;
                        }
                    }
                }
            }
            if(deathleft==true || deathright==true) // si hay un animal muerto hay que reiniciar la lista y volvemos desde la posicion 0
                i=0;
            else
                i++;

            deathright=false;
            deathleft= false;
        }while(listP.size()!=1);
        result.add(listP.get(0));

        return result.toArray( new String[0]);
    }
}

