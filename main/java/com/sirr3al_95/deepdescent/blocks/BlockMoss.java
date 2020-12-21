package com.sirr3al_95.deepdescent.blocks;

import com.sirr3al_95.deepdescent.DeepDescent;
import com.sirr3al_95.deepdescent.init.DeepDescentBlocks;
import com.sirr3al_95.deepdescent.init.DeepDescentItems;

import net.minecraft.block.BlockVine;
import net.minecraft.item.ItemBlock;

public class BlockMoss extends BlockVine
{
	public BlockMoss(String name)
	{
		super();
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DeepDescent.DEEP_DESCENT_TAB);
		
		DeepDescentBlocks.BLOCKS.add(this);
		DeepDescentItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
}
