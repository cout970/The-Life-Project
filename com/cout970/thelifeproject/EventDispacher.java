package com.cout970.thelifeproject;

import static org.lwjgl.input.Keyboard.*;

import org.lwjgl.LWJGLException;

public class EventDispacher {

	public static int count;
	
	public static void ListenKeyboard() {
		if(!isCreated()){
			try {
				create();
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
		}
		if(count > 0)count--;
		else{
			if(isKeyDown(KEY_A)){
				Main.thePlayer.x--;
				count = 8;
			}
			if(isKeyDown(KEY_D)){
				Main.thePlayer.x++;
				count = 8;
			}
			if(isKeyDown(KEY_W)){
				Main.thePlayer.y++;
				count = 8;
			}
			if(isKeyDown(KEY_S)){
				Main.thePlayer.y--;
				count = 8;
			}
		}		
	}

}
