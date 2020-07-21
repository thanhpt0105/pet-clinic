package com.thanhpt0105.petclinic.repositories;

import com.thanhpt0105.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
