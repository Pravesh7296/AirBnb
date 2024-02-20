package com.Air.Exception;

public class SomethingWentWrong extends Exception{
    public SomethingWentWrong() {
    	
    }
    public SomethingWentWrong(String msg) {
    	super(msg);
    }
}
