package com.hismayfly.restlog;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class LogMessage {

    @Id
    private String id;
    private String message;

    public LogMessage() {}
    
    public LogMessage(String message) {
	this.message = message;
    }

    public String getMessage() {
	return this.message;
    }

    public void setMessage(String message) {
	this.message = message;
    }
}

