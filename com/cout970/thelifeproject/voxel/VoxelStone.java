package com.cout970.thelifeproject.voxel;

import com.cout970.thelifeproject.lib.Textures;
import com.cout970.thelifeproject.render.models.VoxelModelCube;

public class VoxelStone extends Voxel{

	public VoxelStone(){
		super();
		model = new VoxelModelCube(this,Textures.stone);
	}
}
