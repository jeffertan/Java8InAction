package lambdasinaction.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBigestCaloricDishes {

    public static void main(String... args) {

        // Java 7
        getHighCaloricDishesNameInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("==========");

        // Java 8
        getHighCaloricDishesNameInJava8(Dish.menu).forEach(System.out::println);

    }

    private static List<String> getHighCaloricDishesNameInJava8(List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() > 500)
                .sorted(Comparator.comparing(Dish::getCalories, Comparator.reverseOrder()))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    private static List<String> getHighCaloricDishesNameInJava7(List<Dish> dishes) {

        List<Dish> highCaloricDishes = new ArrayList<>();

        for (Dish d : dishes) {
            if (d.getCalories() > 500) {
                highCaloricDishes.add(d);
            }
        }

        List<String> highCaloricDishesName = new ArrayList<>();
        Collections.sort(highCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o2.getCalories(), o1.getCalories());
            }
        });

        for (Dish d : highCaloricDishes) {
            highCaloricDishesName.add(d.getName());
        }

        return highCaloricDishesName;
    }

}
