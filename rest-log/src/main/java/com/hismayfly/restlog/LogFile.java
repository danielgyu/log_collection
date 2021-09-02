package com.hismayfly.restlog;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class LogFile {

    private final String path = "/home/kungyu/Documents/log.log";
    private FileWriter fileWriter;

    public FileWriter getFileWriter() {
	return this.fileWriter;
    }

    public void setFileWriter() throws IOException {
	System.out.println("setting file writer");
	FileWriter fr = new FileWriter(new File(path), true);
	this.fileWriter = fr;
    }

    public void write(String message) throws IOException {
	this.fileWriter.write(message);
    }
     
}
