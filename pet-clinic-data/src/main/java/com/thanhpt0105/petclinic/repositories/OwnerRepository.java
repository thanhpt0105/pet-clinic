package com.thanhpt0105.petclinic.repositories;

import com.thanhpt0105.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

    List<Owner> findAllByLastNameContainingIgnoreCase(String lastName);
}
