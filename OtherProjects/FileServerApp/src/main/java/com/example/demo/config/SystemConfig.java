package com.example.demo.config;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {
private String classPath;
public String getClassPath() {
	return classPath;
}
public void setClassPath(String classPath) {
	this.classPath = classPath;
}
public String getUploadPath() {
	return uploadPath;
}
public void setUploadPath(String uploadPath) {
	this.uploadPath = uploadPath;
}


public String getmovieDir() {
	return movieDir;
}
public void setmovieDir(String movieDir) {
	this.movieDir = movieDir;
}

@Value("${file.uploadFile}")
private String uploadPath;

@Value("${movie.dir}")
private String movieDir;
}