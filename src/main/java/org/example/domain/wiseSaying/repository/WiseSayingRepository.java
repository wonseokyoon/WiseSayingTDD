package org.example.domain.wiseSaying.repository;

import org.example.domain.wiseSaying.WiseSaying;

import java.util.List;
import java.util.Optional;

public interface WiseSayingRepository {


    WiseSaying save(WiseSaying wiseSaying);

    boolean deleteById(int id);

    List<WiseSaying> findAll();

    Optional<WiseSaying> findById(int id);

}
