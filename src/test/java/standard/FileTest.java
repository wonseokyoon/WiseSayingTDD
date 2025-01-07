package standard;

import org.example.standard.Util;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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

    //테스트 시작 전에 test 폴더 생성
//    @Test
//    @DisplayName("폴더 생성")
//    void t6(){
//
//        String dirPath="src/test/java/test";    //디렉터리 경로
//        Util.File.createDir(dirPath);
//
//        // 폴더가 존재하는지
//        assertThat(Files.exists(Paths.get(dirPath)))
//                .isTrue();
//        // 폴더가 맞는지
//        assertThat(Files.isDirectory(Paths.get(dirPath)))
//                .isTrue();
//    }
//
//    // 테스트 종료 후에 test 폴더 삭제
//    @Test
//    @DisplayName("폴더 삭제")
//    void t7(){
//
//        String dirPath="src/test/java/test";    //디렉터리 경로
//        Util.File.deleteDir(dirPath);
//
//        // 폴더가 존재하는지
//        assertThat(Files.exists(Paths.get(dirPath)))
//                .isFalse();
//    }

    //테스트 전처리
    @BeforeAll
    static void beforeAll(){
        System.out.println("테스트 시작 전에 한번 실행");
        Util.File.createDir("src/test/java/test");
    }

    // 테스트 후처리
    @AfterAll
    static void afterAll(){
        System.out.println("테스트 실행 후 한번 실행");
        Util.File.deleteDir("src/test/java/test");
    }

    @Test
    @DisplayName("폴더가 없을때 파일 생성 시 폴더 생성 후 파일 생성")
    void v8(){
        String path="test2/test.txt";

        Util.File.createFile(path);

        assertThat(Files.exists(Paths.get(path)))
                .isTrue();
    }

    @Test
    @DisplayName("파일 삭제 -> 폴더가 비어있을때 삭제 여부")
    void v9(){
        String path="test/test2/test.txt";

        Util.File.deleteForce(path);    // 강제 삭제
        Util.File.delete(path);

        assertThat(Files.exists(Paths.get(path)))
                .isFalse();
    }
}
