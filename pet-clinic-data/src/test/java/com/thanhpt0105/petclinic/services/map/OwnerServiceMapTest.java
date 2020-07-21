package com.thanhpt0105.petclinic.services.map;

import com.thanhpt0105.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Long testId = 1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(testId).build());
    }

    @Test
    void findByLastName() {
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(testId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(testId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner3 = Owner.builder().build();
        Owner savedOwner = ownerServiceMap.save(owner3);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(testId);
        assertEquals(testId, owner.getId());
    }
}