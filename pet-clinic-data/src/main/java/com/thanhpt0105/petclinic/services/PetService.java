package com.thanhpt0105.petclinic.services;

import com.thanhpt0105.petclinic.model.Pet;

public interface PetService extends CrudService<Pet, Long> {

    Pet findById(Long id);

}
