package io.adrian.wsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 测试用发送消息
     * @param msg 消息内容
     * @param id 长任务ID
     * @return
     */
    @RequestMapping("/testSend")
    @ResponseBody
    public Greeting send(@RequestParam String msg, @RequestParam String id) {
        Greeting greeting = new Greeting("Hello, " + msg + "!");
        // 推送消息，id：LongJob的ID     greeting：消息内容对象
        template.convertAndSendToUser(id, "/message", greeting);
        return greeting;
    }

    @MessageMapping("/message")
    @SendToUser("/message")
    public Greeting userMessage(HelloMessage message) throws Exception {
        System.err.println("Job: " + message.getName());
        return new Greeting("Job: " + message.getName());
    }
}