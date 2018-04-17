package com.cai.websocketspring.web;

import com.cai.websocketspring.config.MyWebSocket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

  @Value("${server.port}")
  private String port;

  @GetMapping("/hi")
  public String hi() {
    MyWebSocket ws = new MyWebSocket();
    try {
      ws.sendMessage(System.currentTimeMillis() + "");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "ok";
  }


}
