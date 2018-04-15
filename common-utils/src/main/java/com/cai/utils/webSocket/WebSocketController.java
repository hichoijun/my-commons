package com.cai.utils.webSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WebSocketController {

    @Autowired
    private WebSocketService ws;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/chat")
    //在springmvc 中可以直接获得principal,principal 中包含当前用户的信息
    public void handleChat(Principal principal, Message message) {

        /**
         * 此处是一段硬编码。如果发送人是wyf 则发送给 wisely 如果发送人是wisely 就发送给 wyf。
         */
        if (principal.getName().equals("wyf")) {
            //通过convertAndSendToUser 向用户发送信息,
            // 第一个参数是接收消息的用户,第二个参数是浏览器订阅的地址,第三个参数是消息本身

            messagingTemplate.convertAndSendToUser("wisely",
                    "/queue/notifications", principal.getName() + "-send:"
                            + message.getName());
        } else {
            messagingTemplate.convertAndSendToUser("wyf",
                    "/queue/notifications", principal.getName() + "-send:"
                            + message.getName());
        }
    }


    //http://localhost:8080/Welcome1
    @RequestMapping("/begin")
    @ResponseBody
    public String say2()throws Exception
    {
        ws.sendMessage();
        return "is ok";
    }


    @MessageMapping("/welcome")//浏览器发送请求通过@messageMapping 映射/welcome 这个地址。
    @SendTo("/topic/getResponse")//服务器端有消息时,会订阅@SendTo 中的路径的浏览器发送消息。
    public Response say(Message message) throws Exception {
        Thread.sleep(1000);
        return new Response("Welcome, " + message.getName() + "!");
    }

}
