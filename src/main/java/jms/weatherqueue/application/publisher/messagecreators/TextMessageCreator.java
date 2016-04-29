package jms.weatherqueue.application.publisher.messagecreators;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

/**
 * Instances of this class must be created through it's companion builder
 * {@link jms.example.application.publisher.messagecreators.TextMessageCreator.Builder}
 */
public class TextMessageCreator implements MessageCreator {
	
	private String text;
	private Destination replyTo;

	private TextMessageCreator(Builder builder) {
		this.text = builder.text;
		this.replyTo = builder.replyTo;
	}

	/* (non-Javadoc)
	 * @see org.springframework.jms.core.MessageCreator#createMessage(javax.jms.Session)
	 */
	@Override
	public Message createMessage(Session session) throws JMSException {
		Message message = session.createTextMessage(text);
		message.setJMSReplyTo(replyTo);
		return message;
	}
	
	/**
	 * Companion Builder for the TextMessageCreator enclosing class
	 */
	public static class Builder {

		private String text;
		
		private Destination replyTo;
		
		public Builder(String text) {
			this.text = text;
		}

		/**
		 * Creates a new TextMessageCreator object 
		 * @return a new TextMessageCreator object
		 */
		public TextMessageCreator build() {
			return new TextMessageCreator(this);
		}

		public Builder withReplyTo(Destination replyTo) {
			this.replyTo = replyTo;
			return this;
		}
		
	}
}
