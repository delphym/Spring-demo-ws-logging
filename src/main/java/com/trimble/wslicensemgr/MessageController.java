package com.trimble.wslicensemgr;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	private final static AtomicLong counter = new AtomicLong();
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST, path = "/log-user-action")
	public Message logMessage(@RequestBody() Message model) {
		
		try {
			switch (model.getLevel()) {
			case "INFO":
				log.info(model.toString4Log());
				break;
			case "WARN":
				log.warn(model.toString4Log());
				break;
			case "ERROR":
				log.error(model.toString());
				break;

			default:
				log.debug(model.toString4Log());
				break;
			}		
		} catch (NullPointerException e) {
			throw new InvalidMessageRequestException(e.getMessage());
		}
		
		return new Message(counter.incrementAndGet(), model.getApp(), model.getLevel(), model.getMessage());
	}
}
