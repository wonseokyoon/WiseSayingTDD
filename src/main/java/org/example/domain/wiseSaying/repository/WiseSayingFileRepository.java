package org.example.domain.wiseSaying.repository;

import org.example.domain.wiseSaying.WiseSaying;
import org.example.standard.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingFileRepository implements WiseSayingRepository {

    private final List<WiseSaying> wiseSayingList;
    private int lastId;

    public WiseSayingFileRepository() {
        wiseSayingList = new ArrayList<>();
        System.out.println("파일 DB 사용");
    }

    public WiseSaying save(WiseSaying wiseSaying) {

        // 파일 저장
        Util.Json.writeAsMap("db/wiseSaying/%d.json".formatted(wiseSaying.getId()), wiseSaying.toMap());
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }

    public boolean deleteById(int id) {
        return wiseSayingList.removeIf(w -> w.getId() == id); // 삭제 성공 : true, 삭제 실패 : false
    }

    public Optional<WiseSaying> findById(int id) {

        return wiseSayingList.stream()
                .filter(w -> w.getId() == id)
                .findFirst();
    }
}
