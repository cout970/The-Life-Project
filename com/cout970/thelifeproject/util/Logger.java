package com.cout970.thelifeproject.util;

public class Logger {

	public static void log(String s){
		String info = "[Debug]:"+s;
		System.out.println(info);
	}

	public static void debug(Object l) {
		if(false)
		log(String.valueOf(l));
	}
}
