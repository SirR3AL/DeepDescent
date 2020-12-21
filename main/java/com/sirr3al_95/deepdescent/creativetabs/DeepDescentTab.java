package com.sirr3al_95.deepdescent.creativetabs;

import com.sirr3al_95.deepdescent.init.DeepDescentItems;
import com.sirr3al_95.deepdescent.utilities.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DeepDescentTab extends CreativeTabs
{
	public DeepDescentTab()
	{
		super(Reference.MODID);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(DeepDescentItems.AMETRINE_GEM);
	}
}
