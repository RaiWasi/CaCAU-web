package com.airbus.alten.cacau.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice("com.airbus.alten.cacau")
@SuppressWarnings("WeakerAccess")
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

	private static Logger LOGGER = LogManager.getLogger(DefaultExceptionHandler.class.getName());

	private final MessageSourceAccessor messageSource;

	@Autowired
	public DefaultExceptionHandler(MessageSourceAccessor messageSource) {
		Assert.notNull(messageSource, "messageSource must not be null");
		this.messageSource = messageSource;
	}

	@ExceptionHandler(ApplicationSpecificException.class)
    public ResponseEntity<Object> handleApplicationSpecificException(ApplicationSpecificException ex) {
		LOGGER.error(ex);
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex) {
		
		LOGGER.error(ex);
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
