package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner =new Scanner("등록\n현재를 사랑하라\n작자미상\n");
        String val1= scanner.nextLine();
        System.out.println("명령\n=================================\n"+ val1);   //aaa

        String val2= scanner.nextLine();
        System.out.println("명언: "+val2);   //bbb

        String val3= scanner.nextLine();
        System.out.println("작가: "+val3);   //bbb
    }
}