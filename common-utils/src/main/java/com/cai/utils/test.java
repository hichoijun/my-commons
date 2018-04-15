package com.cai.utils;

public class test {

    public static void main(String[] args) {

        f1();
        

    }

    private static void f1() {
        String url = "http://localhost:8001/hi";
        String ret = httpclientUtil.doGet(url);
        System.out.println(ret);
    }
}
