package com.thanhpt0105.petclinic.services.springdatajpa;

import com.thanhpt0105.petclinic.model.Vet;
import com.thanhpt0105.petclinic.model.Visit;
import com.thanhpt0105.petclinic.repositories.VisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.image.VolatileImage;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    Visit returnedVisit;

    @BeforeEach
    void setUp() {
        returnedVisit = Visit.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Visit> returnedVisits = new HashSet<>();
        returnedVisits.add(Visit.builder().id(1L).build());
        returnedVisits.add(Visit.builder().id(2L).build());

        when(visitRepository.findAll()).thenReturn(returnedVisits);

        Set<Visit> visits = service.findAll();
        assertEquals(2, visits.size());
        verify(visitRepository).findAll();
    }

    @Test
    void findById() {
        when(visitRepository.findById(any())).thenReturn(Optional.of(returnedVisit));
        Visit visit = service.findById(1L);
        assertNotNull(visit);
    }

    @Test
    void save() {
        when(visitRepository.save(any())).thenReturn(returnedVisit);
        Visit visit = service.save(Visit.builder().id(1L).build());
        assertNotNull(visit);
    }

    @Test
    void delete() {
        service.delete(returnedVisit);
        verify(visitRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(visitRepository, times(1)).deleteById(any());
    }
}