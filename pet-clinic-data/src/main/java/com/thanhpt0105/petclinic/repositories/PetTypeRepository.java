package com.thanhpt0105.petclinic.repositories;

import com.thanhpt0105.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
