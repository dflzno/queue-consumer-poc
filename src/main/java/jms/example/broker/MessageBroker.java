package jms.example.broker;

import org.apache.activemq.broker.BrokerService;

public class MessageBroker {

	private BrokerService broker;
	
	public MessageBroker() {
		broker = new BrokerService();
		broker.setPersistent(false);
		try {
			broker.addConnector("tcp://localhost:61616");
		} catch (Exception e) {
			e.printStackTrace();
			broker = null;
		}
	}
	
	public void start() throws Exception {
		if(broker == null) {
			throw new IllegalStateException();
		}
		
		broker.start();
	}
	
	public void stop() throws Exception {
		if(broker == null) {
			throw new IllegalStateException();
		}
		
		broker.stop();
	}
}
