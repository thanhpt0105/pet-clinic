package com.thanhpt0105.petclinic.repositories;

import com.thanhpt0105.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
