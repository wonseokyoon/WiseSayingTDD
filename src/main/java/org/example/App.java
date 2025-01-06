package org.example;


import org.example.domain.wiseSaying.SystemController;
import org.example.domain.wiseSaying.WiseSayingController;

import java.util.Scanner;

public class App {

    private final Scanner sc;
    private final WiseSayingController wiseSayingController;
    private final SystemController systemController;
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

            String[] cmdBit=cmd.split("\\?");
            switch (cmdBit[0]){
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.actionwriter();
                case "목록":
                    wiseSayingController.actionprint();
                case "삭제":
                    wiseSayingController.actiondelete(cmd);
            }
        }

    }
}