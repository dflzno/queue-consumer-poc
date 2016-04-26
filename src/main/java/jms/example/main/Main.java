package jms.example.main;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jms.example.broker.MessageBroker;
import jms.example.publisher.JmsMessageSender;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// init spring context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");

		MessageBroker broker = new MessageBroker();
		broker.start();
		
		// get bean from context
		JmsMessageSender jmsMessageSender = (JmsMessageSender) ctx.getBean("jmsMessageSender");

		// send to default destination
		jmsMessageSender.send("Message Payload");

		// send to a code specified destination
		Queue queue = new ActiveMQQueue("AnotherDest");
		jmsMessageSender.send(queue, "Another Message Payload");
		
		wait(5);
		
		// close spring application context
		((ClassPathXmlApplicationContext) ctx).close();
		
		broker.stop();
	}
	
	private static void wait(int secs) throws InterruptedException {
		Thread.sleep(secs * 1000);
	}

}