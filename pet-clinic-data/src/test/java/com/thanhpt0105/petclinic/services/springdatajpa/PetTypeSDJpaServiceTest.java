package com.thanhpt0105.petclinic.services.springdatajpa;

import com.thanhpt0105.petclinic.model.Pet;
import com.thanhpt0105.petclinic.model.PetType;
import com.thanhpt0105.petclinic.repositories.PetTypeRepository;
import com.thanhpt0105.petclinic.services.PetTypeService;
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
class PetTypeSDJpaServiceTest {

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    PetTypeSDJpaService service;

    PetType returnedPetType;

    @BeforeEach
    void setUp() {
        returnedPetType = PetType.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<PetType> returnedPetTypes= new HashSet<>();
        returnedPetTypes.add(PetType.builder().id(1L).build());
        returnedPetTypes.add(PetType.builder().id(2L).build());

        when(petTypeRepository.findAll()).thenReturn(returnedPetTypes);

        Set<PetType> petTypes = service.findAll();
        assertEquals(2, petTypes.size());
        verify(petTypeRepository).findAll();
    }

    @Test
    void findById() {
        when(petTypeRepository.findById(any())).thenReturn(Optional.of(returnedPetType));
        PetType petType = service.findById(1L);
        assertNotNull(petType);

    }

    @Test
    void save() {
        when(petTypeRepository.save(any())).thenReturn(returnedPetType);
        PetType petType = service.save(PetType.builder().id(1L).build());
        assertNotNull(petType);
    }

    @Test
    void delete() {
        service.delete(returnedPetType);
        verify(petTypeRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(petTypeRepository, times(1)).deleteById(any());
    }
}