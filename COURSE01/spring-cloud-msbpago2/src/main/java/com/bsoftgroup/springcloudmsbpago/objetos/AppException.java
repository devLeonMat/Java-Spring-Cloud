package com.bsoftgroup.springcloudmsbpago.objetos;

public class AppException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public AppException(String message) {
		super(message);
	}
}