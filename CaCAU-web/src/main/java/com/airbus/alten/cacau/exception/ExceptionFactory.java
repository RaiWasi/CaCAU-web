package com.airbus.alten.cacau.exception;

import java.text.MessageFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionFactory {

	private static Logger LOGGER = LogManager.getLogger(DefaultExceptionHandler.class.getName());

	public static ApplicationSpecificException create(final Throwable cause, final ExceptionType exceptionType,final Object... messageArguments) {
		LOGGER.error(MessageFormat.format(exceptionType.getMessage(), messageArguments), exceptionType);
		return new ApplicationSpecificException(exceptionType, cause, messageArguments);
	}

	public static ApplicationSpecificException create(final ExceptionType exceptionType,final Object... messageArguments) {
		LOGGER.error(MessageFormat.format(exceptionType.getMessage(), messageArguments, exceptionType));
		return new ApplicationSpecificException(exceptionType, messageArguments);
	}
}
