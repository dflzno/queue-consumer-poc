package jms.example.publisher.messagecreators;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.MessageCreator;

public class TextMessageCreator implements MessageCreator {
	
	private String text;

	private TextMessageCreator(Builder builder) {
		this.text = builder.text;
	}

	@Override
	public Message createMessage(Session session) throws JMSException {
		Message message = session.createTextMessage(text);
		message.setJMSReplyTo(new ActiveMQQueue("Recv2Send"));
		return message;
	}
	
	public static class Builder {

		private String text;
		
		public Builder(String text) {
			this.text = text;
		}

		public TextMessageCreator build() {
			return new TextMessageCreator(this);
		}

		
	}
}
