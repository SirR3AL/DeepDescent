package com.sirr3al_95.deepdescent.Items;

import com.sirr3al_95.deepdescent.DeepDescent;
import com.sirr3al_95.deepdescent.init.DeepDescentItems;
import com.sirr3al_95.deepdescent.utilities.IHasModel;

import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeBase extends ItemPickaxe implements IHasModel
{

	protected ItemPickaxeBase(ToolMaterial material, String name) 
	{
		super(material);

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
