package jms.example.publisher;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.testng.annotations.Test;

import base.TestWithMockito;

public class JmsMessageSenderTest extends TestWithMockito {

	@Mock
	private JmsTemplate jmsTemplate;
	
	@InjectMocks
	private JmsMessageSender testSubject;
	
	@Test
	public void shouldSendAMessageToDefaultDestination() {
		//given
		String message = "This is a message";
		
		//when
		testSubject.send(message);
		
		//then
		verify(jmsTemplate, times(1)).send(any(MessageCreator.class));
	}

	@Test
	public void sendDestinationString() {
	}

	@Test
	public void sendText() {
	}
}
