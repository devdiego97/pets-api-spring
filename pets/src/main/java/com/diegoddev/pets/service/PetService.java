package com.diegoddev.pets.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.diegoddev.pets.entities.Pet;
import com.diegoddev.pets.exception.PetNotFoundException;
import com.diegoddev.pets.repository.IPetRepository;

@Service
public class PetService<PetResponseDto> {
    @Autowired
    private  IPetRepository petRepository;
     
      public PetService(IPetRepository petRepository){
         this.petRepository=petRepository;
      }



    // Método para listar todos os pets
    public List<Pet> listAllPets() {
        // Busca todos os pets no repositório
        List<Pet> pets = petRepository.findAll();
        return pets;
    }
    //Pegar um pet pelo id
    public Pet findPetById(Long id) {
      return petRepository.findById(id)
        .orElseThrow(() -> new PetNotFoundException("Pet não encontrado com o ID: " + id));
   }

   //adicionar novo pet
   public Pet createPet(Pet pet){
     Pet newPet=new Pet(pet.getId(),pet.getName(),pet.getColor(), pet.getSex(),pet.getAge(),pet.getRace());
     Pet savePet=petRepository.save(newPet);
     return savePet;
   }

   //atualizar pet
   public Pet updatePetId(Long id, Pet updatedPet) {
    Pet existingPet = petRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Pet não encontrado com o ID: " + id));
          if (updatedPet.getName() != null) {
              existingPet.setName(updatedPet.getName());
          }
          if (updatedPet.getColor() != null) {
              existingPet.setColor(updatedPet.getColor());
          }
          if (updatedPet.getSex() != null) {
              existingPet.setSex(updatedPet.getSex());
          }
          if (updatedPet.getAge() != null) {
              existingPet.setAge(updatedPet.getAge());
          }
          if (updatedPet.getRace() != null) {
              existingPet.setRace(updatedPet.getRace());
          }

      // Salva o Pet atualizado no banco de dados
      return petRepository.save(existingPet);
    }
    public void deletePetId(Long id) {
      if (!petRepository.existsById(id)) {
          throw new PetNotFoundException("Pet não encontrado com o ID: " + id);
      }
      petRepository.deleteById(id);
  }


}
