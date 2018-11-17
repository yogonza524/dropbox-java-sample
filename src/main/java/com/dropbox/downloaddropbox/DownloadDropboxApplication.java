package com.dropbox.downloaddropbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dropbox"})
public class DownloadDropboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(DownloadDropboxApplication.class, args);
	}
}
