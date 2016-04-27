package jms.example.publisher.messagecreators;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.testng.annotations.Test;

public class TextMessageCreatorTest {
	
	private Session session = mock(Session.class);
	
	private TextMessageCreator testSubject;

	@Test
	public void shouldReturnAMessage() throws JMSException {
		//given
		TextMessageCreator.Builder builder = getBaseBuilder("MessagePayload");
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
		
		TextMessageCreator.Builder builder = getBaseBuilder("Message Payload");
		builder.withReplyTo(replyTo);
		testSubject = builder.build();
		
		when(session.createTextMessage(anyString())).thenReturn(new ActiveMQTextMessage());
		
		//when
		Message message = testSubject.createMessage(session);
		
		//then
		assertEquals(message.getJMSReplyTo(), replyTo);
	}
	
	private TextMessageCreator.Builder getBaseBuilder(String text) {
		return new TextMessageCreator.Builder(text);
	}
}
