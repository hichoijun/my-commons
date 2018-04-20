package com.cai.websocketclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

/**
 * @date 2018/4/1917:40
 * @author caijun
 * @Description: ${todo}
*/
public class wsMain {


//    private static String uri = "ws://localhost:9090/websocket/api/test/123";
//    private static String uri = "ws://10.50.8.21:8080/v1/hoststats?token=eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJjYXR0bGUiLCJyZXNvdXJjZUlkIjoiMWgxIiwiaG9zdFV1aWQiOiI4Njk0NzMwYi1iMTcyLTRkNWMtNGFmOS00ZTQwYjRlNDk2MDAiLCJraWQiOiJkZWZhdWx0IiwiaXNzIjoiaHR0cDpcL1wvY2F0dGxlLmlvIiwiZXhwIjoxNTI0MTMxNTI5LCJpYXQiOjE1MjQxMzEyMjl9.lZrxMdKHzeYBqJSn67vMlhTVWpxI2Z_S0LoZqbuj_15Z6NU0VFpCp2T7FSGvdxzlK8vpDFafl_qN6UcG7gBHYN9sbuY3bBt5amq7QWIp8AwaUm9h7TgFTr8zuQV9Y_3K43lk1lAatjAPqrk6bC_hCh9yCan9mm8Nhp9BNov-3kfzOuCSZu2iNSTUTHb6E5O9pBlIoH7VnBZ77JI1iBLMzfcZAhNQiHIDupArUc4vxaSnOZhMXyxDgrBeIHJTD1waGR9bTjUyKJ0_l4hbHC2ykrwGxaMUiwlTOoFEEHIC7peAsVUovwP2f81qjo9vKTkIvqDPA4RvrdWbRu3X8Yq_LQ&sockId=3";
    private static Session session;
    private void start(String uri) {
        WebSocketContainer container = null;
        try {
            container = ContainerProvider.getWebSocketContainer();
        } catch (Exception ex) {
            System.out.println("error" + ex);
        }
        try {
            URI r = URI.create(uri);
            session = container.connectToServer(client.class, r);

            System.out.println("session==" + session.getId());

//            session.getBasicRemote().sendText("javaclient");
        } catch (DeploymentException | IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        String token = getToken();

        String uri2 = "ws://10.50.8.21:8080/v1/hoststats?token=" + token + "&sockId=" + getRandom();

        System.out.println("uri2=" + uri2);

        wsMain client = new wsMain();
        client.start(uri2);


        for(int i=0; i<120; i++){


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("1=" + session.isOpen());

            if(i==100){
                try {
                    session.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("2=" + session.isOpen());



        }




//        while(true){
//            try {
//                session.getBasicRemote().sendText("javaclient");
//
//                Thread.sleep(1000);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = "";
//        try {
//            do {
//                input = br.readLine();
//                if (!input.equals("exit"))
//                    client.session.getBasicRemote().sendText("javaclient"+input);
//            } while (!input.equals("exit"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }



    static String getToken(){

        String url = "http://10.50.8.21:8080/v2-beta/projects/1a7/hosts/1h1/hoststats";

        String tokenResult = httpclientUtil.doGet(url);

        System.out.println(tokenResult);
        JSONObject jo = JSON.parseObject(tokenResult);
        String token = jo.getString("token");
        System.out.println(token);

        return token;
    }


    static int getRandom(){
        return (int)(Math.random()*100+1);
    }


}