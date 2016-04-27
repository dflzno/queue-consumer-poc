package jms.example.publisher.messagecreators;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

public class TextMessageCreator implements MessageCreator {
	
	private String text;
	private Destination replyTo;

	private TextMessageCreator(Builder builder) {
		this.text = builder.text;
		this.replyTo = builder.replyTo;
	}

	@Override
	public Message createMessage(Session session) throws JMSException {
		Message message = session.createTextMessage(text);
		message.setJMSReplyTo(replyTo);
		return message;
	}
	
	public static class Builder {

		private String text;
		private Destination replyTo;
		
		public Builder(String text) {
			this.text = text;
		}

		public TextMessageCreator build() {
			return new TextMessageCreator(this);
		}

		public Builder withReplyTo(Destination replyTo) {
			this.replyTo = replyTo;
			return this;
		}
		
	}
}
