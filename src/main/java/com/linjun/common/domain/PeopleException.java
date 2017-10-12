package com.linjun.common.domain;


import com.linjun.common.BaseException;

public class PeopleException extends BaseException {
	public PeopleException(String code, Object[] args) {
        super("people", code, args, null);
    }

	public PeopleException(String message){
		super("people", message);
	}

	public PeopleException(String code, String message){
		super("people", code, null, message);
	}
}
