package org.example.largefruitcompanyapi;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getAllFruits() {
        return fruitService.getAllFruits();
    }

    @GetMapping("/{id}")
    public Fruit getFruitById(@PathVariable String id) {
        return fruitService.getFruitById(id);
    }

    /*@GetMapping("/price/{price}")
    public Fruit getFruitByPrice(@PathVariable String price) {
        return fruitService.getFruitByPrice(Integer.parseInt(price));
    }*/

    @GetMapping("/all")
    public List<Fruit> debugAllFruits() {
        return fruitService.getAllFruits();
    }

    @GetMapping("/output")
    public void output() {
        System.out.println("Yes i am running");
    }
}
