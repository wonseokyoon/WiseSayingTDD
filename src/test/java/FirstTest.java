import org.example.App;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstTest {

    @Test
    void t1() {
        int rst = 1;
        assertThat(rst).isEqualTo(1);
    }

    @Test
    void t2() {
        //App app = new App();
        //app.run();

        // aaa가 출력되는지
        //assertThat(result).isEqualTo("aaa");
    }

    @Test
    void t3(){
        String out=TestBot.run("");
        assertThat(out)
                .containsSubsequence("명령","명언앱을 종료합니다");
    }


    @Test
    @DisplayName("명령을 여러번 입력할 수 있다")
    void t4() {
        String out=TestBot.run("""
                등록
                등록
                종료
                """);
        // 명령 ) 의 횟수 계산
        long count= out.split("명령 \\)").length-1;
        //검증
        assertThat(count).isEqualTo(3);

    }

    @Test
    @DisplayName("앱 시작시 '== 명언 앱 ==' 출력")
    void t5() {
        String out = TestBot.run("");

        assertThat(out)
                .containsSubsequence("== 명언 앱 ==", "명언앱을 종료합니다.");

    }

    @Test
    @DisplayName("등록 - 명언 1개 입력")
    void t6() {
        String out = TestBot.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        assertThat(out)
                .containsSubsequence("명언 : ", "작가 : ");

    }
}
