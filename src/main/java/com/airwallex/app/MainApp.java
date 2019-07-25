package com.airwallex.app;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import com.airwallex.app.queue.Producer;
import com.airwallex.app.service.CommandService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.Banner;

@ComponentScan("com.airwallex.app")
@SpringBootApplication
public class MainApp implements CommandLineRunner
{
	
	@Autowired
	CommandService commandService;
	
	Integer quit = new Integer(0);
	
    public static void main(String[] args ) 
    {
    	SpringApplication app = new SpringApplication(MainApp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    	
    }

	@Override
	public void run(String... args) throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			commandService.execute(in, quit);
			if (quit==1) break;
			
		}
		System.out.println("BYE");
	}
}
