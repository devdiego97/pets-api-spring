package com.diegoddev.pets.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        Pet savedPet = petService.createPet(pet);
        return ResponseEntity.ok(savedPet);
    }
    @GetMapping()
    public ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> pets=petService.listAllPets();
        return ResponseEntity.ok(pets);
    }
    
    @GetMapping("/{id}")
       public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
          Pet petId=petService.findPetById(id);
          return ResponseEntity.ok(petId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet updatedPet) {
        Pet pet = petService.updatePetId(id, updatedPet);
        return ResponseEntity.ok(pet);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePet(@PathVariable Long id) {
        petService.deletePetId(id);
        return ResponseEntity.ok("Pet excluído com sucesso");
    }
    

  

}
