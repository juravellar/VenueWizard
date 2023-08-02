package com.avellar.venuewizard.api.repositories;

import com.avellar.venuewizard.api.entities.Place;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Transactional(readOnly = true)
    Place findByCity(String city);
    @Transactional(readOnly = true)
    Optional<Place> findByState(String state);

    @Transactional(readOnly = true)
    Optional<Place> findBySlug(String slug);
}
