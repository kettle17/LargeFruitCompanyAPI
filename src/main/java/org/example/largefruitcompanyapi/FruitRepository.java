package org.example.largefruitcompanyapi;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class FruitRepository {

    private static final List<Fruit> fruits = Arrays.asList(
            new Fruit(1, "Apple", 1.0),
            new Fruit(2, "Orange", 0.8),
            new Fruit(3, "Mango", 1.5),
            new Fruit(4, "Cherry", 0.2)
    );

    public static List<Fruit> findAll() {
        return fruits;
    }

    public static Fruit findById(int id) {
        return fruits.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null); // returns null if not found
    }
}
