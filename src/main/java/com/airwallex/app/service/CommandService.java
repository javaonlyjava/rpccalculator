package com.airwallex.app.service;

import java.io.BufferedReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.stereotype.Component;

import com.airwallex.app.model.Message;
import com.airwallex.app.queue.CalculatingConsumer;
import com.airwallex.app.queue.Producer;

@Component
public class CommandService {

	public void execute(BufferedReader in, Integer quit) {
		try {
	    	BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(1024);

	        Producer producer = new Producer(queue, in, quit);
	        CalculatingConsumer consumer = new CalculatingConsumer(queue, quit);

	        new Thread(producer).start();
	        new Thread(consumer).start();

	        
			Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	

}
