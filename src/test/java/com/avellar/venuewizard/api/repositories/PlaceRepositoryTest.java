package com.avellar.venuewizard.api.repositories;

import static org.junit.Assert.assertEquals;

import com.avellar.venuewizard.api.repositories.PlaceRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.avellar.venuewizard.api.entities.Place;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PlaceRepositoryTest {

    @Autowired
    private PlaceRepository placeRepository;

    private static final String CITY = "Aparecida";
    private static final String STATE = "Sao Paulo";

    @Before
    public void setUp1() throws Exception {
        Place place = new Place();
        place.setCity("Lugar de exemplo");
        place.setCity(CITY);
        this.placeRepository.save(place);
    }
    @Before
    public void setUp2() throws Exception {
        Place place = new Place();
        place.setState("Lugar de exemplo");
        place.setState(STATE);
        this.placeRepository.save(place);
    }
    @After
    public final void tearDown() {
        this.placeRepository.deleteAll();
    }

    @Test
    public void testBuscarPorCity() {
        Place place = this.placeRepository.findByCity(CITY);

        assertEquals(CITY, place.getCity());
    }

}
