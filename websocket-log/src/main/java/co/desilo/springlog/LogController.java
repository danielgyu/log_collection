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

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


@RestController
public class LogController {

    @Autowired
    SimpMessagingTemplate template;

    @PostMapping("/send")
    public void writeLog(@RequestBody LogMessage logMessage) throws IOException {
	String path = "/home/kungyu/Documents/log.log";
	
	File file = new File(path);
	FileWriter fr = null;

	try {
	    fr = new FileWriter(file, true);
	    fr.write(logMessage.getMessage());
	    fr.write(System.getProperty( "line.separator" ));
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		fr.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
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
