package com.sirr3al_95.deepdescent.blocks;

import java.util.Random;

import com.sirr3al_95.deepdescent.world.worldgen.WorldGenCrystalFormation;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DebugBlock extends BlockBase
{
	private WorldGenerator debug;
	
	public DebugBlock(String name, Material material, float hardness, float resistance, int harvestLevel, SoundType sound, String tool) 
	{
		super(name, material, hardness, resistance, harvestLevel, sound, tool);
		this.debug = new WorldGenCrystalFormation();
	}

	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
		Random rand = new Random();
		
		this.debug.generate(worldIn, rand, pos);
    }

}
