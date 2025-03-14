package com.diegoddev.pets.service;

import java.util.List;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diegoddev.pets.entities.Pet;
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

}
