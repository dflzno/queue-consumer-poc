package jms.weatherqueue.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public HttpStatus provideExampleData() {
		return HttpStatus.OK;
	}

}
