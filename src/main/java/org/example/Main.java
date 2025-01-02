package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        test2();
    }
    public static void test1() {

        Scanner scanner =new Scanner("등록\n현재를 사랑하라\n작자미상\n");
        String val1= scanner.nextLine();
        System.out.println("명령\n=================================\n"+ val1);   //aaa

        String val2= scanner.nextLine();
        System.out.println("명언: "+val2);   //bbb

        String val3= scanner.nextLine();
        System.out.println("작가: "+val3);   //bbb

        TestApp app=new TestApp();
        app.run();
    }
    public static void test2() {
        //origin: 모니터 화면
        PrintStream origin=System.out;

        //비어있는 스트림
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));  // out방향을 스트림으로
        System.out.println("hello");    //출력 x, 스트림으로 나감

        System.setOut(origin);  // out방향을 콘솔로 다시 설정
        String str=byteArrayOutputStream.toString();
        System.out.println(str);    //출력 o
    }


}