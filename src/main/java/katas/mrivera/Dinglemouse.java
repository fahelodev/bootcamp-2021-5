package katas.mrivera;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dinglemouse {

    public String[] whoEatsWho(final String zoo) {
        ArrayList<Animal> animales = new ArrayList<Animal>();

        //Log resultado para registrar los sucesos
        List<String> sucesos = new ArrayList<String>();

        //Registra los animales iniciales
        sucesos.add(zoo);

        //Instancia los animales
        for ( String animal: zoo.split("[,]")) {
            animales.add(new Animal(animal));
        }

        boolean hayPresas = true;

        while(hayPresas){
            hayPresas = false;
            for(int i = 0; i < animales.size(); i++){

                //Animales
                Animal animal = animales.get(i);
                Animal animalIzq = null;
                Animal animalDer = null;

                //Compara limites del array
                if(i > 0){
                    animalIzq = animales.get(i - 1);
                }
                if(i < animales.size() - 1){
                    animalDer = animales.get(i + 1);
                }

                //Se come al animal de la izquierda y registra en en log
                if(animalIzq != null && animal.sePuedeComerA(animalIzq)){
                    String suceso = animal.comer(animalIzq);
                    sucesos.add(suceso);
                    animales.remove(animalIzq);
                    hayPresas = true;

                    break;
                }

                //Se come al animal de la derecha y registra en en log
                if(animalDer != null && animal.sePuedeComerA(animalDer)){
                    String suceso = animal.comer(animalDer);
                    sucesos.add(suceso);
                    animales.remove(animalDer);
                    hayPresas = true;

                    break;
                }
            }
        }

        //Animales restantes
        String zooResto = "";
        for(int i = 0; i < animales.size(); i++){
            zooResto += animales.get(i).getNombre();

            if(animales.size() > 1 && i < animales.size() - 1){
                zooResto += ",";
            }
        }

        //Registra los animales restantes
        sucesos.add(zooResto);

        return sucesos.toArray(new String[sucesos.size()]);
    }

    private void verificarLimite(Animal animal, int indice){

    }
}

class Animal {
    private String nombre;
    private List<String> presas;

    public Animal(String nombre){
        this.nombre = nombre;
        this.presas = Arrays.asList(asignarPresas(nombre));
    }

    public String getNombre() {
        return nombre;
    }

    public boolean sePuedeComerA(Animal presa){
        return presas.contains(presa.getNombre());
    }

    public String comer(Animal presa){
        return  this.nombre + " eats " + presa.getNombre();
    }


    private String [] asignarPresas(String animal){

        String presas;

        switch(animal) {
            case "antelope":
                presas = "grass";
                break;
            case "big-fish":
                presas = "little-fish";
                break;
            case "bug":
                presas = "leaves";
                break;
            case "bear":
                presas = "bug;chicken;cow;leaves;sheep;big-fish";
                break;
            case "chicken":
                presas = "bug";
                break;
            case "cow":
                presas = "grass";
                break;
            case "fox":
                presas = "chicken;sheep";
                break;
            case "giraffe":
                presas = "leaves";
                break;
            case "lion":
                presas = "antelope;cow";
                break;
            case "panda":
                presas = "leaves";
                break;
            case "sheep":
                presas = "grass";
                break;
            default:
                presas = "";
        }

        return presas.split("[;]");

    }
}
