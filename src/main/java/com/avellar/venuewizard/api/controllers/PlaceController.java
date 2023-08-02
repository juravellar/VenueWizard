package com.avellar.venuewizard.api.controllers;

import java.util.Optional;

import com.avellar.venuewizard.api.entities.Place;
import com.avellar.venuewizard.api.response.Response;
import com.avellar.venuewizard.api.services.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avellar.venuewizard.api.dtos.PlaceDto;

@RestController
@RequestMapping("/venue-wizard/places")
@CrossOrigin(origins = "*")
public class PlaceController {
    private static final Logger log = LoggerFactory.getLogger(PlaceController.class);

    @Autowired
    private PlaceService placeService;

    /**
     * Retorna um lugar dado uma cidade
     * @param city
     * @return ResponseEntity<Response<PlaceDto>>
     */
    @GetMapping(value = "/city/{city}")
    public ResponseEntity<Response<PlaceDto>> buscarPorCity(@PathVariable("city") String city) {
        log.info("Buscando local pela cidade: {}", city);
        Response<PlaceDto> response = new Response<PlaceDto>();
        Optional<Place> place = placeService.buscarPorCity(city);

        if (!place.isPresent()) {
            log.info("Local não encontrado para a cidade dada: {}", city);
            response.getErrors().add("Local não encontrado para a cidade dada: " + city);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(this.converterPlaceDto(place.get()));
        return ResponseEntity.ok(response);
    }

    /**
     * Retorna um lugar dado um Estado
     * @param state
     * @return ResponseEntity<Response<PlaceDto>>
     */
    @GetMapping(value = "/state/{state}")
    public ResponseEntity<Response<PlaceDto>> buscarPorState(@PathVariable("state") String state) {
        log.info("Buscando local pelo Estado: {}", state);
        Response<PlaceDto> response = new Response<PlaceDto>();
        Optional<Place> place = placeService.buscarPorState(state);

        if (!place.isPresent()) {
            log.info("Local não encontrado para o Estado dado: {}", state);
            response.getErrors().add("Local não encontrado para o Estado dado: " + state);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(this.converterPlaceDto(place.get()));
        return ResponseEntity.ok(response);
    }

    /**
     * Popula um DTO com os dados de um local.
     * @param place
     * @return PlaceDto
     */
    public PlaceDto converterPlaceDto(Place place) {
        PlaceDto placeDto = new PlaceDto();
        placeDto.setSlug(place.getSlug());
        placeDto.setCity(place.getCity());
        placeDto.setState(place.getState());

        return placeDto;
    }
}