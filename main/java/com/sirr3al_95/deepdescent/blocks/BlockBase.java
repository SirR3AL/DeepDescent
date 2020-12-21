package com.sirr3al_95.deepdescent.blocks;

import com.sirr3al_95.deepdescent.DeepDescent;
import com.sirr3al_95.deepdescent.init.DeepDescentBlocks;
import com.sirr3al_95.deepdescent.init.DeepDescentItems;
import com.sirr3al_95.deepdescent.utilities.IHasModel;
import com.sirr3al_95.deepdescent.utilities.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{

	public BlockBase(String name, Material material, float hardness, float resistance, int harvestLevel, SoundType sound, String tool) 
	{
		super(material);
		
		setSoundType(sound);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, harvestLevel);
		setCreativeTab(DeepDescent.DEEP_DESCENT_TAB);
		
		DeepDescentBlocks.BLOCKS.add(this);
		DeepDescentItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void regsiterModels() 
	{
		DeepDescent.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
