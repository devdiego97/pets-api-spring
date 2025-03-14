package com.diegoddev.pets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.PostUpdate;

@RestController
@RequestMapping("/pets")
public class PetsController {
    
    @PostMapping()
    public String addNewPet(){
        return "lista de pets";
    }
    @GetMapping()
    public String getAllPets(){
        return "lista de pets";
    }
    

    @GetMapping("/{id}")
    public String getPetById(@PathVariable Long id){
        return "pet id";
    }
    @PutMapping()
    public String updatePetById(){
        return "lista de pets";
    }

    @DeleteMapping()
    public String deletePetById(){
        return "lista de pets";
    }
    

}
