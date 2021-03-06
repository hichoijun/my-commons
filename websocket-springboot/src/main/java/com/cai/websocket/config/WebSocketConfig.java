package com.cai.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 配置WebSocket,需要在配置类上使用@EnableWebSocketMessageBroker开启WebSocket支持
 * @EnableWebSocketMessageBroker注解同时会开启使用STOMP协议来传输基于代理（message broker）用的消息，
 * 这时控制器支持使用@MessageMapping，就像使用@RequestMapping一样。
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * 将"/hello"路径注册为STOMP端点，这个路径与发送和接收消息的目的路径有所不同，这是一个端点，客户端在订阅或发布消息到目的地址前，要连接该端点，
     * 即用户发送请求url="/applicationName/hello"与STOMP server进行连接。之后再转发到订阅url；
     * PS：端点的作用——客户端在订阅或发布消息到目的地址前，要连接该端点。
     * @param
     */
    public void registerStompEndpoints(StompEndpointRegistry registry){
        //注册一个STOMP的endpoint，并指定使用SockJs协议

//        registry.addEndpoint("/hello").withSockJS();

        registry.addEndpoint("/hello").setAllowedOrigins("*").withSockJS();


    }

    /**
     * 配置了一个简单的消息代理，如果不重载，默认情况下回自动配置一个简单的内存消息代理，用来处理以"/topic"为前缀的消息。这里重载configureMessageBroker()方法，
     * 消息代理将会处理前缀为"/topic"和"/queue"的消息。
     * @param
     */
    public void configureMessageBroker(MessageBrokerRegistry registry){

        registry.enableSimpleBroker("/topic", "/user");
        registry.setApplicationDestinationPrefixes("/app");
        registry.setUserDestinationPrefix("/user");

    }
}