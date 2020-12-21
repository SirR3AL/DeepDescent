package com.sirr3al_95.deepdescent.init;

import com.sirr3al_95.deepdescent.utilities.handlers.ConfigHandler;
import com.sirr3al_95.deepdescent.world.dimensions.crystal.WorldProviderCrystal;
import com.sirr3al_95.deepdescent.world.dimensions.drop.WorldProviderDrop;
import com.sirr3al_95.deepdescent.world.dimensions.maze.WorldProviderMaze;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DeepDescentDimensions 
{
	public static final DimensionType DROP = DimensionType.register("Drop", "_drop", ConfigHandler.DROP_DIM_ID, WorldProviderDrop.class, false);
	public static final DimensionType MAZE = DimensionType.register("Maze", "_maze", ConfigHandler.MAZE_DIM_ID, WorldProviderMaze.class, false);
	public static final DimensionType CRYSTAL = DimensionType.register("Crystal", "_crystal", ConfigHandler.CRYSTAL_DIM_ID, WorldProviderCrystal.class, false);
	
	public static final int DROP_MAX_HEIGHT = 205;
	public static final int MAZE_MAX_HEIGHT = 205;
	public static final int CRYSTAL_MAX_HEIGHT = 155;
	
	public static void registerDimensions()
	{
		DimensionManager.registerDimension(ConfigHandler.DROP_DIM_ID, DROP);
		DimensionManager.registerDimension(ConfigHandler.MAZE_DIM_ID, MAZE);
		DimensionManager.registerDimension(ConfigHandler.CRYSTAL_DIM_ID, CRYSTAL);
	}
}
