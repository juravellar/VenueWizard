package com.avellar.venuewizard.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import com.avellar.venuewizard.api.entities.Slug;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.avellar.venuewizard.api.entities.Place;
import com.avellar.venuewizard.api.repositories.PlaceRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PlaceServiceTest {

    @MockBean
    private PlaceRepository placeRepository;

    @Autowired
    private PlaceService placeService;

    @Before
    public void setUp() throws Exception {
        BDDMockito.given(this.placeRepository.findBySlug(Mockito.anyString())).willReturn(Optional.of(new Place()));
        BDDMockito.given(this.placeRepository.save(Mockito.any(Place.class))).willReturn(new Place());
    }

    @Test
    public void testBuscarPlacePorSlug() {
        Optional<Place> place = this.placeService.buscarPorSlug(testBuscarPlacePorSlug());

        assertTrue(place.isPresent());
    }

    @Test
    public void testPersistirPlace() {
        Place place = this.placeService.persistir(new Place());

        assertNotNull(place);
    }

}