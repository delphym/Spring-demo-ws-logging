package com.trimble.wslicensemgr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//More on handling BadRequests at:
//https://www.springboottutorial.com/spring-boot-exception-handling-for-rest-services

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidMessageRequestException extends RuntimeException {

	public InvalidMessageRequestException(String exception) {
		super(exception);
	}
}
