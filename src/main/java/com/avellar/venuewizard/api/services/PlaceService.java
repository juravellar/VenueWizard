package com.avellar.venuewizard.api.services;

import com.avellar.venuewizard.api.entities.Place;

import java.util.Optional;

public interface PlaceService {

    Place persistir(Place place);

    /**
     * Retorna um lugar dado uma cidade
     *
     * @param city
     * @return Optional<Place>
     */
    Optional<Place> buscarPorCity(String city);

    /**
     * Retorna um lugar dado um Estado
     *
     * @param state
     * @return Optional<Place>
     */
    Optional<Place> buscarPorState(String state);
    /**
     * Cadastra um novo local na base de dados.
     *
     * @param place
     * @return Place
     */
}
