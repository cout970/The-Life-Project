package com.cout970.thelifeproject;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.cout970.thelifeproject.lib.Reference;

public class GLManager {

	public static GLManager instance;

	public void InitDisplay(){

		//create display
		try {
			Display.setDisplayMode(new DisplayMode(Reference.frameWidth, Reference.frameHeight));
			Display.setTitle("The Life Project");

			//initialitation OpenGL
			Display.create();

//			GL11.glMatrixMode(GL11.GL_PROJECTION);
//			GL11.glLoadIdentity();
//			GL11.glOrtho(-Reference.frameWidth/2, Reference.frameWidth/2, -Reference.frameHeight/2, Reference.frameHeight/2, 1, -1);
//			GL11.glMatrixMode(GL11.GL_MODELVIEW);
//			GL11.glEnable(GL11.GL_TEXTURE_2D);
//			GL11.glEnable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_TEXTURE_2D);               

			GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);          

			// enable alpha blending
//			GL11.glEnable(GL11.GL_BLEND);
//			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			GL11.glViewport(0,0,Reference.frameWidth,Reference.frameHeight);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);

			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(-Reference.frameWidth/2, Reference.frameWidth/2, -Reference.frameHeight/2, Reference.frameHeight/2, 1, -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);

		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
}
