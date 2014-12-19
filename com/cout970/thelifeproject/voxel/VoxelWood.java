package com.cout970.thelifeproject.voxel;

import com.cout970.thelifeproject.lib.Textures;
import com.cout970.thelifeproject.render.models.VoxelModelCube;

public class VoxelWood extends Voxel{

	public VoxelWood(){
		super();
		model = new VoxelModelCube(this,Textures.wood);
	}
}
