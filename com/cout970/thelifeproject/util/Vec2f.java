package com.cout970.thelifeproject.util;

public class Vec2f {

	private float x,y;
	
	public Vec2f(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float module(){
		return (float) Math.sqrt(x*x+y*y);
	}
	
	public Vec2f unitary(){
		float m = module();
		return new Vec2f(x/m, y/m);
	}

	public float X() {
		return x;
	}

	public float Y() {
		return y;
	}
}
