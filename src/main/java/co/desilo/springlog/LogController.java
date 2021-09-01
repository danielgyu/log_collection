package co.desilo.springlog;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.io.IOException;


@RestController
public class LogController {

    @Autowired
    SimpMessagingTemplate template;

    // TODO
    @PostMapping("/send")
    public void writeLog(@RequestBody LogMessage logMessage) throws IOException {
	String path = "/home/ubuntu/practice/log";
	BufferedWriter writer = new BufferedWriter(new FileWriter(path));
    }

    /* Using SockJS
    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody LogMessage logMessage) {
	template.convertAndSend("/topic/message", logMessage);
	return new ResponseEntity<>(HttpStatus.OK);
    }
    */

    @MessageMapping("/sendMessage")
    public void receiveMessage(@Payload LogMessage logMessage) {
    }

    @SendTo("/topic/message")
    public LogMessage broadcastMessage(@Payload LogMessage logMessage) {
	return logMessage;
    }
}
