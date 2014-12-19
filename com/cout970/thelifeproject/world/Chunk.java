package com.cout970.thelifeproject.world;

import com.cout970.thelifeproject.util.Vec2;
import com.cout970.thelifeproject.voxel.Voxel;

public class Chunk {

	public Vec2 coords;
	
	public int[][] data = new int[16][16];

	private int callList = -1;

	private boolean modif = true;
	
	public Chunk(Vec2 c){
		coords = c;
	}
	
	//relative coords
	public Voxel getVoxel(Vec2 coords){
		modif = true;
		return Voxel.voxels.get(data[coords.X()%16][coords.Y()%16]);
	}
	
	public void setVoxel(Vec2 coords,int id){
		data[coords.X()%16][coords.Y()%16] = id;
		modif = true;
	}

	public int getRenderList() {
		return callList;
	}

	public void setRenderList(int l) {
		callList = l;
	}

	public boolean hasModifier() {
		return modif;
	}

	public void setUnModicable() {
		modif = false;
	}
}
