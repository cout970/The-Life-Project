package com.cout970.thelifeproject.world;

import java.util.List;

import com.cout970.thelifeproject.util.Vec2;

public interface IChunkProvider {

	public Chunk generateChunk(Vec2 coords);
	
	public Chunk getChunk(Vec2 coords);
	
	public void unloadChunk(Vec2 coords);

	public List<Chunk> getLoadedChunks();
}
