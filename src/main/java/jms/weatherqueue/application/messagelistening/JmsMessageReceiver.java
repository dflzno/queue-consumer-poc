package jms.weatherqueue.application.messagelistening;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JmsMessageReceiver implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
            try {
                log.debug("Message received: " + ((TextMessage) message).getText());
            } catch (JMSException ex) {
            	log.error("An error ocurred while casting the message:", ex);
            }
        }
        else {
        	log.error("Message must be of type TextMessage");
        }		
	}

}
