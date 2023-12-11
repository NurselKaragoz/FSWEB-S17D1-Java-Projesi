package com.workintech.model.controller;

import com.workintech.model.model.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/animal")
public class AnimalController {
    private  Map<Integer, Animal> animals = new HashMap<>();
    @GetMapping("/")
    public List<Animal> findAll(){
        return animals.values().stream().toList();
    }




    @PostMapping("/")

    public Animal save(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
        return animal;
    }



    @PutMapping("/{id}")
    public Animal update(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id,
                new Animal( id, animal.getName()));
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal delete(@PathVariable int id){
       Animal animal = animals.remove(id);
        return animal;
    }


}
