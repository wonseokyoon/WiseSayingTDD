package global;

import org.example.global.Command;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class CommandTest {

    @Test
    @DisplayName("command Test 최초 테스트")
    void t1(){
        Command cmd=new Command("");
    }

    @Test
    @DisplayName("action 네임을 얻어올 수 있다. - 삭제?id=1이면 삭제가 나와야한다")
    void t2(){
        Command cmd=new Command("삭제?id=1");
        String actionName=cmd.getActionName();

        assertThat(actionName).isEqualTo("삭제");

    }

    @Test
    @DisplayName("action 네임을 얻어올 수 있다. - ?가 없어도 삭제가 나와야한다")
    void t3(){
        Command cmd=new Command("삭제");
        String actionName=cmd.getActionName();

        assertThat(actionName).isEqualTo("삭제");

    }
    @Test
    @DisplayName("불완전한 입력이 들어왔을 때")
    void t4(){
        Command cmd=new Command("삭제");
        String actionName=cmd.getActionName();

        assertThat(actionName).isEqualTo("삭제");

    }

    @Test
    @DisplayName("파라미터를 반환한다 - 입력값이 삭제?id=1일때 1을 반환")
    void t5(){
        Command cmd=new Command("삭제?id=1");
        int id=cmd.getParam();

        assertThat(id).isEqualTo(1);
    }

}
