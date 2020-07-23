package com.thanhpt0105.petclinic.services.springdatajpa;

import com.thanhpt0105.petclinic.model.PetType;
import com.thanhpt0105.petclinic.model.Speciality;
import com.thanhpt0105.petclinic.repositories.SpecialityRepository;
import com.thanhpt0105.petclinic.services.SpecialityService;
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
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialityRepository specialityRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    Speciality returnedSpeciality;

    @BeforeEach
    void setUp() {
        returnedSpeciality = Speciality.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Speciality> returnedSpecialties= new HashSet<>();
        returnedSpecialties.add(Speciality.builder().id(1L).build());
        returnedSpecialties.add(Speciality.builder().id(2L).build());

        when(specialityRepository.findAll()).thenReturn(returnedSpecialties);

        Set<Speciality> specialities = service.findAll();
        assertEquals(2, specialities.size());
        verify(specialityRepository).findAll();
    }

    @Test
    void findById() {
        when(specialityRepository.findById(any())).thenReturn(Optional.of(returnedSpeciality));
        Speciality speciality = service.findById(1L);
        assertNotNull(speciality);
    }

    @Test
    void save() {
        when(specialityRepository.save(any())).thenReturn(returnedSpeciality);
        Speciality speciality = service.save(Speciality.builder().id(1L).build());
        assertNotNull(speciality);
    }

    @Test
    void delete() {
        service.delete(returnedSpeciality);
        verify(specialityRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(specialityRepository, times(1)).deleteById(any());
    }
}