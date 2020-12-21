package com.sirr3al_95.deepdescent.utilities;

import com.sirr3al_95.deepdescent.utilities.handlers.ConfigHandler;
import com.sirr3al_95.deepdescent.world.dimensions.IDimension;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class DDTeleporter extends Teleporter
{
	public int originalHeight;
	public WorldServer originalWorld;
	
	public DDTeleporter(WorldServer worldIn, WorldServer originalWorld, int originalHeight) 
	{
		super(worldIn);
		
		this.originalHeight = originalHeight;
		this.originalWorld = originalWorld;
	}
	
	@Override
	public void placeInPortal(Entity entity, float rotationYaw)
	{
		int i = MathHelper.floor(entity.posX);
		int j = this.originalHeight;
		int k = MathHelper.floor(entity.posZ);
		
		entity.setPosition((double)i + 0.5D, (double)j, (double)k + 0.5D);
		makePortal(entity);
	}
	
	@Override
	public boolean makePortal(Entity entity)
	{
		int i = MathHelper.floor(entity.posX);
		int j = MathHelper.floor(entity.posY);
		int k = MathHelper.floor(entity.posZ);
		
		for(int j1 = j; j1 > (j - 2); --j1)
		{
			if(!this.world.isAirBlock(new BlockPos(i, j1, k)) && this.world.isAirBlock(new BlockPos(i, j1 + 1, k)) && this.world.isAirBlock(new BlockPos(i, j1 + 1, k)))
			{	
				for(int j2 = j; j2 >= (j + 2); ++j2)
				{
					this.world.setBlockToAir(new BlockPos(i, j2, k));
				}	
				entity.setPosition(i + 0.5D, j, k + 0.5D);
				return true;
			}
		}
		
		for(int j1 = j; j1 <= (j + 1); ++j1)
		{
			this.world.setBlockToAir(new BlockPos(i, j1, k));
		}
		return true;
	}

}
