package com.thanhpt0105.petclinic.repositories;

import com.thanhpt0105.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
