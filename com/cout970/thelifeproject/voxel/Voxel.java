package com.cout970.thelifeproject.voxel;

import java.util.ArrayList;
import java.util.List;

import com.cout970.thelifeproject.lib.Reference;
import com.cout970.thelifeproject.render.models.IModel;
import com.cout970.thelifeproject.render.models.VoxelModelCube;

public class Voxel {

	public static List<Voxel> voxels = new ArrayList<Voxel>();
	public static Voxel air;
	public static Voxel stone;
	public static Voxel wood;
	public int ID;
	public IModel model;
	
	public Voxel(){
		voxels.add(this);
		ID = voxels.indexOf(this);
	}
	
	public boolean isSolid(){
		return true;
	}

	public IModel getModel() {
		if(model == null){
			model = new VoxelModelCube(this, Reference.missingTexture);
		}
		return model;
	}
}
