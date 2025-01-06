package org.example.domain.wiseSaying;

import org.example.global.Command;

import java.util.*;

public class WiseSayingController {


    private final Scanner sc;
    private List<WiseSaying> wiseSayingList;
    private final WiseSayingService wiseSayingService;
    private int lastId;
    public WiseSayingController(Scanner sc){
        this.sc=sc;
        wiseSayingList=new ArrayList<>();
        wiseSayingService=new WiseSayingService();
        lastId=0;
    }

    public void actionwriter(){
        System.out.println("명언: ");
        String content=sc.nextLine();
        System.out.println("작가: ");
        String author=sc.nextLine();

        WiseSaying wiseSaying=wiseSayingService.write(content,author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void actionprint(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        wiseSayingList=wiseSayingService.getAllItems();
        List<WiseSaying> reversed=new ArrayList<>(wiseSayingList);
        Collections.reverse(reversed);

        reversed.forEach(w->{
            System.out.printf("%d / %s / %s\n",w.getId(),w.getAuthor(),w.getContent());
        });
    }

    public void actiondelete(Command cmd) {
        // 삭제?id=1
        int id = cmd.getParamAsInt("id");

        boolean result = wiseSayingService.delete(id);

        if(!result) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
        }
    }

    public void actionModify(Command cmd) {
        // 수정?id=1
        int id = cmd.getParamAsInt("id");

        Optional<WiseSaying> opwiseSaying=wiseSayingService.getItem(id);
        WiseSaying wiseSaying=opwiseSaying.orElse(null);

        if(wiseSaying==null){
            System.out.println("해당 명언은 존재하지 않습니다.");
            return;
        }

        System.out.printf("명언(기존) :%s\n",wiseSaying.getContent());
        System.out.println("명언 : ");
        String newContent=sc.nextLine();

        System.out.printf("작가(기존) :%s\n",wiseSaying.getAuthor());
        System.out.println("작가 : ");
        String newAuthor=sc.nextLine();

        wiseSayingService.modify(wiseSaying,newContent,newAuthor);
        System.out.println("%d번 명언이 수정되었습니다.".formatted(id));

    }
}
