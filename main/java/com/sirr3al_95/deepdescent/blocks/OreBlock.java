package com.sirr3al_95.deepdescent.blocks;

import java.util.Random;

import com.sirr3al_95.deepdescent.init.DeepDescentBlocks;
import com.sirr3al_95.deepdescent.init.DeepDescentItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class OreBlock extends BlockBase
{
	public boolean xp;
	public int minXP;
	public int maxXP;
	
	public OreBlock(String name, float hardness, float resistance, int harvestLevel, boolean xp, int minXP, int maxXP) 
	{
		super(name, Material.ROCK, hardness, resistance, harvestLevel, SoundType.STONE, "pickaxe");
		
		this.xp = xp;
		this.minXP = minXP;
		this.maxXP = maxXP;
	}
	
	@Override
	public boolean canSilkHarvest()
	{
		return true;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return this == DeepDescentBlocks.AMETRINE_ORE_BLOCK ? DeepDescentItems.AMETRINE_GEM : (this == DeepDescentBlocks.AQUAMARINE_ORE_BLOCK ? DeepDescentItems.AQUAMARINE_GEM : (this == DeepDescentBlocks.SAPPHIRE_ORE_BLOCK ? DeepDescentItems.SAPPHIRE_GEM : Item.getItemFromBlock(this)));
	}
}
