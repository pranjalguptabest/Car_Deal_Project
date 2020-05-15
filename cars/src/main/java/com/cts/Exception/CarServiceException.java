package com.cts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CarServiceException extends RuntimeException
{
	public CarServiceException(String string)
	{
		super(string);
	}
}