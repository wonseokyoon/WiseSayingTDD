import org.example.domain.WiseSaying;
import org.example.domain.WiseSayingController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

    private final Scanner sc;
    private final WiseSayingController wiseSayingController;

    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingController = new WiseSayingController(sc);
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령 ) ");
            String cmd = sc.nextLine();
            if (cmd.equals("종료")) {
                System.out.println("명언앱을 종료합니다.");
                break;
            } else if(cmd.equals("등록")) {
                wiseSayingController.actionWrite();
            } else if(cmd.equals("목록")) {
                wiseSayingController.actionPrint();
            }
        }
    }
}