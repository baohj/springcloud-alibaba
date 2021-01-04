package com.tjgx.common.product.exception;


public class MyException extends RuntimeException {

	public ErrorCode errorCode;

	public MyException(ErrorCode errorCode){
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
