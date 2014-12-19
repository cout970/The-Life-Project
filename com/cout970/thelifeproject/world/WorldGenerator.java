package com.cout970.thelifeproject.world;

import com.cout970.thelifeproject.util.Vec2;

public class WorldGenerator {

	public Chunk generateChunk(World world, Vec2 v) {
		Chunk c = new Chunk(v);
		for(int x =0;x<16;x++){
			for(int y =0;y<16;y++){
				int p = world.rand.nextInt(100);
				int b = 0;
				if(p < 3){
					b = 1;
				}else if(p > 98){
					b = 2; 
				}
				c.setVoxel(new Vec2(x,y), b);
			}
		}
		return c;
	}
}
