package com.leetcode.javacode;

interface OutInterfacce{
    public void f();
}
public class InterfaceInner {
    public String k = "";

    public OutInterfacce doit2(){
        return new OutInterfacce() {
            public int j  = 0;
            public void f() {
                System.out.println("匿名内部类");
            }
        };
    }

    public void test(String s){
        int j = 0;
        class inner{
            inner(String x){
                x = k;
            }
        }
    }
    public static void main(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        OutInterfacce outInterfacce = outerClass2.doit();
        outInterfacce.f();
    }
}

class OuterClass2{
    private int i = 9;
    private class InnerClass implements OutInterfacce{
        private int i = 10;
        public void f(){
            System.out.println("内部类f（）方法");
            this.i = 19;
            OuterClass2.this.i = 20;
        }
        public InnerClass(String s) {
            System.out.println(s);
        }
    }

    public OutInterfacce doit (){
        return new InnerClass("内部类构造方法");
    }



}
