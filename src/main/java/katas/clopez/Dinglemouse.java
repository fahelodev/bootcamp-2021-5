package katas.clopez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dinglemouse {
    // inicializamos lista de depredadores y sus presas en listas
    private static final Map<String, Set<String>> depredadores = new HashMap<String, Set<String>>();

    static {
        // solo comen una cosa
        depredadores.put("antelope", Collections.singleton("grass"));
        depredadores.put("big-fish", Collections.singleton("little-fish"));
        depredadores.put("bug", Collections.singleton("leaves"));
        depredadores.put("giraffe", Collections.singleton("leaves"));
        depredadores.put("chicken", Collections.singleton("bug"));
        depredadores.put("cow", Collections.singleton("grass"));
        depredadores.put("panda", Collections.singleton("leaves"));
        depredadores.put("sheep", Collections.singleton("grass"));

        // comen mas de una cosa
        depredadores.put("fox", new HashSet<String>(Arrays.asList("chicken", "sheep")));
        depredadores.put("lion", new HashSet<String>(Arrays.asList("antelope", "cow")));
        depredadores.put("bear", new HashSet<String>(Arrays.asList("big-fish", "bug", "chicken", "cow", "leaves", "sheep")));
    }

    public static String[] whoEatsWho(final String zoo) {
        // lista de quien come a quien
        final List<String> quien = new LinkedList<String>();
        // lista de seres vivos que hay en el zoologico
        final List<String> zoologico = new ArrayList<String>(Arrays.asList(zoo.split(",")));

        //no se revisa si esta vacio
        while (oneRound(quien, zoologico)) {
        }

        List<String> result = new LinkedList<String>();
        result.add(zoo);
        result.addAll(quien);
        result.add(String.join(",", zoologico));
        return result.toArray(new String[0]);
    }

    private static boolean oneRound(List<String> whoAteWhom, List<String> things) {
        for (int i = 0; i < things.size(); i++) {
            if (canEatLeft(things, i)) {
                eatLeft(whoAteWhom, things, i);
                return true;
            } else if (canEatRight(things, i)) {
                eatRight(whoAteWhom, things, i);
                return true;
            }
        }
        return false;
    }

    private static void eatRight(List<String> whoAteWhom, List<String> things, int i) {
        eat(whoAteWhom, things, i, i + 1);
    }

    private static void eatLeft(List<String> whoAteWhom, List<String> things, int i) {
        eat(whoAteWhom, things, i, i - 1);
    }

    private static void eat(List<String> whoAteWhom, List<String> things, int who, int whom) {
        whoAteWhom.add(String.format("%s eats %s", things.get(who), things.get(whom)));
        things.remove(whom);
    }

    private static boolean canEatRight(List<String> things, int i) {
        final Set<String> lunches = depredadores.get(things.get(i));
        return i < things.size() - 1 && lunches != null && lunches.contains(things.get(i + 1));
    }

    private static boolean canEatLeft(List<String> things, int i) {
        final Set<String> lunches = depredadores.get(things.get(i));
        return i > 0 && lunches != null && lunches.contains(things.get(i - 1));
    }
}