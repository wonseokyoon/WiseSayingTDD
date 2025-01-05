package org.example;


import org.example.domain.wiseSaying.SystemController;
import org.example.domain.wiseSaying.WiseSaying;
import org.example.domain.wiseSaying.WiseSayingController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    private final Scanner sc;
    private final WiseSayingController wiseSayingController;
    private final SystemController systemController;
    private int lastId;
    private List<WiseSaying> wiseSayingList;
    public App(Scanner sc){
        this.sc=sc;
        wiseSayingController=new WiseSayingController(sc);
        systemController=new SystemController();
    }

    public void run() {
        System.out.println("==명언 앱==");

        while(true){
            System.out.println("명령) ");
            String cmd=sc.nextLine();

            if(cmd.equals("종료")) {
                systemController.exit();
                break;
            }
            else if (cmd.equals("등록")) {
                wiseSayingController.actionwriter();
            }
            else if (cmd.equals("목록")) {
                wiseSayingController.actionprint();
            }
        }

    }
}