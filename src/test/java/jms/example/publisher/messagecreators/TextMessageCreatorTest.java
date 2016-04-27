package jms.example.publisher.messagecreators;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotNull;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.testng.annotations.Test;

public class TextMessageCreatorTest {
	
	private Session session = mock(Session.class);
	
	private TextMessageCreator testSubject;

	@Test
	public void shouldReturnAMessage() throws JMSException {
		//given
		TextMessageCreator.Builder builder = getBaseBuilder("MessagePayload");
		testSubject = builder.build();
		when(session.createTextMessage(anyString())).thenReturn(mock(TextMessage.class));
		
		//when
		Message message = testSubject.createMessage(session);
		
		//then
		assertNotNull(message);
	}
	
	@Test
	public void shouldCreateAMessageAWithGivenJMSReplyTo() {
		//given
		TextMessageCreator.Builder builder = getBaseBuilder("Message Payload");
		
		//when
		testSubject = builder.build();
		
		//then
		//assert
	}
	
	private TextMessageCreator.Builder getBaseBuilder(String text) {
		return new TextMessageCreator.Builder(text);
	}
}
