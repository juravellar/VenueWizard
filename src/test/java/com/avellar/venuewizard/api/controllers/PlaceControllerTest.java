package com.avellar.venuewizard.api.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.avellar.venuewizard.api.entities.Place;
import com.avellar.venuewizard.api.services.PlaceService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PlaceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlaceService placeService;


    private static final String BUSCAR_PLACE_CITY_URL = "/api/place/city/";
    private static final String BUSCAR_PLACE_STATE_URL = "/api/place/state/";
    private static final Long ID = Long.valueOf(1);
    private static final String CITY = "Goiania";
    private static final String STATE = "Goias";

    @Test
    @WithMockUser
    public void testBuscarPlaceCityInvalido() throws Exception {
        BDDMockito.given(this.placeService.buscarPorCity(Mockito.anyString())).willReturn(Optional.empty());

        mvc.perform(MockMvcRequestBuilders.get(BUSCAR_PLACE_CITY_URL + CITY).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").value("Lugar não encontrado para a cidade " + CITY));
    }

    @Test
    @WithMockUser
    public void testBuscarPlaceStateInvalido() throws Exception {
        BDDMockito.given(this.placeService.buscarPorState(Mockito.anyString())).willReturn(Optional.empty());

        mvc.perform(MockMvcRequestBuilders.get(BUSCAR_PLACE_STATE_URL + STATE).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").value("Lugar não encontrado para o Estado " + STATE));
    }

    @Test
    @WithMockUser
    public void testBuscarPlaceCityValido() throws Exception {
        BDDMockito.given(this.placeService.buscarPorCity(Mockito.anyString()))
                .willReturn(Optional.of(this.obterDadosPlace()));

        mvc.perform(MockMvcRequestBuilders.get(BUSCAR_PLACE_CITY_URL + CITY)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(ID))
                .andExpect(jsonPath("$.data.city", equalTo(CITY)))
                .andExpect(jsonPath("$.data.state", equalTo(STATE)))
                .andExpect(jsonPath("$.errors").isEmpty());
    }

    @Test
    @WithMockUser
    public void testBuscarPlaceStateValido() throws Exception {
        BDDMockito.given(this.placeService.buscarPorState(Mockito.anyString()))
                .willReturn(Optional.of(this.obterDadosPlace()));

        mvc.perform(MockMvcRequestBuilders.get(BUSCAR_PLACE_STATE_URL + STATE)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(ID))
                .andExpect(jsonPath("$.data.city", equalTo(CITY)))
                .andExpect(jsonPath("$.data.state", equalTo(STATE)))
                .andExpect(jsonPath("$.errors").isEmpty());
    }

    private Place obterDadosPlace() {
        Place place = new Place();
        place.setId(ID);
        place.setCity(CITY);
        place.setState(STATE);
        return place;
    }

}
