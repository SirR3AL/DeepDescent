package com.sirr3al_95.deepdescent.init;

import java.util.ArrayList;
import java.util.List;

import com.sirr3al_95.deepdescent.blocks.BlockBase;
import com.sirr3al_95.deepdescent.blocks.BlockCrystal;
import com.sirr3al_95.deepdescent.blocks.BlockMoss;
import com.sirr3al_95.deepdescent.blocks.BlockStalagmite;
import com.sirr3al_95.deepdescent.blocks.BlockStalagtite;
import com.sirr3al_95.deepdescent.blocks.DebugBlock;
import com.sirr3al_95.deepdescent.blocks.OreBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DeepDescentBlocks
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Crystals
	public static final Block CRYSTAL_BLOCK = new BlockCrystal("crystal_block");
	
	//Plants
	public static final Block MOSS_BLOCK = new BlockMoss("moss_block");
	
	//Blocks
	public static final Block AQUAMARINE_BLOCK = new BlockBase("aquamarine_block", Material.ROCK, 4.0F, 15.0F, 3, SoundType.STONE, "pickaxe");
	public static final Block SAPPHIRE_BLOCK = new BlockBase("sapphire_block", Material.IRON, 4.0F, 15.0F, 2, SoundType.METAL, "pickaxe");
	public static final Block SILVER_BLOCK = new BlockBase("silver_block", Material.ROCK, 4.0F, 15.0F, 3, SoundType.STONE, "pickaxe");
	public static final Block STALAGTITE = new BlockStalagtite("stalagtite_block", Material.ROCK, 3.0F, 15.0F, 1, SoundType.STONE, "pickaxe");
	public static final Block STALAGMITE = new BlockStalagmite("stalagmite_block", Material.ROCK, 3.0F, 15.0F, 1, SoundType.STONE, "pickaxe");
	
	//Unobtainable Blocks
	public static final Block LEVEL_BARRIER_BLOCK = new BlockBase("level_barrier_block", Material.ROCK, 4.0F, 150000.0F, 6, SoundType.STONE, "pickaxe").setBlockUnbreakable();
	public static final Block DEBUG_BLOCK = new DebugBlock("debug_block", Material.ROCK, 4.0F, 150000.0F, 6, SoundType.STONE, "pickaxe").setBlockUnbreakable();
	
	//Ore Blocks
	public static final Block TIN_ORE_BLOCK = new OreBlock("tin_ore_block", 3.0F, 15.0F, 2, false, 0, 0);
	public static final Block ACANTHITE_ORE_BLOCK = new OreBlock("acanthite_ore_block", 2.0F, 15.0F, 2, false, 0, 0);
	public static final Block SAPPHIRE_ORE_BLOCK = new OreBlock("sapphire_ore_block", 3.0F, 15.0F, 2, true, 3, 6);
	public static final Block AQUAMARINE_ORE_BLOCK = new OreBlock("aquamarine_ore_block", 3.0F, 15.0F, 2, true, 3, 6);
	public static final Block AMETRINE_ORE_BLOCK = new OreBlock("ametrine_ore_block", 4.5F, 15.0F, 3, true, 5, 8);
	public static final Block COPPER_ORE_BLOCK = new OreBlock("copper_ore_block", 3.0F, 15.0F, 2, false, 0, 0);
	public static final Block ALUMINUM_ORE_BLOCK = new OreBlock("aluminum_ore_block", 3.0F, 15.0F, 2, false, 0, 0);
}
