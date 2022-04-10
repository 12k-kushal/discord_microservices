package com.nk.message.services;

//public class sendMessage {
//
//}


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class sendMessage extends TextWebSocketHandler{ // implements EchoProxyService 

    public static List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

//    @Override
    public String echo(String message) {
        System.out.println(message);
        System.out.print(sessions);




        for(WebSocketSession webSocketSession : sessions) {
            try {
                webSocketSession.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "error";
            }
        }
        return "result";
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //the messages will be broadcasted to all users.
        System.out.print("adding session");
        sessions.add(session);
    }
}