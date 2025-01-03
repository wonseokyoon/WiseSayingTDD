import org.assertj.core.api.AbstractBooleanAssert;
import org.example.TestApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        TestApp app = new TestApp();
        app.run();

        // aaa가 출력되는지
        //assertThat(result).isEqualTo("aaa");
    }


    @Test
    @DisplayName("앱 시작 시 '==명언 앱==' 출력")
    void t3() {
        //테스트봇 선입력
        Scanner sc = new Scanner("종료\n");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        TestApp app = new TestApp();
        app.run();

        // 출력 값 체크
        assertThat(out.toString())
                .containsSubsequence("==명언 앱==","명언앱을 종료합니다.");
    }

}
