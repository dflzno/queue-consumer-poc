package jms.example.publisher;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import jms.example.publisher.messagecreators.TextMessageCreator;

@Service
public class JmsMessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	private MessageCreator messageCreator;
	
	public JmsMessageSender() {
	}
	
	public JmsMessageSender(MessageCreator messageCreator) {
		this.messageCreator = messageCreator;
	}

	/**
	 * send text to default destination
	 * 
	 * @param text
	 */
	public void send(final String text) {
		this.jmsTemplate.send(getMessageCreator(text));
	}

	/**
	 * Simplify the send by using convertAndSend
	 * 
	 * @param text
	 */
	public void sendText(final String text) {
		this.jmsTemplate.convertAndSend(text);
	}

	/**
	 * Send text message to a specified destination
	 * 
	 * @param text
	 */
	public void send(final Destination dest, final String text) {

		this.jmsTemplate.send(dest, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage(text);
				return message;
			}
		});
	}
	
	private MessageCreator getMessageCreator(String text) {
		return messageCreator;		
	}
	
//	public Message createMessage(Session session) throws JMSException {
//		Message message = session.createTextMessage(text);
//		message.setJMSReplyTo(new ActiveMQQueue("Recv2Send"));
//		return message;
//	}
	
}
