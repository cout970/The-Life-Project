package com.cout970.thelifeproject.threads;

import com.cout970.thelifeproject.Main;


public class ThreadWork extends Thread{

	public void run() {
		while(Main.working){
			Main.theWorld.updateTick();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
