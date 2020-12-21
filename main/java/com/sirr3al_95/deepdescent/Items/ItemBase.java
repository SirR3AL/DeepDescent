package com.sirr3al_95.deepdescent.Items;

import com.sirr3al_95.deepdescent.DeepDescent;
import com.sirr3al_95.deepdescent.init.DeepDescentItems;
import com.sirr3al_95.deepdescent.utilities.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DeepDescent.DEEP_DESCENT_TAB);
		
		DeepDescentItems.ITEMS.add(this);
	}
	
	@Override
	public void regsiterModels() 
	{
		DeepDescent.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
