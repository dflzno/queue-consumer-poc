package jms.example.publisher;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.TestWithMockito;
import jms.example.publisher.messagecreators.TextMessageCreator;

public class JmsMessageSenderTest extends TestWithMockito {

	@Mock
	private JmsTemplate jmsTemplate;

	@InjectMocks
	private JmsMessageSender testSubject;
	
	/**
	 * Resets the testSubject as a regular Java Object (by using new) because such class makes use of both Mockito doubles and real dependencies,
	 * so the real ones won't be auto-resetted by the MockitoAnnotations.initMocks(...) feature. Fuck you TestNG!
	 */
	@AfterMethod
	public void resetTestSubject() {
		testSubject = new JmsMessageSender();
	}

	@Test
	public void shouldSendAMessageToDefaultDestination() {
		// given
		String message = defaultMessage();

		// when
		testSubject.send(message);

		// then
		verify(jmsTemplate, times(1)).send(any(MessageCreator.class));
	}
	
	@Test
	public void shouldMakeUseOfAGivenMessageCreator() {
		// given
		String message = defaultMessage();
		MessageCreator messageCreator = new TextMessageCreator.Builder(message).build();
		testSubject.setMessageCreator(messageCreator);
		
		// when
		testSubject.send(message);
		
		// then
		verify(jmsTemplate, times(1)).send(messageCreator);
	}

	@Test
	public void shouldSendText() {
		String message = defaultMessage();

		// when
		testSubject.sendText(message);

		// then
		verify(jmsTemplate, times(1)).convertAndSend(message);
	}

	@Test
	public void shouldSendMessageToNonDefaultDestination() {
		// given
		Queue destination = new ActiveMQQueue("NonDefaultDestinationQueue");
		String message = defaultMessage();
		
		// when
		testSubject.send(destination, message);

		// then
		verify(jmsTemplate, times(1)).send(eq(destination), any(MessageCreator.class));
	}
		
	private String defaultMessage() {
		return "This is a default message";
	}
}
