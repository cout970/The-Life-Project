package com.cout970.thelifeproject.entities;

import com.cout970.thelifeproject.world.World;

public class EntityObserver extends Entity{

	public EntityObserver(World w) {
		super(w);
	}
	
	public void update(){
		super.update();
	}

	public int getRenderDistance() {
		return 1;
	}

}
