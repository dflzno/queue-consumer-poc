package jms.weatherqueue.application.messagepublication.messagecreators;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.testng.annotations.Test;

import jms.weatherqueue.application.messagepublication.messagecreators.TextMessageCreator;

public class TextMessageCreatorTest {
	
	private Session session = mock(Session.class);
	
	private TextMessageCreator testSubject;

	@Test
	public void shouldReturnAMessage() throws JMSException {
		//given
		TextMessageCreator.Builder builder = getBaseBuilder();
		testSubject = builder.build();
		
		when(session.createTextMessage(anyString())).thenReturn(new ActiveMQTextMessage());
		
		//when
		Message message = testSubject.createMessage(session);
		
		//then
		assertNotNull(message);
	}
	
	@Test
	public void shouldCreateAMessageAWithGivenJMSReplyTo() throws JMSException {
		//given
		Destination replyTo = new ActiveMQQueue("ReplyToAnyQueue");
		
		TextMessageCreator.Builder builder = getBaseBuilder();
		builder.withReplyTo(replyTo);
		testSubject = builder.build();
		
		when(session.createTextMessage(anyString())).thenReturn(new ActiveMQTextMessage());
		
		//when
		Message message = testSubject.createMessage(session);
		
		//then
		assertEquals(message.getJMSReplyTo(), replyTo);
	}
	
	@Test
	public void shouldCreateAMessageWithNoReplyToAttribute() throws JMSException {
		//given
		TextMessageCreator.Builder builder = getBaseBuilder();
		testSubject = builder.build();
		
		when(session.createTextMessage(anyString())).thenReturn(new ActiveMQTextMessage());
		
		//when
		Message message = testSubject.createMessage(session);
		
		//then
		assertNull(message.getJMSReplyTo());
	}
	
	private TextMessageCreator.Builder getBaseBuilder() {
		return new TextMessageCreator.Builder("Message Payload");
	}
}
