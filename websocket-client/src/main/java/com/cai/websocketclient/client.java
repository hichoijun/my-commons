package com.cai.websocketclient;


import javax.websocket.*;

@ClientEndpoint()
public class client {

    @OnOpen
    public void onOpen(Session session) {

        System.out.println("Client onOpen");
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println("session.getId()=" + session.getId());
        System.out.println("Client onMessage: " + message);
    }

    @OnClose
    public void onClose() {

        System.out.println("Client onClose");

    }
}