package org.example.largefruitcompanyapi;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAllFruits();
        if (fruits == null ) { //if not created, not found
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fruits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable String id) {
        Fruit fruit = fruitService.getFruitById(id);
        if (fruit == null) {
                return ResponseEntity.notFound().build();
            }
        return ResponseEntity.ok(fruit);
    }

    /*@GetMapping("/price/{price}")
    public Fruit getFruitByPrice(@PathVariable String price) {
        return fruitService.getFruitByPrice(Integer.parseInt(price));
    }*/
}
