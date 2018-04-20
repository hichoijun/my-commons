package com.cai.websocketclient;

import javax.websocket.Session;
import java.io.IOException;

/**
 * @date 2018/4/1919:01
 * @author caijun
 * @Description: ${todo}
*/
public class wsMain2 {


    private static Session session;

    public static void main(String[] args) {


        try {

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}