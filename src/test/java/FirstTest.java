
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
        String out= TestBot.run("");

        assertThat(out)
                .contains("명령) ")
                .contains("명언앱을 종료합니다.");

    }

    @Test
    @DisplayName("명령 여러개 입력")
    void t4() {
        //입력
        String out=TestBot.run("""
                등록
                등록
                종료
                """);
        //명령 횟수를 세서 검증
        long count=out.split("명령\\) ").length-1;
        System.out.println(count);

        //출력
//        assertThat(out)
//                .contains("명령) ")
//                .contains("명령) ");
        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("앱 시작시 '== 명언 앱 ==' 출력")
    void t5() {
        String out=TestBot.run("");

        assertThat(out)
                .containsSubsequence("==명언 앱==","명언앱을 종료합니다.");
    }

    @Test
    @DisplayName("등록 - 명언 1개 입력")
    void t6() {
        //입력
        String out=TestBot.run("""
                등록
                현재를 사랑하라
                작자미상
                """);

        //출력
        assertThat(out)
                .containsSubsequence("명언: ","작가: ");
    }


}
