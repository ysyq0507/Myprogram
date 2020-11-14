package com.leetcode.javacode;

public class OuterAndInner {
    private int i = 0;
    private String abc = "abc";
    Inner inner = new Inner();

    private class Inner{
        public int j =i;
        public String reString(){
            return abc;
        }
    }

    public static void main(String[] args) {
        OuterAndInner outerAndInner = new OuterAndInner();
        OuterAndInner.Inner  inner = outerAndInner.new Inner();
        System.out.println(inner.reString());
    }
}
