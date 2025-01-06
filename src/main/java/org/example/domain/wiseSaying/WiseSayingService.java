package org.example.domain.wiseSaying;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;
    public WiseSayingService(){
        wiseSayingRepository=new WiseSayingRepository();
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying=new WiseSaying(content,author);
        return wiseSayingRepository.save(wiseSaying);
    }

    public List<WiseSaying> getAllItems() {
        return wiseSayingRepository.findAll();
    }

    public boolean delete(int id) {
        return wiseSayingRepository.deleteById(id);
    }

    public Optional<WiseSaying> getItem(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void modify(WiseSaying wiseSaying, String newContent,String newAuthor) {
        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.save(wiseSaying);
    }

}
