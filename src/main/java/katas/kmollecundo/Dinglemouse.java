package katas.kmollecundo;

import java.util.*;

public class Dinglemouse {
    public static Map<String, String> map = new HashMap<String, String>(){{
        put("antelope", "grass");
        put("big-fish", "little-fish");
        put("bug", "leaves");
        put("bear","big-fish,bug,chicken,cow,leaves,sheep");
        put("chicken","bug");
        put("cow", "grass");
        put("fox","chicken,sheep");
        put("giraffe","leaves");
        put("lion", "antelope,cow");
        put("panda", "leaves");
        put("sheep","grass");
    }};

    public static String[] whoEatsWho(final String zoo) {
        String[] animals = zoo.split(",");
        List<String> res = new ArrayList<>();
        res.add(zoo);
        List<String> list = new ArrayList<>(Arrays.asList(animals));

        for (int i = 0; i < list.size(); ){
            if(i>0){
                String eater = list.get(i);
                String food  = list.get(i-1);
                if(isEatable(eater, food)){
                    res.add(eater +" eats "+ food);
                    list.remove(i-1);
                    i=0;
                }
            }
            if ((i + 1) < list.size()) {
                String eater = list.get(i);
                String food = list.get(i + 1);
                if (isEatable(eater, food)) {
                    res.add(eater + " eats " + food);
                    list.remove(i + 1);
                    i = -1;
                }
            }
            i++;
        }
        if(!list.isEmpty()){
            StringBuilder sb = new StringBuilder();
            list.forEach(x-> sb.append(x).append(","));
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
        }
        return res.toArray(new String[0]);
    }

    public static boolean isEatable(String eater, String food){
        if(!map.containsKey(eater)) return false;
        String[] s = map.get(eater).split(",");
        for(String i: s){
            if(food.equals(i)) {
                return true;
            }
        }
        return false;
    }

}
