package com.thanhpt0105.petclinic.services;

import com.thanhpt0105.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
