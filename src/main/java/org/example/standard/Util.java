package org.example.standard;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {
    public static class File{
        public static void test(){
            System.out.println("파일 유틸 테스트");
        }


        public static void createFile(String file) {
            Path filepath=Paths.get(file);

            if(filepath.getParent() != null) {  //폴더가 없으면
                createDir(filepath.getParent().toString());
            }


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

        public static boolean delete(String file) {
            Path filePath=Paths.get(file);

            if(!Files.exists(filePath)) return false;

            try {
                Files.delete(filePath);
            } catch (IOException e) {
                System.out.println("파일 삭제 실패");
                e.printStackTrace();
            }

            return false;
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

        public static void deleteDir(String dirPath) {
            Path DirPath=Paths.get(dirPath);

            if(!Files.exists(DirPath)) return;

            try {
                Files.delete(DirPath);
            } catch (IOException e) {
                System.out.println("폴더 삭제 실패");
                e.printStackTrace();
            }
        }

        public static void deleteForce(String path) {
            Path folderPath = Paths.get(path);
            if(!Files.exists(folderPath)) return;
            try {
                // 디렉토리 및 내용 삭제
                Files.walkFileTree(folderPath, new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        // 파일 삭제
                        Files.delete(file);
                        System.out.println("파일 삭제됨: " + file);
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        // 디렉토리 삭제 (내부 파일 모두 삭제 후 호출됨)
                        Files.delete(dir);
                        System.out.println("디렉토리 삭제됨: " + dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
                System.out.println("폴더와 그 안의 내용이 성공적으로 삭제되었습니다.");
            } catch (IOException e) {
                System.err.println("폴더 삭제 중 오류 발생: " + e.getMessage());
            }
        }
        public static List<Path> getPaths(String dirPathStr) {

            Path dirPath = Paths.get(dirPathStr);

            try {
                return Files.walk(dirPath)
                        .filter(Files::isRegularFile)
                        .toList();

            } catch (Exception e) {
                System.out.println("파일 목록 가져오기 실패");
                e.printStackTrace();
            }

            return List.of();
        }
    }
        public static class Json{

        //map을 Json으로 변환
        public static String mapToJson(Map<String, Object> map) {

            StringBuilder jsonBuilder = new StringBuilder();

            jsonBuilder.append("{\n");

            String str = map.keySet().stream()
                    .map(k -> map.get(k) instanceof String
                            ? "    \"%s\" : \"%s\"".formatted(k, map.get(k))
                            : "    \"%s\" : %s".formatted(k, map.get(k))
                    ).collect(Collectors.joining(",\n"));

            jsonBuilder.append(str);
            jsonBuilder.append("\n}");

            return jsonBuilder.toString();
        }

        public static void writeAsMap(String filePath, Map<String, Object> wiseSayingMap) {
            String jsonStr = mapToJson(wiseSayingMap);
            File.write(filePath, jsonStr);
        }

        public static Map<String, Object> readAsMap(String filePath) {
            String jsonStr = File.readAsString(filePath);
            return jsonToMap(jsonStr);
        }

        public static Map<String, Object> jsonToMap(String jsonStr) {

//            String jsonStr = """
//
//                    "id" : 1,
//                    "content" : "aaa",
//                    "author" : "bbb"
//
//                """;

            Map<String, Object> resultMap = new LinkedHashMap<>();

            jsonStr = jsonStr.replaceAll("\\{", "")
                    .replaceAll("}", "")
                    .replaceAll("\n", "")
                    .replaceAll(" : ", ":");

            Arrays.stream(jsonStr.split(",")) // ["id" : 1, "content" : "aaa", "author" : "bbb"]
                    .map(p -> p.trim().split(":")) //  p => [""id" : 1"]
                    .forEach(p -> { // p => ["id", 1]
                        String key = p[0].replaceAll("\"", "");
                        String value = p[1];

                        if(value.startsWith("\"")) {
                            resultMap.put(key, value.replaceAll("\"", ""));
                        } else if(value.contains(".")) {
                            resultMap.put(key, Double.parseDouble(value));
                        } else if(value.equals("true") || value.equals("false")) {
                            resultMap.put(key, Boolean.parseBoolean(value));
                        } else {
                            resultMap.put(key, Integer.parseInt(value));
                        }
                    });

            return resultMap;
        }
    }
}
