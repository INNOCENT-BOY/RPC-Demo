package com.xhk.Client;


public class Client {
    public static void main(String[] args) throws Exception {
        ComputorLocal computer = new ComputorLocal();
        int a = 5;
        int b = 6;
        int ret = computer.add(a, b);
        System.out.printf("%d + %d = %d\n", a, b, ret);
    }
}
