package com.cout970.thelifeproject.voxel;

import com.cout970.thelifeproject.lib.Textures;
import com.cout970.thelifeproject.render.models.VoxelModelCube;

public class VoxelAir extends Voxel{

	public VoxelAir(){
		super();
		model = new VoxelModelCube(this,Textures.air);
	}
	
	public boolean isSolid(){
		return false;
	}
}
