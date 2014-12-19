package com.cout970.thelifeproject.world;

import java.util.ArrayList;
import java.util.List;

import com.cout970.thelifeproject.util.Infinite2DMap;
import com.cout970.thelifeproject.util.Vec2;

public class ChunkManager implements IChunkProvider{
	
	private Infinite2DMap<Chunk> loadedChunks = new Infinite2DMap<Chunk>();
	private World world;
	public WorldGenerator gen;
	
	public ChunkManager(World theWorld) {
		world = theWorld;
		gen = new WorldGenerator();
	}
	
	@Override
	public Chunk generateChunk(Vec2 coords) {
		Chunk c2 = gen.generateChunk(world,coords);
		Chunk d =  loadedChunks.getElement(coords.X(), coords.Y());
		if(d != null){
			loadedChunks.removeElement(coords.X(),coords.Y());
		}
		loadedChunks.addElement(coords.X(), coords.Y(),c2);
		return c2;
	}

	@Override
	public Chunk getChunk(Vec2 coords) {
		Chunk c =  loadedChunks.getElement(coords.X(), coords.Y());
		if(c == null)c = generateChunk(coords);
		return c;
	}

	@Override
	public void unloadChunk(Vec2 coords) {
		Chunk c = getChunk(coords);
		if(c != null){
			loadedChunks.removeElement(coords.X(),coords.Y());
		}
	}

	@Override
	public List<Chunk> getLoadedChunks() {
		List<Chunk> l = new ArrayList<Chunk>();
		for(int i =0;i<loadedChunks.negXnegY.size();i++)
		l.addAll(loadedChunks.negXnegY.get(i));
		for(int i =0;i<loadedChunks.negXposY.size();i++)
			l.addAll(loadedChunks.negXposY.get(i));
		for(int i =0;i<loadedChunks.posXposY.size();i++)
			l.addAll(loadedChunks.posXposY.get(i));
		for(int i =0;i<loadedChunks.posXnegY.size();i++)
			l.addAll(loadedChunks.posXnegY.get(i));
		return l;
	}

}
