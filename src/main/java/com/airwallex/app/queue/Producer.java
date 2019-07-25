package com.airwallex.app.queue;

import java.io.BufferedReader;
import java.util.concurrent.BlockingQueue;

import com.airwallex.app.model.Message;

public class Producer implements Runnable {
	
	protected BlockingQueue<Message> queue;
	private BufferedReader in;
	private Integer quit;
	
	

	public Producer(BlockingQueue<Message> queue, BufferedReader in, Integer quit) {
		super();
		this.queue = queue;
		this.in = in;
		this.quit = quit;
	}


	@Override
	public void run() {
		String msg = null;
		 try {
		        while(true){
		            try{
		            	msg=in.readLine();
		            }catch(Exception e){}
		             
		            if(msg.equals("Q")) {quit=1;break;}
		            queue.put(new Message(msg));
		        }
			  
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		
	}
	
	

}
