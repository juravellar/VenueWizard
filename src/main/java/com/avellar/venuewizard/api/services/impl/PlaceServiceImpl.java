package com.avellar.venuewizard.api.services.impl;

import com.avellar.venuewizard.api.repositories.PlaceRepository;
import com.avellar.venuewizard.api.entities.Place;
import com.avellar.venuewizard.api.services.PlaceService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {

    private static final Logger log = LoggerFactory.getLogger(PlaceServiceImpl.class);

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public Optional<Place> buscarPorCity(String city) {
        log.info("Buscando um local para a cidade {}", city);
        return Optional.ofNullable(placeRepository.findByCity(city));
    }

    @Override
    public Optional<Place> buscarPorState(String state) {
        log.info("Buscando um local para a Estado {}", state);
        return placeRepository.findByState(state);
    }

    @Override
    public Place persistir(Place place) {
        log.info("Persistindo local: {}", place);
        return this.placeRepository.save(place);
    }

}