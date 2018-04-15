package com.cai.utils.test;

import com.cai.utils.http.httpclientUtil;

import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) {

        f2();
        

    }

    private static void f2() {
        String url = "http://localhost:8001/hi";


        Map<String, String> map = new HashMap<String, String>();
        map.put("param1", "123");
        String ret = httpclientUtil.doPost(url, map);
        System.out.println(ret);

    }

    private static void f1() {
        String url = "http://localhost:8001/hi";
        String ret = httpclientUtil.doGet(url);
        System.out.println(ret);
    }
}
