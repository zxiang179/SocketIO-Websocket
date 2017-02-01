package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by sang on 16-12-22.
 */
@Controller
public class WsController {

    @Autowired
    PersonRepository personRepository;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage("welcome," + message.getName() + " !");
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("sang")) {
            Person person=personRepository.findByName("zx");
            messagingTemplate.convertAndSendToUser("lenve", "/queue/notifications", person.getName() + "给您发来了消息：" + msg);
        }else{
            Person person=personRepository.findByName("xc");
            messagingTemplate.convertAndSendToUser("sang", "/queue/notifications", person.getName() + "给您发来了消息：" + msg);
        }
    }

}
