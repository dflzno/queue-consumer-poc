package jms.weatherqueue.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PingController {
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public ResponseEntity<String> ping() {
		log.error("Logging with error!");
		log.debug("Logging with debug!");
		log.info("Logging with info!");
		return new ResponseEntity<String>("Ping successful!", HttpStatus.OK);
	}

}
