package com.cout970.thelifeproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import resources.Icons;

import com.cout970.thelifeproject.entities.EntityObserver;
import com.cout970.thelifeproject.lib.Reference;
import com.cout970.thelifeproject.lib.Textures;
import com.cout970.thelifeproject.render.RenderManger;
import com.cout970.thelifeproject.threads.ThreadWork;
import com.cout970.thelifeproject.voxel.Voxel;
import com.cout970.thelifeproject.voxel.VoxelAir;
import com.cout970.thelifeproject.voxel.VoxelStone;
import com.cout970.thelifeproject.voxel.VoxelWood;
import com.cout970.thelifeproject.world.ChunkManager;
import com.cout970.thelifeproject.world.World;

public class Main {

	public static World theWorld;
	public static EntityObserver thePlayer;
	public static ThreadWork calculos;
	public static volatile boolean working = true;

	public static void main(String[] args){
		initGame();
		loadTextures();
		initVoxels();
		calculos = new ThreadWork();
		calculos.start();
		GameLoop();
		calculos.interrupt();
	}
	
	
	public static void GameLoop() {
		while(working){
			working = !Display.isCloseRequested();
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			RenderManger.instance.renderWorld();
			RenderManger.instance.renderEntities();
			EventDispacher.ListenKeyboard();
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	public static void initGame(){
		GLManager.instance = new GLManager();
		GLManager.instance.InitDisplay();
		theWorld = new World();
		theWorld.setWorldProvider(new ChunkManager(theWorld));
		thePlayer = new EntityObserver(theWorld);
		theWorld.spawnEntityinWorld(thePlayer);
		RenderManger.instance = new RenderManger(theWorld,thePlayer);
	}
	
	public static void initVoxels(){
		Voxel.air = new VoxelAir();
		Voxel.stone = new VoxelStone();
		Voxel.wood = new VoxelWood();
	}
	
	public static void loadTextures(){
		Reference.missingTexture = RegisterTexture("default");
		Textures.air = RegisterTexture("air");
		Textures.stone = RegisterTexture("stone");
		Textures.wood = RegisterTexture("wood");
		Textures.entity = RegisterTexture("entity");
	}
	
	public static Texture RegisterTexture(String name){
		try{
			Texture texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(Icons.class.getResource(name+".png").getPath()));
			return texture;
			//TextureLoader.getTexture("png", new FileInputStream(new File("./res/icons/"+name+".png")));
		}catch(Exception e){
			try {
				return TextureLoader.getTexture("png", new FileInputStream(new File(Icons.class.getResource("default.png").getFile())));
				//TextureLoader.getTexture("png", new FileInputStream(new File("./res/icons/default.png")));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
}
