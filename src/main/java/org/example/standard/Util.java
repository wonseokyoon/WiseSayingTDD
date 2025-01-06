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
            Path filepath=Paths.get(file);

            try {
                if(Files.exists(filepath)){
//                    System.out.println("파일이 이미 존재함");
                    write(file,"");
                }
                else{
                    Files.createFile(filepath);
                }
            } catch (IOException e) {
                System.out.println("파일 생성중 실패");
                e.printStackTrace();
            }

        }

        public static String readAsString(String file) {
            Path filePath=Paths.get(file);

            try {
                return Files.readString(filePath);
            } catch (IOException e) {
                System.out.println("파일 읽기 실패");
                e.printStackTrace();
            }
            return "";
        }

        public static void write(String file, String writeContent) {
            Path filePath=Paths.get(file);
            try {
                Files.writeString(filePath,writeContent);
            } catch (IOException e) {
                System.out.println("파일 작성 실패");
                e.printStackTrace();
            }
        }

        public static void delete(String file) {
            Path filePath=Paths.get(file);

            try {
                Files.delete(filePath);
            } catch (IOException e) {
                System.out.println("파일 삭제 실패");
                e.printStackTrace();
            }
        }


        public static void createDir(String dirPath) {
            Path DirPath=Paths.get(dirPath);
            try {
                Files.createDirectories(DirPath);
            } catch (IOException e) {
                System.out.println("디렉터리 생성 실패");
                e.printStackTrace();
            }
        }
    }

}
