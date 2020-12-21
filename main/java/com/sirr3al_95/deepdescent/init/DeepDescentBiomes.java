package com.sirr3al_95.deepdescent.init;

import com.sirr3al_95.deepdescent.world.biomes.BiomeNormalCave;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class DeepDescentBiomes 
{
	public static final Biome DROP = new BiomeNormalCave("Drop");
	public static final Biome MAZE = new BiomeNormalCave("Maze");
	public static final Biome CRYSTAL = new BiomeNormalCave("Crystal");
	
	public static void registerBiomes()
	{
		initBiome(DROP, "Drop", BiomeType.COOL, Type.WET);
		initBiome(MAZE, "Maze", BiomeType.COOL, Type.WET);
		initBiome(CRYSTAL, "Crystal", BiomeType.COOL, Type.WET);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		
		return biome;
	}
}
