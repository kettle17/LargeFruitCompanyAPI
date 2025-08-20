package org.example.largefruitcompanyapi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public Fruit save(Fruit newFruit){
        return fruitRepository.save(newFruit);
    }

    public Fruit getReferenceById(Long id){
        Fruit fruit = fruitRepository.findById(id).orElse(null);

        if (fruit == null) {
            throw new FruitNotFoundException(id);
        }

        return fruit;
    }

    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    public Fruit replaceFruit(Fruit newFruit, Long id){
        Fruit fruit = fruitRepository.findById(id).orElse(null);
        if (fruit != null) {
            fruit.setId(newFruit.getId());
            fruit.setName(newFruit.getName());
            fruit.setPrice(newFruit.getPrice());
            return fruitRepository.save(fruit);
        } else {
            return fruitRepository.save(newFruit);
        }
    }

    public void deleteFruit(Long id){
        fruitRepository.deleteById(id);
    }
}