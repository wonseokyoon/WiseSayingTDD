package org.example.standard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {

    public static class File{
        public static void test(){
            System.out.println("파일 유틸 테스트");
        }


        public static void createFile(String file) {
            Path filepath=Paths.get("file");

            try {
                Files.createFile(filepath);
            } catch (IOException e) {
                System.out.println("파일 생성중 실패");
                e.printStackTrace();
            }

        }
    }

}
