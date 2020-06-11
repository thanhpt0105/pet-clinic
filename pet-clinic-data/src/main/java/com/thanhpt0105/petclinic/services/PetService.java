package com.thanhpt0105.petclinic.services;

import com.thanhpt0105.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
