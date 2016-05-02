package jms.weatherqueue.application.messagepublication;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import jms.weatherqueue.application.messagepublication.messagecreators.TextMessageCreator;

/**
 * Class in charge of sending messages to a JMS Queue
 */
@Service
public class JmsMessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	private MessageCreator messageCreator;

	/**
	 * Reconfigures the JmsMessageSender with a client-specific MessageCreator. This class uses a 
	 * {@link jms.weatherqueue.application.messagepublication.messagecreators.TextMessageCreator} as a default MessageCreator
	 * @param messageCreator
	 */
	public void setMessageCreator(MessageCreator messageCreator) {
		this.messageCreator = messageCreator;
	}

	/**
	 * Send text to default destination
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
		this.jmsTemplate.send(dest, getMessageCreator(text));
	}
	
	/**
	 * 
	 * @param text
	 * @return
	 */
	private MessageCreator getMessageCreator(String text) {
		return messageCreator != null ? messageCreator : new TextMessageCreator.Builder(text).build();
	}
	
}
