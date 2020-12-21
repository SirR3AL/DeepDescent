package com.sirr3al_95.deepdescent.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStalagtite extends BlockBase 
{
	public static final PropertyInteger BLOCK_SIZE= PropertyInteger.create("size", 0, 4);
	
	protected static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[] {new AxisAlignedBB(0.4D, 0.0D, 0.4D, 0.6D, 1.0D, 0.6D), new AxisAlignedBB(0.3D, 0.0D, 0.3D, 0.7D, 1.0D, 0.7D), new AxisAlignedBB(0.2D, 0.0D, 0.2D, 0.8D, 1.0D, 0.8D), new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 1.0D, 0.9D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};
	
	public static final AxisAlignedBB SIZE_E = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	public static final AxisAlignedBB SIZE_D = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 1.0D, 0.9D);
	public static final AxisAlignedBB SIZE_C = new AxisAlignedBB(0.2D, 0.0D, 0.2D, 0.8D, 1.0D, 0.8D);
	public static final AxisAlignedBB SIZE_B = new AxisAlignedBB(0.3D, 0.0D, 0.3D, 0.7D, 1.0D, 0.7D);
	public static final AxisAlignedBB SIZE_A = new AxisAlignedBB(0.4D, 0.0D, 0.4D, 0.6D, 1.0D, 0.6D);
	
	public BlockStalagtite(String name, Material material, float hardness, float resistance, int harvestLevel, SoundType sound, String tool) 
	{
		super(name, material, hardness, resistance, harvestLevel, sound, tool);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(BLOCK_SIZE, Integer.valueOf(0)));
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
    {
        if (!isActualState)
        {
            state = state.getActualState(worldIn, pos);
        }
        
        if(state.getValue(BLOCK_SIZE).intValue() == 0)
        {
        	addCollisionBoxToList(pos, entityBox, collidingBoxes, SIZE_A);
        }
        
        else if(state.getValue(BLOCK_SIZE).intValue() == 1)
        {
        	addCollisionBoxToList(pos, entityBox, collidingBoxes, SIZE_B);
        }
        
        else if(state.getValue(BLOCK_SIZE).intValue() == 2)
        {
        	addCollisionBoxToList(pos, entityBox, collidingBoxes, SIZE_C);
        }
        
        else if(state.getValue(BLOCK_SIZE).intValue() == 3)
        {
        	addCollisionBoxToList(pos, entityBox, collidingBoxes, SIZE_D);
        }
        
        else if(state.getValue(BLOCK_SIZE).intValue() == 4)
        {
        	addCollisionBoxToList(pos, entityBox, collidingBoxes, SIZE_E);
        }
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(BLOCK_SIZE, Integer.valueOf(meta));
    }
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(BLOCK_SIZE)).intValue();
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        state = this.getActualState(state, source, pos);
        return BOUNDING_BOXES[getBoundingBoxIdx(state)];
    }
	
	private static int getBoundingBoxIdx(IBlockState state)
    {
        return state.getValue(BLOCK_SIZE).intValue();
    }
	
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {BLOCK_SIZE});
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty(BLOCK_SIZE, Integer.valueOf(checkAbove(worldIn, pos)));
    }
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (worldIn.isAirBlock(pos.down()))
        {
            worldIn.destroyBlock(pos, true);
        }
    }
	
	public int checkAbove(IBlockAccess world, BlockPos pos)
	{
		int i = 0;
		
		for(; i < 4; i++)
		{	
			if(world.isAirBlock(pos.add(0, i + 1, 0)) && world.getBlockState(pos.add(0, i + 1, 0)).getBlock() != this)
			{	
				return i;
			}
		}
		
		return i;
	}
}
