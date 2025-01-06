package org.example;


import org.example.domain.wiseSaying.SystemController;
import org.example.domain.wiseSaying.WiseSayingController;
import org.example.global.Command;

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

            Command command=new Command(cmd);
            String[] cmdBits = cmd.split("\\?");
            String actionName = cmdBits[0];
            switch (actionName){
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.actionwriter();
                    break;
                case "목록":
                    wiseSayingController.actionprint();
                    break;
                case "삭제":
                    wiseSayingController.actiondelete(command);
                    break;
                case "수정":
                    wiseSayingController.actionModify(command);
                    break;
            }
        }

    }
}