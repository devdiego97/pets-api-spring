package com.diegoddev.pets.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegoddev.pets.entities.Pet;
import com.diegoddev.pets.service.PetService;

import jakarta.persistence.PostUpdate;

@RestController
@RequestMapping("/pets")
public class PetsController {
    private PetService petService;

  public PetsController(PetService petService){
    this.petService=petService;
  } 


    @PostMapping()
    public String addNewPet(){
       return "hell";
        
    }
    @GetMapping()
    public ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> pets=petService.listAllPets();
        return ResponseEntity.ok(pets);
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
