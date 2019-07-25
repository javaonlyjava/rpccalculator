package com.airwallex.app.queue;

import java.util.concurrent.BlockingQueue;

import com.airwallex.app.model.Message;
import com.airwallex.app.model.Operator;

public class CalculatingConsumer implements Runnable {

	protected BlockingQueue<Message> calculatingQueue;
	private Integer quit;
		

	public CalculatingConsumer(BlockingQueue<Message> calculatingQueue, Integer quit) {
		super();
		this.calculatingQueue = calculatingQueue;
		this.quit = quit;
	}


	
	@Override
	public void run() {
		try {
			while(true) {
				Message message = calculatingQueue.take();
				 if(message.getMessage().equals("Q")) {quit=1;break;}
				 processCalculatingQueue(message);
				
			}
           
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	}



	private void processCalculatingQueue(Message message) {
		System.out.println("on the stack" + message.getMessage());
		
	}

}
