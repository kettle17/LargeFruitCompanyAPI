package org.example.largefruitcompanyapi;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<Fruit> getAllFruits() {
        List<Fruit> result = fruitRepository.findAll().buffer().blockFirst();
        System.out.println(result);
        return result;
    }

    public Fruit getFruitById(String id) {
        return fruitRepository.findById(id).block();
    }
}
