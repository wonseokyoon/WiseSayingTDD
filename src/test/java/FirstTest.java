
import org.example.App;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;


public class FirstTest {
    @Test
    void t1() {
        int rst = 1;
        assertThat(rst).isEqualTo(1);
    }

    @Test
    void t2() {
//        App app = new App();
//        app.run();

        // aaa가 출력되는가?
        // assertThat(result).isEqualTo("aaa");
    }

    @Test
    void t3() {
        String out= TestBot.run("종료");

        assertThat(out)
                .contains("명언앱을 종료합니다.");

    }

    @Test
    @DisplayName("앱 시작시 '== 명언 앱 ==' 출력")
    void t4() {
        String out=TestBot.run("종료");

        assertThat(out)
                .containsSubsequence("==명언 앱==","명언앱을 종료합니다.");
    }

    @Test
    @DisplayName("등록 - 명언 1개 입력")
    void t5() {
        //입력
        String out=TestBot.run("""
                등록
                현재를 사랑하라
                작자미상
                종료
                """);

        //출력
        assertThat(out)
                .contains("명언: ")
                .contains("작가: ");
    }


}
