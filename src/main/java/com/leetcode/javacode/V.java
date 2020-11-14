package com.leetcode.javacode;

import java.util.Random;

public class V {

    public V(){
        VALUE_3 = 39;
    }

    static Random rand = new Random();
    private final int VALUE_1 = 9;
    private final static int VALUE_2 = 10;
    private final int VALUE_3;
    private final Test test1 = new Test();
    private Test test2 = new Test();
    private final int[] a = {1,2,3,4,5,6};
    private final int i4 = rand.nextInt(20);
    private final static int i5 = rand.nextInt(20);
    public  String toString(){
        return i4 + " " + i5;
    }

    public String method1(final int[] a){
//        a = new int[] {1,2,3};
        return a.toString();

    }

    public static void main(String[] args) {
        V date = new V();
//        date.test1 = new Test();
//        date.VALUE_1 = 100;
//        date.VALUE_2 ++;
        date.test2 = new Test();
        for(int i = 0; i< date.a.length; i++) {
            date.a[i] = 9;
        }

        for(int i : date.a){
            System.out.println(i);
        }

        int[] a = new int[]{1,2,3};

    }



}

class Test {
    int i = 0;
}