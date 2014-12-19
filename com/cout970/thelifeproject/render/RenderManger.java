package com.cout970.thelifeproject.render;

import org.lwjgl.opengl.GL11;

import com.cout970.thelifeproject.entities.Entity;
import com.cout970.thelifeproject.entities.EntityObserver;
import com.cout970.thelifeproject.render.models.IModel;
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
				Chunk c = world.provider.getChunk(new Vec2(player.x/16,player.y/16).add(new Vec2(i, j)));
				
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
		lastOcupedList++;
		GL11.glNewList(lastOcupedList, GL11.GL_COMPILE);
		GL11.glPushMatrix();
		GL11.glScalef(1, 1, 1);
		GL11.glPointSize(scale);
		GL11.glTranslatef(-player.x*scale, -player.y*scale, 0);
		GL11.glColor4f(1, 1, 1, 1);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				IModel m = c.getVoxel(new Vec2(i,j)).getModel();
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, m.getTexture().getTextureID());
				Vec2 position =  c.coords.multiply(16).add(new Vec2(i,j));
				m.renderStatic(position.multiply(scale), scale);
			}
		}
		c.setRenderList(lastOcupedList);
		GL11.glPopMatrix();
		GL11.glEndList();
	}

	public void renderEntities() {
		GL11.glPushMatrix();
		GL11.glScalef(1, 1, 1);
		for(Entity t : world.entities){
			if(t instanceof EntityObserver)continue;
			IModel m = t.getModel();
			if(m != null){
				GL11.glPointSize(12);
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, m.getTexture().getTextureID());
				m.renderDynamic(new Vec2(0 ,0), scale);
			}
		}
		GL11.glPopMatrix();
	}
}
