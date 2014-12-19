package com.cout970.thelifeproject.util;

public class Infinite2DMap<T> {

	public Map2D<T> posXposY = new Map2D<T>();
	public Map2D<T> posXnegY = new Map2D<T>();
	public Map2D<T> negXposY = new Map2D<T>();
	public Map2D<T> negXnegY = new Map2D<T>();
	
	
	public void addElement(int x, int y,T e){
		if(x >= 0 && y >= 0)posXposY.addToInnerArray(x, y, e);
		if(x < 0  && y < 0)	negXnegY.addToInnerArray(-x-1, -y-1, e);
		if(x < 0  && y >= 0)negXposY.addToInnerArray(-x-1, y, e);
		if(x >= 0 && y < 0)	posXnegY.addToInnerArray(x, -y-1, e);
	}
	
	public void removeElement(int x, int y){
		if(x >= 0 && y >= 0)posXposY.removeE(x, y);
		if(x < 0  && y < 0)	negXnegY.removeE(-x-1, -y-1);
		if(x < 0  && y >= 0)negXposY.removeE(-x-1, y);
		if(x >= 0 && y < 0)	posXnegY.removeE(x, -y-1);
	}
	
	public T getElement(int x, int y){
		if(x >= 0 && y >= 0)return posXposY.getE(x, y);
		if(x < 0  && y < 0 )return negXnegY.getE(-x-1, -y-1);
		if(x < 0  && y >= 0)return negXposY.getE(-x-1, y);
		if(x >= 0 && y < 0 )return posXnegY.getE(x, -y-1);
		return null;
	}
}
