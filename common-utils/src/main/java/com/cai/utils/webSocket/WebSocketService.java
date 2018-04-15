package com.cai.utils.webSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void sendMessage() throws Exception{
        for(int i=0;i<10;i++)
        {
            Thread.sleep(1500);
            template.convertAndSend("/topic/getResponse",new Response("Welcome,websocket!"+i));
            System.out.println("----------------------send"+i);
        }
    }
}
