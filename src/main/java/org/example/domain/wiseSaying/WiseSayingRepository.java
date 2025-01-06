package org.example.domain.wiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingRepository {

    private final List<WiseSaying> wiseSayingList;
    private int lastId;

    public WiseSayingRepository(){
        wiseSayingList=new ArrayList<>();
    }
    public WiseSaying save(WiseSaying wiseSaying){

        // 등록과 수정 구별

        if(!wiseSaying.isNew()){
            return wiseSaying;
        }

        int id=++lastId;
        wiseSaying.setId(id);
        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }

    public boolean deleteById(int id) {
        return wiseSayingList.removeIf(w -> w.getId() == id); // 삭제 성공 : true, 삭제 실패 : false
    }

    public Optional<WiseSaying> findById(int id) {
        Optional<WiseSaying> wiseSaying=wiseSayingList.stream()
                .filter(w-> w.getId()==id)
                .findFirst();
        return wiseSaying;
    }
}
