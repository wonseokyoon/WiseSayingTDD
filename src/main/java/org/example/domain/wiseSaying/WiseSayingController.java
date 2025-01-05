package org.example.domain.wiseSaying;

import jdk.jshell.SourceCodeAnalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
}
