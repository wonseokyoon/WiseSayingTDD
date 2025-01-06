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
        String strid=cmd.getParam("id");
        int id=Integer.parseInt(strid);

        assertThat(id).isEqualTo(1);
    }

    @Test
    @DisplayName("파라미터가 불완전할 때 - 삭제?id")
    void t6(){
        Command cmd1=new Command("삭제?id1");
        String id1=cmd1.getParam("id");
        Command cmd2=new Command("삭제?id");
        String id2=cmd2.getParam("id");
        Command cmd3=new Command("삭제?id=aa");
        String id3=cmd3.getParam("id");

        assertThat(id1).isNull();
        assertThat(id2).isNull();
        assertThat(id3).isEqualTo("aa");
    }

    @Test
    @DisplayName("파라미터가 여러개 있을 떄, 파라미터 가져오기 - 목록?key1=val1&key2=val2")
    void t7(){

        Command cmd=new Command("목록?key1=val1&key2=val2");
        String param1=cmd.getParam("key1");
        String param2=cmd.getParam("key2");

        assertThat(param1).isEqualTo("val1");
        assertThat(param2).isEqualTo("val2");


    }

}
