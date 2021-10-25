package katas.foliva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ZooDisaster {
    private static final HashMap<String, String[]> foodChain;
    static {
        foodChain = new HashMap<String, String[]>();
        foodChain.put("antelope", new String[]{"grass"});
        foodChain.put("big-fish", new String[]{"little-fish"});
        foodChain.put("bear", new String[]{"big-fish","bug","chicken","cow","leaves","sheep"});
        foodChain.put("chicken", new String[]{"bug"});
        foodChain.put("fox", new String[]{"chicken","sheep"});
        foodChain.put("giraffe", new String[]{"leaves"});
        foodChain.put("lion", new String[]{"antelope","cow"});
        foodChain.put("panda", new String[]{"leaves"});
        foodChain.put("sheep", new String[]{"grass"});
    }

    public String[] whoEatsWho(final String zoo) {
        ArrayList<String> result = new ArrayList<>();
        String[] animals = zoo.split(",");
        boolean thereIsChange = true;
        String deadAnimal = null;

        while(thereIsChange){
            thereIsChange = false;

            if(deadAnimal != null){
                //sacar animal muerto
                ArrayList<String> newAnimals = new ArrayList<>();
                for (String animal: animals) {
                    if(animal != deadAnimal) newAnimals.add(animal);
                }
                //toArray devuelve el tipo basado en su argumento, se le pasa un String[] de 0 para que lo haga.
                animals = newAnimals.toArray(new String[0]);
            }

            for (int i = 0; i < animals.length ; i++) {
                String currentAnimal = animals[i], leftAnimal, rightAnimal;

                //currentAnimal can't eat any other animal
                if(foodChain.get(currentAnimal) == null){
                    continue;
                }
                //si queda un solo animal termino
                if(animals.length == 1){
                    break;
                }

                //no left
                if(i == 0){
                    rightAnimal = animals[i+1];
                    thereIsChange = Arrays.toString(foodChain.get(currentAnimal)).contains(rightAnimal);
                    if(thereIsChange){
                        result.add(currentAnimal + " eats " + rightAnimal);
                        deadAnimal = rightAnimal;
                        break;
                    }
                }//no right
                else if(i == animals.length - 1){
                    leftAnimal = animals[i-1];
                    thereIsChange = Arrays.toString(foodChain.get(currentAnimal)).contains(leftAnimal);
                    if(thereIsChange){
                        result.add(currentAnimal + " eats " + leftAnimal);
                        deadAnimal = leftAnimal;
                        break;
                    }
                }//default
                else{
                    leftAnimal = animals[i-1];
                    rightAnimal = animals[i+1];
                    thereIsChange = Arrays.toString(foodChain.get(currentAnimal)).contains(leftAnimal);
                    if(thereIsChange){
                        result.add(currentAnimal + " eats " + leftAnimal);
                        deadAnimal = leftAnimal;
                        break;
                    }
                    thereIsChange = Arrays.toString(foodChain.get(currentAnimal)).contains(rightAnimal);
                    if(thereIsChange){
                        result.add(currentAnimal + " eats " + rightAnimal);
                        deadAnimal = rightAnimal;
                        break;
                    }
                }
            }
        }
        ArrayList<String> finalResult = new ArrayList<>();
        finalResult.add(zoo);
        result.forEach( action -> finalResult.add(action));

        finalResult.add(String.join(",",animals));


        return finalResult.toArray(new String[0]);
    }
}
