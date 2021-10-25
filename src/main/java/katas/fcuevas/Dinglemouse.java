package katas.fcuevas;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class Dinglemouse {

    public static String[] whoEatsWho(final String zoo) {

        HashMap<String, String[]> dietaDeAnimales = new HashMap<String, String[]>();
        dietaDeAnimales.put("antelope", new String []{"grass"});
        dietaDeAnimales.put("big-fish", new String []{"little-fish"});
        dietaDeAnimales.put("bug", new String []{"leaves"});
        dietaDeAnimales.put("bear", new String []{"big-fish","bug","chicken","cow","leaves","sheep"});
        dietaDeAnimales.put("chicken", new String []{"bug"});
        dietaDeAnimales.put("cow", new String []{"grass"});
        dietaDeAnimales.put("fox", new String []{"chicken","sheep"});
        dietaDeAnimales.put("giraffe", new String []{"leaves"});
        dietaDeAnimales.put("lion", new String []{"antelope","cow"});
        dietaDeAnimales.put("panda", new String []{"leaves"});
        dietaDeAnimales.put("sheep", new String []{"grass"});

        ArrayList <String> salida= new ArrayList <String>();
        salida.add(zoo);

        ArrayList <String> lista = new ArrayList (Arrays.asList(zoo.split(",")));
        boolean sePuedenComer = true;
        while (sePuedenComer==true){
            sePuedenComer = false;
            for(int i=0;i<lista.size();i++){
                String item = lista.get(i);
                if ((i-1)>=0 && dietaDeAnimales.get(item)!= null ){
                    String izquierda = lista.get(i-1);
                    ArrayList <String> dieta = new ArrayList <String>(Arrays.asList(dietaDeAnimales.get(item)));
                    if(dieta.contains(izquierda) == true){
                        salida.add(item +" eats "+ izquierda);
                        lista.remove(i-1);
                        sePuedenComer=true;
                        break;
                    }
                }
                if ((i+1)<lista.size() && dietaDeAnimales.get(item)!= null){
                    String derecha = lista.get(i+1);
                    ArrayList <String> dieta = new ArrayList <String>(Arrays.asList(dietaDeAnimales.get(item)));
                    if (dieta.contains(derecha) == true){
                        salida.add(item +" eats "+ derecha);
                        lista.remove(i+1);
                        sePuedenComer=true;
                        break;
                    }

                }
            }
        }

        String sobreVivientes = "";
        for(int i=0;i<lista.size();i++){
            if ((i-1)>=0){
                sobreVivientes=sobreVivientes + ",";
            }
            sobreVivientes = sobreVivientes + lista.get(i);
        }
        salida.add(sobreVivientes);

        String[] resultado = new String[salida.size()];
        resultado = salida.toArray(resultado);
        return resultado;

        //return new String[]{zoo, zoo};
    }

}


