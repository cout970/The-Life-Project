package com.cout970.thelifeproject.entities;

import com.cout970.thelifeproject.render.models.EntityModelRender;
import com.cout970.thelifeproject.render.models.IModel;
import com.cout970.thelifeproject.world.World;


public class Entity {

	public int x,y;
	public World world;
	public IModel render;
	
	public Entity(World w){
		this.world = w;
	}

	public void update(){
		
	}

	public int[] getPosition() {
		return new int[]{x,y};
	}

	public IModel getModel() {
		if(render == null){
			render = new EntityModelRender();
		}
		return render;
	}
	
}
