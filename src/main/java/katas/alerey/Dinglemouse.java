package katas.alerey;
import java.util.*;

public class Dinglemouse {

    private static Map<String, List<String>> whoEats = new HashMap<>();

    private static void initWhoEats() {
        whoEats.put("antelope", Arrays.asList("grass"));
        whoEats.put("big-fish", Arrays.asList("little-fish"));
        whoEats.put("bug", Arrays.asList("leaves"));
        whoEats.put("bear", Arrays.asList("big-fish", "bug", "chicken", "cow", "leaves", "sheep"));
        whoEats.put("chicken", Arrays.asList("bug"));
        whoEats.put("cow", Arrays.asList("grass"));
        whoEats.put("fox", Arrays.asList("chicken", "sheep"));
        whoEats.put("giraffe", Arrays.asList("leaves"));
        whoEats.put("lion", Arrays.asList("antelope", "cow"));
        whoEats.put("panda", Arrays.asList("leaves"));
        whoEats.put("sheep", Arrays.asList("grass"));
    }

    public static String[] whoEatsWho(final String zoo) {
        initWhoEats();
        List<String> result = new ArrayList<>();
        result.add(zoo);
        List<String> animals = new ArrayList<>(Arrays.asList(zoo.split(",")));

        int i = 0;
        while (i < animals.size()) {
            if (i != 0)
                if (canEat(animals.get(i), animals.get(i - 1))) {
                    result.add(animals.get(i) + " eats " + animals.get(i - 1));
                    animals.remove(i - 1);
                    i = 0;
                    continue;
                }

            if (i < animals.size() - 1)
                if (canEat(animals.get(i), animals.get(i + 1))) {
                    result.add(animals.get(i) + " eats " + animals.get(i + 1));
                    animals.remove(i + 1);
                    i = 0;
                    continue;
                }

            i++;
        }

        result.add(String.join(",", animals));
        return result.toArray(new String[result.size()]);
    }

    private static boolean canEat(String animal, String animal1) {
        if (whoEats.containsKey(animal))
            if (whoEats.get(animal).indexOf(animal1) != -1)
                return true;
        return false;
    }

}