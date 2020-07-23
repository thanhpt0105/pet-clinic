package com.thanhpt0105.petclinic.services.springdatajpa;

import com.thanhpt0105.petclinic.model.Speciality;
import com.thanhpt0105.petclinic.model.Vet;
import com.thanhpt0105.petclinic.repositories.VetRepository;
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
class VetSDJpaServiceTest {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetSDJpaService service;

    Vet returnedVet;

    @BeforeEach
    void setUp() {
        returnedVet = Vet.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Vet> returnedVets= new HashSet<>();
        returnedVets.add(Vet.builder().id(1L).build());
        returnedVets.add(Vet.builder().id(2L).build());

        when(vetRepository.findAll()).thenReturn(returnedVets);

        Set<Vet> vets = service.findAll();
        assertEquals(2, vets.size());
        verify(vetRepository).findAll();
    }

    @Test
    void findById() {
        when(vetRepository.findById(any())).thenReturn(Optional.of(returnedVet));
        Vet vet = service.findById(1L);
        assertNotNull(vet);
    }

    @Test
    void save() {
        when(vetRepository.save(any())).thenReturn(returnedVet);
        Vet vet = service.save(Vet.builder().id(1L).build());
        assertNotNull(vet);
    }

    @Test
    void delete() {
        service.delete(returnedVet);
        verify(vetRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(vetRepository, times(1)).deleteById(any());
    }
}