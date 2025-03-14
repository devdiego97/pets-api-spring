package com.diegoddev.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoddev.pets.entities.Pet;

public interface IPetRepository extends JpaRepository<Pet,Long> {

}
