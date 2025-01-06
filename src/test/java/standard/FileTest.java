package standard;

import org.example.standard.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {
    String file="src/test/java/test/test.txt";
    @Test
    @DisplayName("최초의 파일 테스트")
    void t1(){
        Util.File.test();
    }

    @Test
    @DisplayName("빈 파일 생성")
    void t2(){
//        String file="test.txt";

        Util.File.createFile(file);

        assertThat(Files.exists(Paths.get(file)))
                        .isTrue();
    }

    @Test
    @DisplayName("파일 내용 읽어오기")
    void t3(){
        String testcontent="Hello World!";
//        String file="test.txt";
        //파일을 Hello,World 내용으로 생성
        Util.File.write(file,testcontent);

        String content=Util.File.readAsString(file);

        assertThat(content)
                .isEqualTo(testcontent);
    }

    @Test
    @DisplayName("파일 내용 수정")
    void t4(){

//        String file="src/test/java/test/test.txt";
        String writeContent="modify content";

        Util.File.write(file,writeContent);
        String content=Util.File.readAsString(file);
        assertThat(content)
                .isEqualTo(writeContent);
    }

    @Test
    @DisplayName("파일 내용 삭제")
    void t5(){

//        String file="test.txt";

        // test3 파일 생성
        Util.File.createFile(file);
        assertThat(Files.exists(Paths.get(file)))
                .isTrue();

        // test3 파일 삭제
        Util.File.delete(file);

        // 삭제 됐는지 확인
        assertThat(Files.exists(Paths.get(file)))
                .isFalse();
    }


}
