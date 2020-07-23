package com.thanhpt0105.petclinic.services.springdatajpa;

import com.thanhpt0105.petclinic.model.Pet;
import com.thanhpt0105.petclinic.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetSDJpaServiceTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetSDJpaService service;

    Pet returnedPet;

    @BeforeEach
    void setUp() {
        returnedPet = Pet.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Pet> returnedPets = new HashSet<>();
        returnedPets.add(Pet.builder().id(1L).build());
        returnedPets.add(Pet.builder().id(2L).build());

        when(petRepository.findAll()).thenReturn(returnedPets);

        Set<Pet> pets = service.findAll();
        assertEquals(2, pets.size());
        verify(petRepository).findAll();
    }

    @Test
    void findById() {
        when(petRepository.findById(any())).thenReturn(Optional.of(returnedPet));
        Pet pet = service.findById(1L);
        assertNotNull(pet);
        assertEquals(returnedPet.getId(), pet.getId());
    }

    @Test
    void save() {
        when(petRepository.save(any())).thenReturn(returnedPet);
        Pet pet = service.save(Pet.builder().id(2L).build());
        assertNotNull(pet);
    }

    @Test
    void delete() {
        service.delete(returnedPet);
        verify(petRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(petRepository, times(1)).deleteById(any());
    }
}