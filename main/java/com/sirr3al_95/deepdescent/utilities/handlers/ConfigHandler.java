package com.sirr3al_95.deepdescent.utilities.handlers;

import java.io.File;

import com.sirr3al_95.deepdescent.DeepDescent;
import com.sirr3al_95.deepdescent.utilities.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler 
{
	public static Configuration config;
	
	//Dimension ID's
	public static int DROP_DIM_ID = 101;
	public static int MAZE_DIM_ID = 102;
	public static int CRYSTAL_DIM_ID = 103;
	
	public static int OVERWORLD_HEIGHT = 0;
	
	public static void init(File file)
	{
		config = new Configuration(file);
		 
		String category;
		
		category = "Dimension ID's";
		config.addCustomCategoryComment(category, "Set ID's for each Dimension");
		DROP_DIM_ID = config.getInt("Drop", category, 101, 2, 500, "Dimension ID for Drop");
		MAZE_DIM_ID = config.getInt("Maze", category, 102, 2, 500, "Dimension ID for Maze");
		CRYSTAL_DIM_ID = config.getInt("Crystal", category, 103, 2, 500, "Dimension ID for Crystal");

		
		category = "Miscellaneous";
		config.addCustomCategoryComment(category, "Set mininum height for overworld teleporter");
		OVERWORLD_HEIGHT = config.getInt("Minimum Height", category, 0, 0, 255, "Mininum overworld teleporter height");
		
		
		config.save();
	}
	
	public static void registerConfig(FMLPreInitializationEvent event)
	{
		DeepDescent.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MODID);
		DeepDescent.config.mkdirs();
		
		init(new File(DeepDescent.config.getPath(), Reference.MODID + ".cfg"));
	}
}
