package com.cout970.thelifeproject.util;

public class Vec2 {

	private int x,y;
	
	public Vec2(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int Y(){return y;}
	public int X(){return x;}

	public Vec2 divide(int i) {
		return new Vec2(x/i, y/i);
	}
	
	public boolean equals(Object o){
		return o instanceof Vec2 && ((Vec2) o).X() == x && ((Vec2) o).Y() == y;
	}

	public Vec2 multiply(int i) {
		return new Vec2(x*i,y*i);
	}

	public Vec2 add(Vec2 v) {
		return new Vec2(x+v.X(),y+v.Y());
	}
}
