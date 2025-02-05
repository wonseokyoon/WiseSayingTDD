package domain.wiseSaying;

import standard.TestBot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class wiseSayingControllerTest {
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
        String out= TestBot.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                종료
                """);
        //명령 횟수를 세서 검증
        long count=out.split("명령\\) ").length-1;
        System.out.println(count);

        //출력
//        assertThat(out)
//                .contains("명령) ")
//                .contains("명령) ");
        assertThat(count).isEqualTo(4);
    }

    @Test
    @DisplayName("앱 시작시 '== 명언 앱 ==' 출력")
    void t5() {
        String out= TestBot.run("");

        assertThat(out)
                .containsSubsequence("==명언 앱==","명언앱을 종료합니다.");
    }

    @Test
    @DisplayName("등록 - 명언 1개 입력")
    void t6() {
        //입력
        String out= TestBot.run("""
                등록
                현재를 사랑하라
                작자미상
                """);

        //출력
        assertThat(out)
                .containsSubsequence("명언: ","작가: ");
    }

    @Test
    @DisplayName("등록시 명언 번호 노출")
    void t7() {
        //입력
        String out= TestBot.run("""
                등록
                현재를 사랑하라
                작자미상
                """);

        //출력
        assertThat(out)
                .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("생성되는 명언번호 계속 증가")
    void t8() {
        //입력
        String out= TestBot.run("""
                등록
                현재를 사랑하라
                작자미상
                등록
                현재를 사랑하라2
                작자미상
                """);

        //출력
        assertThat(out)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록 - 명언 2개 입력하면 입력된 명언들이 출력된다.")
    void t9() {
        //입력
        String out= TestBot.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                """);

        //출력
        assertThat(out)
                .contains("번호 / 작가 / 명언")
                .contains("----------------------")
                .containsSubsequence("2 / 작자미상 / 과거에 집착하지 마라."
                        ,"1 / 작자미상 / 현재를 사랑하라.");
    }

    @Test
    @DisplayName("삭제 - id를 이용해서 해당 id의 명언을 삭제할 수 있다. 입력 : 삭제?id=1")
    void t10() {
        String out = TestBot.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                삭제?id=1
                목록
                """);


        assertThat(out)
                .contains("2 / 작자미상 / 과거에 집착하지 마라.")
                .doesNotContain("1 / 작자미상 / 현재를 사랑하라.");
    }

    @Test
    @DisplayName("삭제 예외 처리 - 없는 id로 삭제를 시도하면 예외처리 메시지가 나온다.")
    void t11() {
        String out = TestBot.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                삭제?id=1
                삭제?id=1
                """);

        assertThat(out)
                .contains("1번 명언은 존재하지 않습니다.");
    }

    @Test
    @DisplayName("수정 - id를 이용해서 해당 id의 명언을 수정할 수 있다. 이때 기존의 명언과 작가가 나와야 함. 입력값 - 수정?id=1")
    void t12() {
        String out = TestBot.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                수정?id=1
                새 명언 내용
                새 작가
                목록
                """);

        assertThat(out)
                .doesNotContain("1 / 작자미상 / 현재를 사랑하라.")
                .contains("1 / 새 작가 / 새 명언 내용");
    }



}
