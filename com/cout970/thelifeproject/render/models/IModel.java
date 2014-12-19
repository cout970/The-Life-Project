package com.cout970.thelifeproject.render.models;

import org.newdawn.slick.opengl.Texture;

import com.cout970.thelifeproject.util.Vec2;

public interface IModel {

	public void renderStatic(Vec2 pos,float dim);
	public void renderDynamic(Vec2 pos,float dim);
	public Texture getTexture();
	
}
