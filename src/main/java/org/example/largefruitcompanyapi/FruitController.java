package org.example.largefruitcompanyapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitService service;

    FruitController(FruitService service) {
        this.service = service;
    }

    @GetMapping("/fruit")
    List<Fruit> all() {
        return service.findAll();
    }

    @PostMapping("/fruit")
    Fruit newFruit(@RequestBody Fruit newFruit) {
        return service.save(newFruit);
    }

    @GetMapping("/fruit/{id}")
    Fruit one(@PathVariable Long id) {
        return service.getReferenceById(id);

    }

    @PutMapping("/fruit/{id}")
    Fruit replaceEmployee(@RequestBody Fruit newFruit, @PathVariable Long id) {
        return service.replaceFruit(newFruit,id);
    }

    @DeleteMapping("/fruit/{id}")
    void deleteEmployee(@PathVariable Long id) {
        service.deleteFruit(id);
    }

}
