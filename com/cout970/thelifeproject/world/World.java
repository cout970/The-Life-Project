package com.cout970.thelifeproject.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cout970.thelifeproject.entities.Entity;
import com.cout970.thelifeproject.entities.EntityIA;
import com.cout970.thelifeproject.util.Vec2;
import com.cout970.thelifeproject.voxel.Voxel;

public class World {

	public long worldTime = -1;
	public IChunkProvider provider;
	public List<Entity> entities = new ArrayList<Entity>();
	public Random rand;
	
	public World(){
		rand = new Random();
	}
	
	public void setWorldProvider(IChunkProvider p){
		provider = p;
	}
	
	public void updateTick() {
		for(Entity e : entities){
			e.update();
		}
		
		updateWorldLoading();
		worldTime++;
	}

	private void updateWorldLoading() {
		if(worldTime == 0){
			for(int x=-5;x<6;x++){
				for(int y=-5;y<6;y++){
					provider.generateChunk(new Vec2(x,y));
				}
			}
			this.spawnEntityinWorld(new EntityIA(this));
			this.spawnEntityinWorld(new EntityIA(this));

		}
	}

	public Voxel getVoxel(Vec2 coords){
		Chunk c = provider.getChunk(coords.divide(16));
		if(c == null)provider.generateChunk(coords.divide(16));
		return c.getVoxel(coords);
	}
	
	public void setVoxel(Vec2 coords,Voxel tipe){
		if(tipe == null)return;
		Chunk c = provider.getChunk(coords.divide(16));
		if(c == null){
			provider.generateChunk(coords.divide(16));
			c = provider.getChunk(coords.divide(16));
		}
		
		c.setVoxel(coords,tipe.ID);
	}

	public void spawnEntityinWorld(Entity e) {
		entities.add(e);
	}

}
