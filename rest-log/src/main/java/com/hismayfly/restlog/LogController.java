package com.hismayfly.restlog;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@RestController
public class LogController {

    @Autowired
    // LogFile file;
    private LogRepository repository;

    @PostMapping("/log")
    public void writeLog(@RequestBody LogMessage logMessage) throws IOException {
	repository.save(logMessage);

	/* save log in file
	System.out.println("file: " + file);
	file.write(logMessage.getMessage());
	file.write(System.getProperty( "line.separator" ));
	*/
    }
}
