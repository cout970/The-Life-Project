package com.cout970.thelifeproject.render;

import org.lwjgl.opengl.GL11;

import com.cout970.thelifeproject.entities.Entity;
import com.cout970.thelifeproject.entities.EntityObserver;
import com.cout970.thelifeproject.lib.Textures;
import com.cout970.thelifeproject.render.models.IModel;
import com.cout970.thelifeproject.util.Logger;
import com.cout970.thelifeproject.util.Vec2;
import com.cout970.thelifeproject.world.Chunk;
import com.cout970.thelifeproject.world.World;

public class RenderManger {

	public static RenderManger instance;
	public World world;
	public EntityObserver player;
	public int lastOcupedList;
	private int scale = 10;
	
	public RenderManger(World w,EntityObserver o){
		world = w;
		player = o;
	}

	public void renderWorld() {
		int radio = player.getRenderDistance();
		for (int i = -radio; i <= radio; i++) {
			for (int j = -radio; j <= radio; j++) {
				Chunk c = world.provider.getChunk(new Vec2((int)Math.ceil(player.x/16),(int)Math.ceil(player.y/16)).add(new Vec2(i, j)));
				
				if(c.hasModifier()){
					c.setRenderList(-1);
					c.setUnModicable();
				}
				if(c.getRenderList() == -1){
					generateCallList(c);
					GL11.glCallList(c.getRenderList());
				}else{
					GL11.glCallList(c.getRenderList());
				}
			}
		}
	}

	private void generateCallList(Chunk c) {
//		Logger.log("Generating call list nº "+lastOcupedList);
		lastOcupedList++;
		GL11.glNewList(lastOcupedList, GL11.GL_COMPILE);
		GL11.glPushMatrix();
		GL11.glColor4f(1, 1, 1, 1);
		GL11.glScalef(scale, scale, 1);
		GL11.glTranslatef(-player.x, -player.y, 0);
		GL11.glBegin(GL11.GL_QUADS);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				IModel m = c.getVoxel(new Vec2(i,j)).getModel();
				m.getTexture().bind();
				Vec2 pos =  c.coords.multiply(16).add(new Vec2(i,j));
				GL11.glTexCoord2f(0, 0);
				GL11.glVertex2f(pos.X(),pos.Y());
				GL11.glTexCoord2f(1, 0);
				GL11.glVertex2f(pos.X()+1,pos.Y());
				GL11.glTexCoord2f(1, 1);
				GL11.glVertex2f(pos.X()+1,pos.Y()+1);
				GL11.glTexCoord2f(0, 1);
				GL11.glVertex2f(pos.X(),pos.Y()+1);
			}
		}
		GL11.glEnd();
		GL11.glPopMatrix();
		GL11.glEndList();
		c.setRenderList(lastOcupedList);
	}

	public void renderEntities() {
		GL11.glPushMatrix();
		GL11.glScalef(scale, scale, 1);
		GL11.glTranslatef(-player.x, -player.y, 0);
		for(Entity t : world.entities){
			if(t instanceof EntityObserver)continue;
			if(Math.abs(t.x - player.x) > (player.getRenderDistance()+1)*16)continue;
			if(Math.abs(t.y - player.y) > (player.getRenderDistance()+1)*16)continue;
			IModel m = t.getModel();
			if(m != null){
				GL11.glBegin(GL11.GL_QUADS);
				Vec2 pos = new Vec2(t.x,t.y);
				Textures.stone.bind();
//				GL11.glBindTexture(GL11.GL_TEXTURE_2D, Textures.stone.getTextureID());
				GL11.glTexCoord2f(0, 0);
				GL11.glVertex2f(pos.X(),pos.Y());
				GL11.glTexCoord2f(1, 0);
				GL11.glVertex2f(pos.X()+1,pos.Y());
				GL11.glTexCoord2f(1, 1);
				GL11.glVertex2f(pos.X()+1,pos.Y()+1);
				GL11.glTexCoord2f(0, 1);
				GL11.glVertex2f(pos.X(),pos.Y()+1);
				GL11.glEnd();
			}
		}
		GL11.glPopMatrix();
	}
}
