package com.cout970.thelifeproject.util;

import java.util.ArrayList;

public class Map2D <T> extends ArrayList<ArrayList<T>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1261375571465676564L;

	public void addToInnerArray(int index, T element) {
        while (index >= this.size()) {
            this.add(new ArrayList<T>());
        }
        this.get(index).add(element);
    }

    public void addToInnerArray(int index, int index2, T element) {
        while (index >= this.size()) {
            this.add(new ArrayList<T>());
        }

        ArrayList<T> inner = this.get(index);
        while (index2 >= inner.size()) {
            inner.add(null);
        }

        inner.set(index2, element);
    }
    
    public T getE(int x, int y){
    	
    	if(x >= size())return null;
    	if(get(x) == null || y >= get(x).size())return null;
    	return get(x).get(y);
    }
    
    public void removeE(int x, int y){
    	if(x >= size())return;
    	if(get(x) == null || y >= get(x).size())return;
    	get(x).remove(y);
    }
}