package com.github.boyundefeated.akiraexcel.exception;

/**
 * Created by duynh5 on 14/03/2019
 */
public class AkiraExcelException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AkiraExcelException(String message) {
		super(message);
	}

	public AkiraExcelException(String message, Throwable cause) {
		super(message, cause);
	}

}
