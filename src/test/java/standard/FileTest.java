package standard;

import org.example.standard.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.PATH;

public class FileTest {

    @Test
    @DisplayName("최초의 파일 테스트")
    void t1(){
        Util.File.test();
    }

    @Test
    @DisplayName("빈 파일 생성")
    void t2(){
        String file="test.txt";

        Util.File.createFile();

        assertThat(Files.exists(Paths.get(file)))
                        .isTrue();

    }

}
