package com.cout970.thelifeproject.render.models;

import org.newdawn.slick.opengl.Texture;

import com.cout970.thelifeproject.lib.Textures;

public class EntityModelRender implements IModel{

//	@Override
//	public void renderStatic(Vec2 pos, float dim) {}
//
//	@Override
//	public void renderDynamic(Vec2 pos, float dim) {
//		GL11.glPushMatrix();
//		GL11.glColor4f(1, 1, 1, 1);
//		GL11.glBegin(GL11.GL_POINTS);
//		GL11.glTexCoord2f(0, 0);
//		GL11.glVertex2f(pos.X(),pos.Y());
//		GL11.glTexCoord2f(1, 0);
//		GL11.glVertex2f(pos.X()+dim,pos.Y());
//		GL11.glTexCoord2f(1, 1);
//		GL11.glVertex2f(pos.X()+dim,pos.Y()+dim);
//		GL11.glTexCoord2f(0, 1);
//		GL11.glVertex2f(pos.X(),pos.Y()+dim);
//		GL11.glEnd();
//		GL11.glPopMatrix();
//	}

	@Override
	public Texture getTexture() {
		return Textures.entity;
	}
}
